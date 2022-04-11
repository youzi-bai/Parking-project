<template>
    <div id="carManage">
        <div style="display:flex">
            <div >
                <el-form class="mgtop10" :model="searchForm"  :inline="true" label-width="120px" label-position="right">
                    <el-form-item label="车辆牌照">
                        <el-input v-model="searchForm.carNumber" placeholder="请输入车牌号码" clearable></el-input>
                    </el-form-item>
                    <el-form-item label="车辆所属人员" >
                       <el-select v-model="searchForm.userId">
                            <el-option v-for="(item,index) in users" :key="index" :value="item.id" :label="item.nameUser"></el-option>
                       </el-select>
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
			<el-table-column label="车辆牌照"  align="center">
                <template slot-scope="scope">
                    <i class="el-icon-info"></i>
                    <span style="margin-left: 10px">{{ scope.row.carNumber }}</span>
                </template>
            </el-table-column>
            <el-table-column label="车辆类型"  align="center">
                <template slot-scope="scope">
                    <i class="el-icon-medal-1"></i>
                    <span style="margin-left: 10px">{{ scope.row.type }}</span>
                </template>
            </el-table-column>
            <el-table-column label="创建时间"  align="center">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="车辆归属人"  align="center">
                <template slot-scope="scope">
                    <i class="el-icon-user-solid"></i>
                    <span style="margin-left: 10px">{{ scope.row.userName }}</span>
                </template>
            </el-table-column>
            <el-table-column label="车辆状态"  align="center">
                <template slot-scope="scope">
                    <!-- <i class="el-icon-loading"></i> -->
                    <!-- <span style="margin-left: 10px">{{ scope.row.carState }}</span> -->
                    <el-tag v-if="scope.row.carState==1" type="danger">停车中</el-tag>
                    <el-tag v-if="scope.row.carState==2" type="success">缴费已出</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="操作" prop="" width="200px">
                <template slot-scope="scope">
                    <el-button size="mini" type="success" @click="edit(scope.row)"  icon="el-icon-edit" :disabled="!editPermission">编辑</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.id)"  icon="el-icon-delete" :disabled="!removePermission">删除</el-button>
                </template>
            </el-table-column>
		</el-table>

        <!-- 新增弹框 -->
        <el-dialog :visible.sync="addDialog" width="50%" >
            <el-form  :model="publishForm" inline  ref="publishForm" :rules="rules" label-width="100px" >
                <el-form-item label="车牌照" prop="carNumber" style="margin-left:-50px">
                    <el-input v-model="publishForm.carNumber" suffix-icon="el-icon-info" placeholder="请输入车牌照"></el-input>
                </el-form-item>
                <el-form-item label="车辆类型" prop="type" >
                    <el-input v-model="publishForm.type" suffix-icon="el-icon-paperclip" placeholder="请输入车辆类型"></el-input>
                </el-form-item>
                <el-form-item label="车辆归属人" prop="userId" style="margin-left:-9px">
                    <el-select v-model="publishForm.userId">
                        <el-option v-for="(item,index) in users" :key="index" :value="item.id" :label="item.nameUser"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="车辆状态" prop="carState" style="margin-left:-14px">
                    <el-select v-model="publishForm.carState">
                        <el-option :value="1" label="停车中"></el-option>
                        <el-option :value="2" label="缴费已出"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialog = false">取 消</el-button>
                <el-button type="primary" @click="publishCar">确 定</el-button>
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
            users:[],
            //表单验证规则
            rules:{
                carNumber:[{required: true, message: '车牌照不能为空', trigger: 'blur'}],
                userId:[{required: true, message: '所属人不能为空', trigger: 'blur'}],
            }
        }
    },

    methods:{
        //查询用户下拉列表
        getUsers(){
            this.$http.http_post(this,this.$api.user.findAllUser,{},false,(res)=>{
                if(res.code == 1){
                    this.users = res.object
                }
            })
        },
        //新增按钮事件
        add(){
            this.publishForm = {}
            this.dialogTitle = '新增车辆'
            this.addDialog = true
        },
    
        //保存车辆
        publishCar(){

            //表单验证
            this.$refs['publishForm'].validate((valid) => {
                console.log('保存',this.publishForm)
                if(this.publishForm.userId!=null){
                    this.users.filter(item =>{
                        if(item.id == this.publishForm.userId){
                            this.publishForm.userName = item.nameUser
                        }
                    })
                }
                if (valid) {
                    this.$http.http_post(this,this.$api.car.publishCar,this.publishForm,true,(res)=>{
                        if(res.code==1){
                            this.addDialog = false
                            this.searchCar()
                        }
                    })
                } else {
                    return false;
                }
            });
            
        },

        //编辑
        edit(row){
            console.log('eid',row)
            this.publishForm = row
            this.dialogTitle = '修改车辆'
            this.addDialog = true
        },
        //删除
        del(id){
            this.$http.http_get(this,this.$api.car.removeCar.replace(/{id}/,id),null,true,(res)=>{
                if(res.code==1){
                    this.searchCar()
                }
            })
        },
        //查询车辆
        searchCar(){
            this.tableData=[]
            console.log('条件',this.searchForm)
            this.$http.http_post(this,this.$api.car.findAllCar,this.searchForm,false,(res)=>{
                console.log('查车',res)
                if(res.code == 1){
                    this.tableData = res.object
                }
            })
        },

        //doSearch
        doSearch(){
            this.searchCar()
        }
    },

    created(){
        this.getUsers()
        this.searchCar()
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        userInfo.menus.filter(item =>{
            if(item.path == '/carManage'){
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
                console.log(this.addPermission,this.removePermission)
            }
        })
    }
}
</script>