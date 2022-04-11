<template>
    <div id="admin">
         <!-- <iframe  src="static/admin/index.html"  style="width:100%;height:100%;"
         frameborder=no  border=0  marginwidth=0  marginheight=0  scrolling=no></iframe> -->
         <el-container>
            <el-header style="height:100%;">
                <commen-header></commen-header>
            </el-header>
            <el-container>
                <el-aside width="180px">
                  <el-menu :default-active="activeIndex" mode="vertical" background-color="#545c64" 
                    text-color="#fff" active-text-color="#ffd04b" @select="selectMenu">
      
                    <el-menu-item index="1" style="margin-left:-20px">
                      <template slot="title">
                        <i class="el-icon-s-order"></i>
                        <span>首页</span>
                      </template>
                    </el-menu-item>
                    <el-submenu index="2">
                      <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>权限管理</span>
                      </template>
                      <el-menu-item v-for="(item,index) in menuList " :key="index" :index="item.path">
                        {{item.menu}}
                      </el-menu-item>
                    </el-submenu>  
                    <el-menu-item index="3" style="margin-left:-20px">
                      <template slot="title">
                        <i class="el-icon-s-order"></i>
                        <span>用户信息</span>
                      </template>
                    </el-menu-item>      
                  </el-menu>
                </el-aside>
                <el-main>
                  <home-manage v-if="activeIndex==1"></home-manage>
                  <menu-manage v-if="activeIndex=='/menuManage'"></menu-manage>
                  <permission-manage v-if="activeIndex=='/perManage'"></permission-manage>
                  <role-manage v-if="activeIndex=='/roleManage'"></role-manage>
                  <user-manage v-if="activeIndex=='/userManage'"></user-manage>
                  <park-manage v-if="activeIndex=='/parkingManage'"></park-manage>
                  <car-manage v-if="activeIndex=='/carManage'"></car-manage>
                  <user-info-manage v-if="activeIndex ==3"></user-info-manage>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import CommenHeader from '../public/commenHeader.vue'
import MenuManage from './menuManage.vue'
import ParkManage from './parkManage.vue'
import PermissionManage from './permissionManage.vue'
import RoleManage from './roleManage.vue'
import UserManage from './userManage.vue'
import CarManage from './carManage.vue'
import HomeManage from './homeManage.vue'
import UserInfoManage from './userInfoManage.vue'




export default {
    components: {CommenHeader, MenuManage,PermissionManage, RoleManage, UserManage, ParkManage,CarManage, HomeManage, UserInfoManage},
    data(){
        return{
          activeIndex:"",
          menuList:[],
          permission:[]
        }
    },
    methods:{
      selectMenu(val){
        console.log('???',val)
        this.activeIndex = val
        
      }
    },
    created(){ 
      console.log(window.location)
     
      //刷新页面
      //加载时获取用户信息，判断菜单和权限
      const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
      this.menuList = userInfo.menus
      if(this.menuList==null || this.menuList.length==0){
          this.$alert('当前用户还未分配角色，可登陆系统管理员角色为其配置角色菜单', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              
            }
          });
          return
      }else{
        //设默认加载模块
        this.activeIndex = this.menuList[0].path
      }
      

    }
}
</script>

<style scoped>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

 
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    /* line-height: 100px; */
  }
  
  .el-main {
    /* background-color: #E9EEF3; */
     background-color: #e5edf5;
    color: #333;
    text-align: center;
    /* line-height: 160px; */
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    /* line-height: 260px; */
  }
  
  .el-container:nth-child(7) .el-aside {
    /* line-height: 320px; */
  }
</style>