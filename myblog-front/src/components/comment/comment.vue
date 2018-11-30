<template>
    <div>
        This is comment.vue
        {{articleId}}
        <div v-for = "item in comments">
            <hr />
            <p>{{item.userName}}</p>
            <p>{{item.commentDetail}}</p>
            <p>{{item.createDate}}</p>
            <el-button type="primary" @click="deletecomment(item.id)">删除</el-button>
        </div>
    </div>
</template>

<script>
import { Message } from 'element-ui';
export default {
    name: 'comment',
    props: ['articleId'], 
    data () {
        return {
            comments:[]
        }
    },
    methods:{
        loadcomments(){
            var _this=this
            this.postRequest('/getComments', {articleId:_this.articleId}).then(function(response){
            _this.comments=response.data.comments})
        },
        deletecomment(commentId){
            this.postRequest('/deleteComment', {commentId:commentId}).then(function(response){
            if(response.data.result=='success'){
                Message('删除成功');
            }
            })
        }
    },
    mounted:function(){
        this.loadcomments()
    }
}
</script>


