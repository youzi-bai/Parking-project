<template>
    <div id="commenHeader">
         <div style="float:left;padding-top:10px">
             <img width="200px;height:40px" src="./logo.jpg"/>
             </div>
         <div class="leftInfo" style="">小白停车场</div>
         <div class="rightInfo" style="margin-top:50px">
             <el-dropdown >
                <div class="userName">当前用户:{{userInfo.nameUser}}</div>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="exit">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
             <el-image src="/static/admin/assets/img/user01.png" style="width:40px;height:45px;margin-top:8px"></el-image>
            
         </div>
    </div>
</template>

<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="/static/admin/assets/js/amazeui.min.js"></script>
<script src="/static/admin/assets/js/app.js"></script>
<script>
export default {
    data(){
        return{
            userInfo:{}
        }
    },
    methods:{
        getUserInfo(){
           this.userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        },

        exit(){
            sessionStorage.clear()
            this.$router.push({path:'/login'})
        }
    },
    created(){
        this.getUserInfo()
    }
}
</script>

<style scoped>
   /* @import '/static/admin/assets/css/admin.css';
   @import '/static/admin/assets/css/app.css';
   @import '/static/admin/assets/css/amazeui.min.css';
   @import '/static/admin/assets/css/amazeui.min.css'; */
   #commenHeader{
       /* display: flex; */
      
   }
   div .leftInfo{
       float: left;
       margin-top:50px;margin-left:-180px;
       font-weight: bolder;
   }
   div .rightInfo{
       width: 200px;
       float: right;
       display: flex
   }

   div .userName{
       margin-right: 15px;
       font-size: 14px;
       font-weight: bolder;
       opacity: 0.7;
       cursor: pointer;
   }
</style>