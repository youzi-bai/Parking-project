module.exports={
    devServer:{
        proxy:{
            '/api':{
                target: 'http://47.95.228.79:2001',
                changeOrigin:true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }

    }
}

