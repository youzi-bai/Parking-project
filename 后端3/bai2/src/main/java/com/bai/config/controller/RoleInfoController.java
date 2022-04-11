package com.bai.config.controller;

import com.alibaba.fastjson.JSONObject;
import com.bai.config.entity.CommenResult;
import com.bai.config.entity.RoleInfo;
import com.bai.config.entity.RoleMenu;
import com.bai.config.service.RoleInfoService;
import com.bai.config.service.RoleMenuService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 角色管理
 * @author
 * @version 1.0
 * 版权所有：
 * @className RoleInfoController
 * @projectName graduation
 * @date 2022/3/28
 */

@RestController
@RequestMapping("/role")
public class RoleInfoController {

    @Resource
    private RoleInfoService roleInfoService;

    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 保存角色
     * @param
     * @return
     */
    @PostMapping("/publish")
    public CommenResult publish(RoleInfo roleInfo){

        try{


            if (roleInfo.getId()==null){

                roleInfo.setSubTime(new Date());

                return roleInfoService.insertRole(roleInfo) ? CommenResult.success("新增成功",null,0) : CommenResult.error("新增失败");

            }else {
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 配置菜单和权限
     * @param menuJson
     * @return
     */
    @PostMapping("/config/menu")
    public CommenResult configMenu(@RequestParam String menuJson){

        try{


            RoleMenu roleMenu =  JSONObject.parseObject(menuJson,RoleMenu.class);

            roleMenu.setSubTime(new Date());

            return roleMenuService.insertRoleMenu(roleMenu) ? CommenResult.success("配置成功",null,0) : CommenResult.error("配置失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    public CommenResult<Object> remove(@PathVariable("id") Integer id){

        try{

            RoleInfo roleInfo = roleInfoService.findById(id);

            if (roleInfo == null)
                return CommenResult.error("角色信息不存在");

            return roleInfoService.removeRole(id) ? CommenResult.success("保存成功",null,0) : CommenResult.error("保存失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 查询角色列表
     * @return
     */
    @PostMapping("/find/all")
    public CommenResult<List<RoleInfo>> findAll(String roleName){

        try{

            Map<String,Object> ps = new HashMap<>();
            ps.put("roleName",roleName);

            List<RoleInfo> roleInfos = roleInfoService.findAll(ps);

            //查菜单
            roleInfos.forEach(item ->{
                Map<String,Object> params = new HashMap<>();
                params.put("roleId",item.getId());
                List<RoleMenu> roleMenus = roleMenuService.findByCondition(params);
                item.setRoleMenus(roleMenus);
            });
            return roleInfos.size()>0 ? CommenResult.success("查询成功",roleInfos,roleInfos.size()) : CommenResult.error("查询失败");

        }catch (Exception e){

            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }


}
