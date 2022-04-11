<template>
    <div id="userInfoManage">
        <div class="title">用户信息 </div>
        <div class="formDiv">
            <div style="float:left;width:150px;height:25px;margin-left:-40px">我的资料</div>
            <div style="float:left;heiht:50px;width:100px; margin-top:25px;margin-left:-105px">
               <img alt="加载失败" src="./user01.png">
            </div>
            <div style="margin-top:160px">
                <el-form :model="userForm"  label-position="left">
                    <el-form-item label="姓名" >
                        <el-input style="width:1240px;margin-left:30px" v-model="userForm.nameUser" clearable></el-input>
                    </el-form-item>
                    <el-form-item label="身份" >
                        <span style="float:left;margin-left:50px">{{identity}}</span>
                    </el-form-item>
                     <el-form-item label="个人简介">
                        <el-input v-model="userForm.content" clearable  style="width:240px;"></el-input>
                    </el-form-item>
                     <el-form-item label="邮箱地址">
                        <el-input v-model="userForm.email" clearable style="width:240px;" type="textarea"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="userForm.password" clearable type="password" style="width:1240px;margin-left:30px"></el-input>
                    </el-form-item>
                    <el-button style="float:left" type="primary" size="small" @click="publish">保存</el-button>
                   
                </el-form>
            </div>
            
        </div>
    </div>
</template>

,<script>
export default {
    data(){
        return{
            userForm:{},
            identity:''
        }
    },

   methods:{
       publish(){
           console.log('ss',this.userForm)
           delete this.userForm.menus
           delete this.userForm.roleInfos
           delete this.userForm.top
           this.$http.http_post(this,this.$api.user.updateUser,this.userForm,true,(res)=>{
               if(res.code == 1){
                   this.getCurrentUser(res.object.id)
               }
           })
       },
       
       getCurrentUser(id){
           this.$http.http_post(this,this.$api.user.findIdUser,{id:id},false,(res)=>{
               if(res.code == 1){
                   this.userForm = res.object
               }
           })
       },
    },

    created(){
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        this.identity = userInfo.top.roleName
        this.getCurrentUser(userInfo.id)
    }

}
</script>

<style scoped>
    .title{
        width: 150px;
        height: 30px;
        margin-bottom: 15px;
        font-size: 20px;
        font-weight: bolder;
        opacity: 0.6;
    }
    .formDiv{
        padding: 10px;
        border: 1px solid rgb(197, 194, 194);
        height: 540px;
    }
</style>