<template>
    <div id="parkManage">
        <div style="float:left;margin:0 0 20px 50px">
            <el-tag type="warning" effect="dark">停车场列表</el-tag>
            <el-button type="primary" size="small" style="margin-left:20px" @click="add" :disabled="!addPermission">新增</el-button>
        </div>
        <div id="org_content">
            <div class="parkItem" v-for="(item,index) in productList" :key="index">
                <div class="subTime">发布时间:{{item.createTime}}</div>
                <el-divider/>
                <div class="parkName">
                    {{item.name}}
                    <span style="margin-left:30px">车位总数:{{item.sumPosition}}</span>
                </div>
                <div class="parkContent">{{item.content}}</div>
                <div class="operator">
                    <el-button size="mini" type="primary" @click="edit(item)" :disabled="!editPermission">编辑</el-button>
                    <!-- <el-button size="mini" type="success">审核</el-button> -->
                    <el-button size="mini" type="danger" @click="del(item)" :disabled="!removePermission">删除</el-button>
                </div>
            </div>

            <el-col :span="20" class="toolbar">
                <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="searchForm.pageSize" :total="searchForm.total" style="float:right;">
                </el-pagination>
            </el-col>
        </div>

        <!--新增-->
        <el-dialog :visible.sync="addDialog" width="55%" label-width="10px" :title="dialogTitle">
            <el-form  :model="publishForm"  inline ref="publishForm">
                <el-row>
                    <el-col :span="10">
                        <el-form-item label="停车场名称" >
                            <el-input v-model="publishForm.name" suffix-icon="el-icon-info" placeholder="请输入停车场名称"></el-input>
                        </el-form-item>
                         <el-form-item label="描述" style="margin-left:60px">
                            <el-input  v-model="publishForm.content" suffix-icon="el-icon-paperclip" placeholder="请输入描述信息" type="textarea" rows="5"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                       <el-form-item label="车位总数">
                            <el-input-number v-model="publishForm.sumPosition"  :min="1" :max="999" placeholder="请输入停车场名称"></el-input-number>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialog = false">取 消</el-button>
                <el-button type="primary" @click="publishPark">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<script>
export default {
    data(){
        return{
            addDialog:false,
            dialogTitle:'',
            publishForm:{},
            searchForm:{
                page:1,
                pageSize:6,
                total:0
            },
            productList:[]
        }
    },
    methods:{
        //新增弹框
        add(){
            this.publishForm={}
            this.dialogTitle = "新增停车场"
            this.addDialog = true
        },
        //保存新增
        publishPark(){
            this.$http.http_post(this,this.$api.park.publishPark,this.publishForm,true,(res)=>{
                if(res.code){
                    this.getParkingInfo()
                    this.addDialog = false
                }
            })
        },
        //编辑
        edit(item){
            this.publishForm=item
            this.dialogTitle = "修改停车场"
            this.addDialog = true
        },

        //删除
        del(item){
            this.$confirm('此操作将永久删除停车场, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$http.http_get(this,this.$api.park.removePark.replace(/{id}/,item.id),null,true,(res)=>{
                    if(res.code == 1){
                        this.getParkingInfo()
                    }
                })
            }).catch(() => {
                     
            });
        },

        //查询所有停车场
        getParkingInfo(){
            this.productList=[];
            this.$http.http_post(this,this.$api.park.findAllPark,this.searchForm,false,(res)=>{
                if(res.code == 1){
                   this.productList = res.object
                    this.searchForm.total = res.length
                    console.log(this.searchForm.total)
                }
            })
        },

        //handleCurrentChange
        handleCurrentChange(val){
            this.searchForm.page = val
			this.getParkingInfo();
        }
        
    },
    created(){
        this.getParkingInfo()
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        userInfo.menus.filter(item =>{
            if(item.path == '/parkingManage'){
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
    #org_content{
        float:left;
        margin-left:50px;
        border-radius: 10px;
        height: 100%;
        width: 100%;
        padding: 10px;
        background-color: white;
    }

    .parkItem{
        width:340px;
        height: 200px;
        border:2px solid rgb(230, 230, 235);
        /* border:1px solid rgb(24, 24, 32); */
        margin: 10px 20px 20px 40px;
        padding: 15px;
        float:left

    }

    div .subTime{
        /* font-weight: bolder; */
        color: black;
        font-size: 14px;
        text-align: left;
    }
    div .parkName{
        font-weight: bolder;
        color: black;
        font-size: 16px;
        text-align: left;
        margin-bottom: 10px;
    }
    div .parkContent{
        /* color: rgb(163, 160, 160); */
        color: black;
        font-size: 14px;
        display: -webkit-box;
        overflow: hidden;
        white-space: normal!important;
        text-overflow: ellipsis;
        word-wrap: break-word;
        -webkit-line-clamp: 5;
        -webkit-box-orient: vertical;
        text-align: left;
        opacity: 0.5;
        height: 50px;
    }
    div .operator{
        margin-top: 25px;
    }
</style>