import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        username:"",
        permissions:[]
    },
    mutations:{
        set_username: (state, username) => {
            state.username = username
        },
        set_permissions: (state, permissions) => {
            state.permissions = permissions
        }
    },
    actions:{

    }
})