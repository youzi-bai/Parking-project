<template>
    <div id="permissionManage">
        <div style="display:flex">
            <div >
                <el-form class="mgtop10" :model="searchForm"  :inline="true" label-width="80px" label-position="right">
                    <el-form-item label="权限名称">
                        <el-input v-model="searchForm.name" clearable></el-input>
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
			<el-table-column label="权限名称" prop="name" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-lock"></i>
                    <span style="margin-left: 10px">{{ scope.row.name }}</span>
                </template>
            </el-table-column>
            <el-table-column label="描述信息" prop="content" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-s-comment"></i>
                    <span style="margin-left: 10px">{{ scope.row.content }}</span>
                </template>
            </el-table-column>
            <el-table-column label="创建时间" prop="subTime" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.subTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" prop="" width="200px">
                <template slot-scope="scope">
                    <el-button size="mini" type="success" @click="edit(scope.row)" :disabled="!editPermission" icon="el-icon-edit">编辑</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.id)" :disabled="!removePermission" icon="el-icon-delete">删除</el-button>
                </template>
            </el-table-column>
		</el-table>

        <!-- 新增弹框 -->
        <el-dialog :visible.sync="addDialog" width="45%" :title="dialogTitle">
            <el-form  :model="publishForm" inline ref="publishForm" :rules="rules">
                <el-form-item label="权限名称" prop="name">
                    <el-input v-model="publishForm.name" suffix-icon="el-icon-chat-line-round"></el-input>
                </el-form-item>
                <el-form-item label="描述信息" prop="content">
                    <el-input v-model="publishForm.content" suffix-icon="el-icon-postcard"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialog = false">取 消</el-button>
                <el-button type="primary" @click="publishPer">确 定</el-button>
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
            addPermission:false,
            editPermission:false,
            removePermission:false,
            //表单验证规则
            rules:{
                name:[{required: true, message: '请输入权限名称', trigger: 'blur'}],
                content:[{required: true, message: '请输入描述信息', trigger: 'blur'}],
            }
        }
    },
    methods:{
        //新增按钮事件
        add(){
            this.publishForm = {}
            this.dialogTitle = '新增权限'
            this.addDialog = true
        },
    
        //保存权限
        publishPer(){
            this.$refs['publishForm'].validate((valid) => {
                if (valid) {
                    this.$http.http_post(this,this.$api.per.publishPer,this.publishForm,true,(res)=>{
                        if(res.code==1){
                            this.addDialog = false
                            this.searchPer()
                        }
                    })
                } else {
                    return false;
                }
            });
        },

        //编辑
        edit(row){

            this.publishForm = row
            this.dialogTitle = '修改权限'
            
            this.addDialog = true
        },
        //删除
        del(id){
            this.$http.http_get(this,this.$api.per.removePer.replace(/{id}/,id),null,true,(res)=>{
                if(res.code==1){
                    this.searchPer()
                }
            })
        },
        //查询权限
        searchPer(){
            this.tableData=[]
            this.$http.http_post(this,this.$api.per.findAllPer,this.searchForm,false,(res)=>{
                if(res.code == 1){
                    this.tableData = res.object
                }
            })
        },

        //doSearch
        doSearch(){
            this.searchPer()
        }
    },
    created(){
        this.searchPer()
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        userInfo.menus.filter(item =>{
            if(item.path == '/perManage'){
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

<style scoped>

</style>