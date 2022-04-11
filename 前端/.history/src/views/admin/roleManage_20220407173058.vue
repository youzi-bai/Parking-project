<template>
    <div id="roleManage">
        <div style="display:flex">
            <div >
                <el-form class="mgtop10" :model="searchForm"  :inline="true" label-width="80px" label-position="right">
                    <el-form-item label="角色名称">
                        <el-input v-model="searchForm.roleName" clearable></el-input>
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
			<el-table-column label="角色名称" prop="roleName" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-info"></i>
                    <span style="margin-left: 10px">{{ scope.row.roleName }}</span>
                </template>
            </el-table-column>
            <el-table-column label="角色级别" prop="level" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-s-flag"></i>
                    <span style="margin-left: 10px">{{ scope.row.level }}</span>
                </template>
            </el-table-column>
            <el-table-column label="描述信息" prop="description" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-s-comment"></i>
                    <span style="margin-left: 10px">{{ scope.row.description }}</span>
                </template>
            </el-table-column>
            <el-table-column label="所属菜单" align="center">
                <template slot-scope="scope">
                    <div v-for="(item,index) in (scope.row.roleMenus)" :key="index">
                        <el-tag>{{item.menuName}}</el-tag>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="拥有权限" align="center">
                <template slot-scope="scope">
                    <div v-for="(menu,index) in (scope.row.roleMenus)" :key="index" style="margin-bottom:7px">
                        <span>{{menu.perName}}</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="创建时间" prop="subTime" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.subTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" prop="" width="300px" align="center">
                <template slot-scope="scope">
                    <el-button size="mini" type="success" @click="edit(scope.row)" :disabled="!editPermission" icon="el-icon-setting">菜单配置</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.id)" :disabled="!removePermission" icon="el-icon-delete">删除</el-button>
                </template>
            </el-table-column>
		</el-table>

        <!-- 新增角色弹框 -->
        <el-dialog :visible.sync="addDialog" width="40%"  title="新增角色">
            <el-form  :model="publishForm" label-width="80px" label-position="right" ref="publishForm" :rules="rules">
                <el-row>
                    <el-col :span="20">
                        <el-form-item label="角色名称" prop="roleName">
                            <el-input v-model="publishForm.roleName" suffix-icon="el-icon-info"></el-input>
                        </el-form-item>
                        <el-form-item label="角色级别" prop="level">
                            <el-select v-model="publishForm.level" style="margin-left:-220px" >
                                <el-option v-for="(item,index) in levels" :key="index" :value="item" :label="item" margin-left=5px></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="描述信息" >
                            <el-input v-model="publishForm.description" type="textarea" rows="4" suffix-icon="el-icon-chat-dot-square"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>           
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialog = false">取 消</el-button>
                <el-button type="primary" @click="publishRole">确 定</el-button>
            </span>
        </el-dialog>

        <!--菜单权限配置-->
        <el-dialog :visible.sync="addDialogMenu" width="40%"  title="菜单配置">
            <el-form  :model="menuForm" inline >
                <el-form-item label="菜单配置">
                    <el-select v-model="menuForm.menuId">
                        <el-option v-for="(item,index) in menus" :key="index" :value="item.id" :label="item.name"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="权限配置">
                    <el-select v-model="perIds" multiple>
                        <el-option v-for="(item,index) in pers" :key="index" :value="item.id" :label="item.name"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogMenu = false">取 消</el-button>
                <el-button type="primary" @click="publishMenu">确 定</el-button>
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
            addDialogMenu:false,
            levels:['一级','二级','三级','四级','五级'],
            publishForm:{},
            tableData:[],
            menus:[],
            pers:[],
            perIds:[],
            menuForm:{},
            addPermission:false,
            editPermission:false,
            removePermission:false,
            rules:{
                roleName:[{required: true, message: '请输入角色名称', trigger: 'blur'}],
                level:[{required: true, message: '请选择级别', trigger: 'blur'}],
            }
        }
    },

    methods:{
        //查菜单列表
        getMenu(){
            this.$http.http_post(this,this.$api.menu.findAllMenu,null,false,(res)=>{
                if(res.code == 1){
                    this.menus = res.object
                }
            })
        },
        //查询权限列表
        getPers(){
            this.$http.http_post(this,this.$api.per.findAllPer,null,false,(res)=>{
                if(res.code == 1){
                    this.pers = res.object
                }
            })
        },
        //新增按钮事件
        add(){
            this.addDialog = true
        },
    
        //保存角色
        publishRole(){
            this.$http.http_post(this,this.$api.role.publishRole,this.publishForm,true,(res)=>{
                if(res.code == 1){
                    this.searchRole()
                    this.addDialog = false
                }
            })
        },

        //菜单权限配置
        edit(row){
            this.addDialogMenu = true
            this.menuForm.roleId = row.id
            this.menuForm.roleName = row.roleName
        },
        //保存菜单权限
        publishMenu(){

            //取出所选菜单对应的名称
            this.menus.filter(item =>{
                if(item.id == this.menuForm.menuId){
                    this.menuForm.menuName = item.name
                }
            })
            //取出对应权限的名称
            let temp = []
            this.perIds.filter(item =>{
                this.pers.filter(item_A =>{
                    if(item == item_A.id){
                        temp.push(item_A.name)
                    }
                })
            })
            this.menuForm.perId = this.perIds.join(',')
            this.menuForm.perName = temp.join(',')
            
            let tempJson = {menuJson:JSON.stringify(this.menuForm)}
            this.$http.http_post(this,this.$api.role.configMenu,tempJson,true,(res)=>{
                if(res.code == 1){
                    this.searchRole()
                    this.addDialogMenu = false
                }
            })

        },
        //删除
        del(id){
            this.$http.http_get(this,this.$api.role.removeRole.replace(/{id}/,id),null,true,(res)=>{
                if(res.code==1){
                    this.searchRole()
                }
            })
        },
        //查询角色
        searchRole(){
            this.tableData=[]
            this.$http.http_post(this,this.$api.role.findAllRole,this.searchForm,false,(res)=>{
                if(res.code == 1){
                    this.tableData = res.object
                }
                
            })
        },
        //doSearch
        doSearch(){
            this.searchRole()
        }
    },

    created(){
        this.getMenu()
        this.getPers()
        this.searchRole()
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        userInfo.menus.filter(item =>{
            if(item.path == '/roleManage'){
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