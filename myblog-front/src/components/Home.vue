<template>

 <!--   <h1>{{ msg }}</h1>
    <h2>{{title1}}</h2>
    <div>{{text1}}</div>
 --> 
<el-container>
<el-aside width="200px">Aside
  Welcome: {{this.$store.state.username}}
  <login></login>
</el-aside>
<el-container>
    <el-header>Header</el-header>
    <el-container>
    <el-main>
        <router-view/>
    </el-main>
    <el-footer>Footer</el-footer>
    </el-container>
</el-container>
</el-container>
</template>

<script>
import login from './login/login.vue'
export default {
    name: 'Home',
    data () {
        return {
        msg: 'Welcome to Your Vue.js App',
        title1: 'title1',
        text1: 'text1',
        items:[
            {title: 'title1', date: '2018-4-23', text: 'text1'},
            {title: 'title2', date: '2018-4-23', text: 'text2'}
        ]
        }
    },
    mounted: function(){
        var _this=this
        
        this.axios({method:'get',url:'/hello'}).then(function(response){
        console.log(response.data.title1)
        _this.title1=response.data.title1})
    },
    components:{
      login
    }
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
  .el-header{
    background-color:rgb(159, 202, 245);
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .el-footer{
    background-color: rgb(158, 182, 204);
    text-align: center;
    line-height: 60px;
  }
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
