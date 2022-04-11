package com.bai.config.controller;

import com.bai.config.entity.CommenResult;
import com.bai.config.entity.MenuInfo;
import com.bai.config.service.MenuInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/menu")
public class MenuInfoController {

    @Resource
    private MenuInfoService menuInfoService;

    /**
     * 保存菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("/publish")
    public CommenResult publish(MenuInfo menuInfo){

        try{

            boolean res = false;
            //新增
            if (menuInfo.getId()==null){

                menuInfo.setSubTime(new Date());
                res = menuInfoService.insertMenu(menuInfo);

            }else {
                //修改
               res = menuInfoService.updateMenu(menuInfo);

            }

            return res ? CommenResult.success("保存成功",null,0) : CommenResult.error("保存失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    public CommenResult remove(@PathVariable("id") Integer id){

        try{

            MenuInfo menuInfo = menuInfoService.findById(id);

            if (menuInfo == null)
                return CommenResult.error("当前菜单不存在");

            return menuInfoService.removeMenu(id) ? CommenResult.success("删除成功",null,0) : CommenResult.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 查询所有菜单
     * @return
     */
    @PostMapping("/find/all")
    public CommenResult findAll(String name){

        try{

            Map<String,Object> params = new HashMap<>();
            params.put("name",name);

            List<MenuInfo> menuInfos = menuInfoService.findByAll(params);

            return menuInfos.size()>0 ? CommenResult.success("查询成功",menuInfos,menuInfos.size()) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");

    }

    /**
     * 按id查菜单
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public CommenResult findById(@PathVariable("id") Integer id){

        try{

            MenuInfo menuInfo = menuInfoService.findById(id);

            if (menuInfo == null)
                return CommenResult.error("当前菜单不存在");

            return CommenResult.success("查询成功",menuInfo,0);

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

}
