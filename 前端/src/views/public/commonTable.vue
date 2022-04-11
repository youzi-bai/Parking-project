<template>
    <div id="commenTable">
        <!-- 查询 -->
        <div style="display:flex">
            <div v-if="searchBoxs!=null">
                <el-form class="mgtop10" :model="searchForm"  :inline="true" label-width="80px" label-position="right">
                    <el-form-item :label="searchBoxs.label">
                        <el-input v-model="searchForm.name" style="width:280px"  clearable></el-input>
                    </el-form-item>
                    <el-button v-if="searchBoxs.searchButton!=null" :icon="searchBoxs.searchButton.icon" type="primary" @click="search(searchBoxs.type)">{{searchBoxs.searchButton.label}}</el-button>
                </el-form>
            </div>
            <div v-if="addBoxs!=null" style="margin-left:10px">
                <el-button  :icon="addBoxs.icon" @click="add(addBoxs.type)">{{addBoxs.label}}</el-button>
            </div>
        </div>
        

        <!-- 列表 -->
        <el-table   stripe :data="tableData" border style="width: 100%"
			:header-cell-style="{'background-color': '#f5f5f5','color': '#606266','border-bottom':'solid 1px #d2d3da'}">
			<el-table-column
                align="center"
                v-for="(item, index) in columns"
                :key="index"
                :prop="item.attrName"
                :label="item.label"
                >
            </el-table-column>

            <el-table-column v-if="operations.length>0" align="center" label="操作" width="300px">
                <template slot-scope="scope">
                    <el-button-group>
                        <el-button
                            style="margin-right:10px"
                            size="mini"
                            v-for="(item, index) in operations"
                            :key="index"
                            :type="item.type"
                            :icon="item.icon"
                            @click="operateType(item.opt, scope.row, scope.$index)"
                        >{{item.operateName}}</el-button>
                    </el-button-group>
                </template>
            </el-table-column>
		</el-table>

        <!-- 新增弹框 -->

        <el-dialog  v-if="addBoxs!=null" :visible.sync="addDialogVisible" :width="addBoxs.width" label-width="100px">
            <el-form v-if="publishForm" :model="publishForm" @open="open">
                <div v-if="addBoxs.type=='menu'">
                    <el-form-item v-for="(item,index) in addBoxs.fields" :key="index" :label="item.label" >
                        <el-input v-model="publishForm.name" style="width:150px"></el-input>
                    </el-form-item>
                </div>
                
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addSubmit(addBoxs)">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    name:'commenTable',
    props: {
        columns: {
            type: Array,
            default: () => [],
        },
        data: {
            type: Array,
            default: () => [],
        },
        operation: {
            type: Array,
            default: () => [],
        },
        searchBox:{
            type: Object,
            default:() => null
        },
        addBox:{
            type:Object,
            default:() => null
        }
    },

    data(){
        return{
            tableData:[],
            operations:[],
            searchForm:{},
            searchBoxs:{},
            addBoxs:{},
            addDialogVisible:false,
            publishForm:{},
            module:''
        }
    },
    methods:{
        //操作
        operateType(opt,row,index){
            console.log(opt,index)
        },

        //点击按钮条件查询
        search(type){
            if(type == 'menu'){
                this.$parent.searchMenu(this.searchForm)
            }
        },
        //加载查询
        searchDefault(){
            if(this.searchBoxs.type=='menu'){
                this.$parent.searchMenu(this.searchForm)
            }
        },
        //新增
        add(){
            this.addDialogVisible=true
        },
        open(){
            this.publishForm = {}
        },
        //新增保存
        addSubmit(addBoxs){
            if(addBoxs.type == 'menu'){
                this.$parent.publishMenu(this.publishForm)
            }
            this.addDialogVisible = false
        },
        
    },

    created(){
        setTimeout(()=>{
            this.tableData = this.data
            this.operations = this.operation
            this.searchBoxs = this.searchBox
            if(this.searchBoxs!=null)
                this.searchForm.name = this.searchBoxs.name
            this.addBoxs = this.addBox
            this.publishForm = this.addBoxs.addForm
            this.searchDefault()
        },200)

    }
}
</script>