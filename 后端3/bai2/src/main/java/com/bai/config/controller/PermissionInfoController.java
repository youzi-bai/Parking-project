package com.bai.config.controller;

import com.bai.config.entity.CommenResult;
import com.bai.config.entity.PermissionInfo;
import com.bai.config.entity.RoleMenu;
import com.bai.config.service.PermissionInfoService;
import com.bai.config.service.RoleMenuService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.*;


@RestController
@RequestMapping("/permission")
public class PermissionInfoController {

    @Resource
    private PermissionInfoService permissionInfoService;

    @Resource
    private RoleMenuService roleMenuService;


    /**
     * 保存权限
     * @param permissionInfo
     * @return
     */
    @PostMapping("/publish")
    public CommenResult publish(PermissionInfo permissionInfo){

        try{

            boolean res = false;
            //新增
            if (permissionInfo.getId()==null){

                permissionInfo.setSubTime(new Date());
                res = permissionInfoService.insertPer(permissionInfo);

            }else {
                //修改

                //修改角色菜单关联表里的信息
                List<RoleMenu> maps = new ArrayList<>();
                List<RoleMenu> roleMenus = roleMenuService.findByCondition(null);
                roleMenus.forEach(item ->{
                    StringBuffer sb = new StringBuffer();
                    String[] perIds = item.getPerId().split(",");
                    String[] perNames = item.getPerName().split(",");
//                    Map<String,Object> destMap = new HashMap<>();
//                    destMap.put("id",item.getId());
//                    destMap.put("data","");
                    for (int i=0;i<perIds.length;i++){
                        if (String.valueOf(permissionInfo.getId()).equals(perIds[i])){
                            perNames[i] = permissionInfo.getName();
                            //转换为字符串
                            String dest = "";
                            for (int j=0;j<perNames.length;j++){
                               if (j==perNames.length-1){
                                   dest += perNames[j];
                               }else {
                                   dest += perNames[j]+",";
                               }
                            }
//                            destMap.put("data",dest);
                            item.setPerName(dest);
                            maps.add(item);
                            break;
                        }
                    }
                });

                maps.forEach(item ->{
                   roleMenuService.updateRoleMenu(item);
                });

                res = permissionInfoService.updatePer(permissionInfo);

            }

            return res ? CommenResult.success("保存成功",null,0) : CommenResult.error("保存失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    public CommenResult remove(@PathVariable("id") Integer id){

        try{

            PermissionInfo permissionInfo = permissionInfoService.findById(id);

            if (permissionInfo == null)
                return CommenResult.error("当前菜单不存在");

            return permissionInfoService.removePer(id) ? CommenResult.success("删除成功",null,0) : CommenResult.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 查询所有权限
     * @return
     */
    @PostMapping("/find/all")
    public CommenResult findAll(String name){

        try{

            Map<String,Object> params = new HashMap<>();
            params.put("name",name);

            List<PermissionInfo> permissionInfos = permissionInfoService.findAll(params);

            return permissionInfos.size()>0 ? CommenResult.success("查询成功",permissionInfos,permissionInfos.size()) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");

    }

    /**
     * 按id查权限
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public CommenResult findById(@PathVariable("id") Integer id){

        try{

            PermissionInfo permissionInfo = permissionInfoService.findById(id);

            if (permissionInfo == null)
                return CommenResult.error("当前菜单不存在");

            return CommenResult.success("查询成功",permissionInfo,0);

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }
}
