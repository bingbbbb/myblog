<template>
  <div>
        <div>{{article.title}}</div>
        <div>{{article.content}}</div>
        <div>{{article.createDate}}
            {{createTime}}
        </div>
        <comment :articleId=this.$route.query.articleId></comment>
        <addcomment :articleId=this.$route.query.articleId></addcomment>


  </div>
</template>

<script>
import comment from '../comment/comment.vue'
import addcomment from '../comment/addcomment.vue'
export default {
    data () {
        return {
            article:[],
            createTime:'',
            id: this.$route.query.articleId
        }},
    methods:{
        loadArticle(){
            var _this=this
            this.postRequest('/article', {articleId:_this.id}).then(function(response){
            _this.article=response.data.article;
            _this.createTime=response.data.createTime;
            console.log('a test in article.vue')
            })
        }
    },
    mounted: function(){
        this.loadArticle()
    },
    components: {
        comment,
        addcomment
    }
}
</script>

