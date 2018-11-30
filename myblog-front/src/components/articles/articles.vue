<template>
    <div>
        <hr />
        <div v-for="item in articles">
            <router-link :to = "{path: '/article', query: {articleId: item.id}}">
                {{item.title}}
            </router-link>
            <br />
            {{item.summary}}
        <hr />
        </div>
        <button v-on:click="getarticle">go to see a article</button>
    </div>
</template>

<script>
export default {
    name: 'articles',
    data () {
        return {
        articles: []
        }
    },
    methods:{
        loadArticles(){
            var _this=this
            this.axios({method:'get',url:'/articles'}).then(function(response){
            _this.articles=response.data.articles})
        },
        getarticle: function(){
            console.log('a test in articles.vue')
            this.$router.push({path: '/article', query: {queryId: 'queryId1'}})
        }
    },
    mounted: function(){
        this.loadArticles();
    }
}
</script>
