package com.bai.config.controller;

import com.alibaba.fastjson.JSONObject;
import com.bai.config.dao.UserInfoDao;
import com.bai.config.entity.*;

import com.bai.config.service.*;
import org.apache.catalina.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleInfoService roleInfoService;

    @Resource
    private RoleMenuService roleMenuService;

    @Resource
    private MenuInfoService menuInfoService;

    @Resource
    private UserInfoDao userInfoDao;

    //通过主键id查询
//    @PostMapping("/selectByPrimaryKey")
//    //泛型
//    public CommenResult<UserInfo> selectUserById(@RequestBody HashMap<String, Integer> hashMap){
//        CommenResult<UserInfo> commenResult = new CommenResult<>("success", true, null);
//        Integer idUser = hashMap.get("idUser");
//        UserInfo userInfo = userInfoService.selectByPrimaryKey(idUser);
//        commenResult.setData(userInfo);
//        return commenResult;
//    }



    @GetMapping("/selectByPrimaryKey")
    public CommenResult<UserInfo> selectUserById(Integer idUser){

        try{

            UserInfo userInfo = userInfoService.selectByPrimaryKey(idUser);

            if (userInfo == null)
                return new CommenResult<>("当前用户信息不存在",false,null);

            List<UserRole> urs = userRoleService.findByUser(idUser);

            //查角色信息
            List<RoleInfo> roleInfos = new ArrayList<>();
            urs.forEach(item ->{
                RoleInfo roleInfo = roleInfoService.findById(item.getRoleId());
                roleInfos.add(roleInfo);
            });

            userInfo.setRoleInfos(roleInfos);

            return new CommenResult<>("查询成功",true,userInfo);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new CommenResult<>("服务器开小差",false,null);
    }

    @GetMapping("/selectAllUser")
    public CommenResult<List<UserInfo>> selectAllUser(){
        CommenResult<List<UserInfo>> commenResult = new CommenResult<>("success", true, null);
        List<UserInfo> users = userInfoService.selectAllUser(new HashMap<>());
        commenResult.setData(users);
        return commenResult;
    }


    /**
     * 保存用户
     * @param userJson
     * @return
     */
    @PostMapping("/publish")
    public CommenResult<UserInfo> updateByPrimaryKey(@RequestParam String userJson){

        try{

            JSONObject object = JSONObject.parseObject(userJson);

            UserInfo userInfo = new UserInfo();

            if (object!=null){

                userInfo.setNameUser(object.getString("nameUser"));
                userInfo.setIponeUser(object.getString("iponeUser"));
                userInfo.setAddressUser(object.getString("addressUser"));
                userInfo.setGenderUser(object.getString("genderUser"));
                userInfo.setContent(object.getString("content"));
                userInfo.setPhone(object.getString("phone"));
                userInfo.setEmail(object.getString("email"));

                if (StringUtils.isEmpty(object.getInteger("id"))){
                    //新增 默认生成密码
                    userInfo.setCreateTime(new Date());
                    userInfo.setPassword("123456");

                    //处理角色集合
                    if (!StringUtils.isEmpty(object.getString("roleList"))){
                        List<RoleInfo> roleInfos = JSONObject.parseArray(object.getString("roleList"),RoleInfo.class);
                        userInfo.setRoleInfos(roleInfos);
                    }

                    userInfoService.publishUserInfo(userInfo);

                }else {

                   UserInfo  src = userInfoDao.findById(object.getInteger("id"));
                    if (src == null)
                        return CommenResult.error("当前用户信息不存在");

                   userInfo.setId(src.getId());
                   userInfo.setPassword(src.getPassword());

                    //修改 用户可能修改角色
                    //处理角色集合
                    if (!StringUtils.isEmpty(object.getString("roleList"))){
                        List<RoleInfo> roleInfos = JSONObject.parseArray(object.getString("roleList"),RoleInfo.class);
                        userInfo.setRoleInfos(roleInfos);
                    }

                    userInfoService.updateUser(userInfo);

                }

                return CommenResult.success("保存成功",null,0);

            }else {
                return CommenResult.error("数据传输错误");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return new CommenResult<>("服务器开小差",false,null);
    }

    /**
     * 条件查询用户
     * @param nameUser
     * @return
     */
    @PostMapping("/find/all")
    public CommenResult findAll(String nameUser){

        try{

            Map<String,Object> params = new HashMap<>();
            params.put("nameUser",nameUser);

            List<UserInfo> userInfos = userInfoService.selectAllUser(params);

            userInfos.forEach(item ->{

                List<RoleInfo> roleInfos = new ArrayList<>();

                //根据用户角色关系查角色
                List<UserRole> userRoles = userRoleService.findByUser(item.getId());
                userRoles.forEach(item_A ->{
                    int rid =item_A.getRoleId();
                    RoleInfo roleInfo = roleInfoService.findById(rid);

                    //根据角色查菜单和权限
                    Map<String,Object> params_A = new HashMap<>();
                    params_A.put("roleId",roleInfo.getId());
                    List<RoleMenu> roleMenus = roleMenuService.findByCondition(params_A);

                    //装入菜单和权限
                    roleInfo.setRoleMenus(roleMenus);
                    roleInfos.add(roleInfo);
                });

                //为用户装入角色
                item.setRoleInfos(roleInfos);
            });

            return userInfos.size()>0 ? CommenResult.success("查询成功",userInfos,userInfos.size()) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public CommenResult regist(String nameUser,String password){

        try{

            UserInfo userInfo = userInfoService.findBySame(nameUser);

            if (userInfo!=null)
                return CommenResult.error("当前用户已存在，请重新填写账号信息");

            userInfo = new UserInfo();
            userInfo.setNameUser(nameUser);
            userInfo.setPassword(password);
            userInfo.setCreateTime(new Date());

            return userInfoService.publishUserInfo(userInfo) ? CommenResult.success("注册成功",null,0):CommenResult.error("注册失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");

    }

    /**
     * 登陆
     * @param nameUser
     * @param password
     * @return
     */
    @PostMapping("/login")
    public CommenResult<UserInfo> login(String nameUser,String password){
        try{

           UserInfo userInfo =  userInfoService.login(nameUser,password);

           CommenResult<UserInfo> result = null;

           if (userInfo==null){
               result = new CommenResult<>("账号密码错误",false,null);
           }else {

               //查角色、菜单、权限
               List<UserRole> userRoles = userRoleService.findByUser(userInfo.getId());
               userRoles.forEach(item ->{
                   RoleInfo ri = roleInfoService.findById(item.getRoleId());
                   if (ri!=null){
                       userInfo.setTop(ri);
                   }
               });

               List<Map<String,Object>> pers = new ArrayList<>();

               //查此角色对应的所有菜单
               if (userInfo.getTop()!=null){
                   RoleInfo current = userInfo.getTop();
                   Map<String,Object> params = new HashMap<>();
                   params.put("roleId",current.getId());
                   List<RoleMenu> roleMenus = roleMenuService.findByCondition(params);

                   //再查出菜单的信息
                   roleMenus.forEach(item ->{
                       MenuInfo menuInfo = menuInfoService.findById(item.getMenuId());

                       Map<String,Object> map = new HashMap<>();
                       map.put("menu",menuInfo.getName());
                       map.put("path",menuInfo.getPath());
                       map.put("icon",menuInfo.getIcon());
                       map.put("pers",item.getPerName());

                       pers.add(map);
                   });

                   userInfo.setMenus(pers);
               }else {
                   userInfo.setMenus(null);
               }

               result = new CommenResult<>("登陆成功",true,userInfo);

           }

           return result;

        }catch (Exception e){
            e.printStackTrace();
        }

        return new CommenResult<>("服务器开小差",false,null);
    }

    /**
     * 修改密码
     * @param nameUser
     * @param email
     * @param password
     * @return
     */
    @PostMapping("/update/pwd")
    public CommenResult updatePwd(String nameUser,String email, String password){

        try{

            UserInfo userInfo = userInfoService.findBySame(nameUser);

            if (userInfo == null)
                return CommenResult.error("当前用户不存在，请检查账号信息");

            boolean res_A = userInfoService.updatePwd(password,userInfo.getId());

            return res_A ? CommenResult.success("修改密码成功",null,0) : CommenResult.error("修改密码失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }


    /**
     * 保存自己的信息
     * @param userInfo
     * @return
     */
    @PostMapping("/publish/mine")
    public CommenResult publishMine(UserInfo userInfo){

        try{

            if (userInfo.getId()==null){
                return CommenResult.error("当前用户信息不存在");
            }else {
                boolean res =userInfoDao.updateUser(userInfo);

                return  res ? CommenResult.success("修改成功",userInfo,0) : CommenResult.error("修改失败");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    @PostMapping("/find/byId")
    public CommenResult findById(Integer id){

        try{

            UserInfo userInfo = userInfoDao.findById(id);

            return userInfo!=null ? CommenResult.success("查询成功",userInfo,0) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }
}
