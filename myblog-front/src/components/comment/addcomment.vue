<template>
    <el-form ref="form" :model="form" label-width="80px">
        <hr />
        <el-form-item label="活动形式">
            <el-input type="textarea" v-model="form.detail"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">发表</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import { Message } from 'element-ui';
export default {
    name: 'addcomment',
    props: ['articleId'],
    data() {
        return {
        form: {
            detail: ''
        }
        }
    },
    methods: {
        onSubmit() {
            var _this=this
            this.postRequest('/addComment', {articleId:_this.articleId,detail:this.form.detail}).then(function(response){
            if(response.data.result=='success'){
                Message('提交成功');
            }else{
                Message('提交失败');
            }
            })
        }
    }
}
</script>