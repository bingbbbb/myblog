<template>
    <div>
        <el-button type="text" @click="dialogFormVisible = true">登录</el-button>
        <el-dialog title="用户登录" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="rules" >
                <el-form-item label="用户名" prop="name">
                    <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="form.password" placeholder="请输入用户名"></el-input>
                </el-form-item>
            </el-form>
            <div>
                <el-alert title="用户名或密码错误" type="error" :closable="false" center v-show="alertVisible"></el-alert>
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="login">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default {
    name: 'login',
    data() {
      return {
        alertVisible: false,
        dialogFormVisible: false,
        form: {
          name: '',
          password: ''
        },
        rules: {
            name: [
                { required: true, message: '请输入用户名', trigger: 'blur' }
            ],
            password:[
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
            ]
        },
      };
      
    },
    methods:{
        login(){
            var _this=this;
            _this.$store.commit('set_username','user1');
            console.log(this.$store.state.username);
            this.postRequest('/login',{username:this.form.name,password:this.form.password}).then(function(response){
            console.log(response.data.result)
            if (response.data.result=='fail') {
                _this.alertVisible = true
            } else {
                _this.dialogFormVisible = false
                _this.alertVisible = false
            }
            })
        }
    }
    
}
</script>
