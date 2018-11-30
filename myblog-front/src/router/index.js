import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import articles from '../components/articles/articles'
import article from '../components/articles/article'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            component: Home,
            children:[
                {
                    path: '/',
                    component: articles
                },
                {
                    path: '/article',
                    component: article
                } 
            ]
        },{
            path: '/hemo',
            name: 'home',
            component: Home
        }
        
    ]
})