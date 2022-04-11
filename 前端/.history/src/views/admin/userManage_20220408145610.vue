<template>
    <div id="userManage">
        <div style="display:flex">
            <div >
                <el-form class="mgtop10" :model="searchForm"  :inline="true" label-width="80px" label-position="right">
                    <el-form-item label="用户名称">
                        <el-input v-model="searchForm.nameUser"></el-input>
                    </el-form-item>
                </el-form>
            </div>
            <div  style="margin-left:10px">
                <el-button icon="el-icon-search" type="primary" @click="doSearch">查询</el-button>
                <el-button icon="el-icon-plus" @click="add" :disabled="!addPermission">新增</el-button>
            </div>
        </div>

        <!-- 列表 -->
        <el-table  stripe :data="tableData" border style="width: 100%" 
			:header-cell-style="{'background-color': '#f5f5f5','color': '#606266','border-bottom':'solid 1px #d2d3da'}">
			<el-table-column label="用户名称" prop="nameUser" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-user-solid"></i>
                    <span style="margin-left: 10px">{{ scope.row.nameUser }}</span>
                </template>
            </el-table-column>
            <el-table-column label="用户角色" prop="nameUser" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-user-solid"></i>
                    <span style="margin-left: 10px">{{ scope.row.nameUser }}</span>
                </template>
            </el-table-column>
            <el-table-column label="用户地址" prop="addressUser" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-s-home"></i>
                    <span style="margin-left: 10px">{{ scope.row.addressUser }}</span>
                </template>
            </el-table-column>
            <el-table-column label="手机号" prop="iponeUser" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-phone-outline"></i>
                    <span style="margin-left: 10px">{{ scope.row.iponeUser }}</span>
                </template>
            </el-table-column>
            <el-table-column label="性别" prop="genderUser" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-s-custom"></i>
                    <span style="margin-left: 10px">{{ scope.row.genderUser }}</span>
                </template>
            </el-table-column>
            <!-- <el-table-column label="拥有角色" align="center">
                <template slot-scope="scope">
                    <div v-for="(item,index) in (scope.row.UserMenus)" :key="index">
                        <el-tag>{{item.menuName}}</el-tag>
                    </div>
                </template>
            </el-table-column> -->
            
            <el-table-column label="创建时间" prop="createTime" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" prop="" width="200px">
                <template slot-scope="scope">
                    <el-button size="mini" type="success" @click="edit(scope.row)" :disabled="!editPermission" icon="el-icon-edit">编辑</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.idUser)" :disabled="!removePermission" icon="el-icon-delete">删除</el-button>
                </template>
            </el-table-column>
		</el-table>

        <!-- 新增弹框 -->
        <el-dialog :visible.sync="addDialog" width="65%"  :title="dialogTitle">
            <el-form  :model="publishForm" inline >
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label="账号" label-width="110px">
                                <el-input v-model="publishForm.nameUser" ></el-input>
                            </el-form-item>
                            <el-form-item label="手机号" label-width="110px">
                                <el-input v-model="publishForm.iponeUser" ></el-input>
                            </el-form-item>
                            <el-form-item label="性别" label-width="110px">
                                <el-input v-model="publishForm.genderUser" ></el-input>
                            </el-form-item>
                        </el-col>

                        <el-col :span="9">
                            <el-form-item label="地址" label-width="110px">
                                <el-input v-model="publishForm.addressUser" ></el-input>
                            </el-form-item>
                            <el-form-item label="角色分配" label-width="110px">
                                <el-select v-model="publishForm.roleId" @input="$forceUpdate()">
                                    <el-option v-for="(item,index) in roles" :key="index" :value="item.id" :label="item.roleName"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="邮箱地址" label-width="110px">
                                <el-input v-model="publishForm.email" ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row style="">
                        <el-col :span="17">
                            <el-form-item label="个人简介" label-width="120px">
                                <el-input v-model="publishForm.content" type="textarea" rows="4" style="width:550px"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialog = false">取 消</el-button>
                <el-button type="primary" @click="publishUser">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    data(){
        return{
            searchForm:{
                page:1,
                pageSize:10,
                total:0
            },
            addDialog:false,
            dialogTitle:'',
            publishForm:{},
            tableData:[],
            roles:[],
            addPermission:false,
            editPermission:false,
            removePermission:false
        }
    },

    methods:{
        //查询角色列表
        getRoles(){
            this.$http.http_post(this,this.$api.role.findAllRole,this.searchForm,false,(res)=>{
                if(res.code == 1){
                    this.roles = res.object
                }
            })
        },

        //新增按钮事件
        add(){
            this.dialogTitle="新增用户"
            this.publishForm = {}
            this.addDialog = true
        },
    
        //保存用户
        publishUser(){
            //遍历角色列表
            if(this.publishForm.roleId!=null){
                this.publishForm.roleList = [{id:this.publishForm.roleId}]
            }
            let tempForm = {userJson:JSON.stringify(this.publishForm)}
            this.$http.http_post(this,this.$api.user.publishUser,tempForm,true,(res)=>{
                if(res.code == 1){
                    this.searchUser()
                    this.addDialog = false
                }
            })
        },

        //编辑
        edit(row){
            this.dialogTitle="编辑用户"
            this.publishForm = row
            //处理角色下拉
            if(this.publishForm.roleInfos!=null && this.publishForm.roleInfos.length>0){
                let obj = this.publishForm.roleInfos[0]
                this.publishForm.roleId = obj.id
            }
            this.addDialog=true
            console.log('row',this.publishForm)
        },
        //删除
        del(id){
            // this.$http.http_get(this,this.$api.User.removeUser.replace(/{id}/,id),null,true,(res)=>{
            //     if(res.code==1){
            //         this.searchUser()
            //     }
            // })
        },
        //查询用户
        searchUser(){
            this.tableData=[]
            this.$http.http_post(this,this.$api.user.findAllUser,this.searchForm,false,(res)=>{
                if(res.code == 1){
                    this.tableData = res.object
                }
            })
        },

        //doSearch
        doSearch(){
            this.searchUser()
        }
    },

    created(){
        this.getRoles()
        this.searchUser()
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        userInfo.menus.filter(item =>{
            if(item.path == '/userManage'){
                item.pers.split(',').filter(i =>{
                    if(i.indexOf('新增')!=-1){
                        this.addPermission = true
                    }
                    if(i.indexOf('删除')!=-1){
                        this.removePermission = true
                    }
                    if(i.indexOf('修改')!=-1){
                        this.editPermission = true
                    }
                })
                
            }
        })

    }
}
</script>