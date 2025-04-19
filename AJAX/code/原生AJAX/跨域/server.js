const express = require('express');
const cors = require('cors');
const app = express();
const { createProxyMiddleware } = require('http-proxy-middleware');

//绑定静态资源
app.use(express.static('./public'));  

app.use('/api',createProxyMiddleware({
    target:'https://www.toutiao.com',
    changeOrigin:true,
    pathRewrite:{
      '^/api':''
    }
  }))

  app.listen(8000, ()=>{
    console.log("服务已经启动, 8000 端口监听中....");
});

// app.get('/server', (request, response)=>{
//     // response.setHeader('Access-Control-Allow-Origin','http://127.0.0.1:5500');
//     response.send('HELLO CORS');
// });

  // app.options('/server', (request, response)=>{
//     response.setHeader('Access-Control-Allow-Origin','http://127.0.0.1:5500');
//     response.setHeader('Access-Control-Allow-Methods','GET');
//     response.setHeader('Access-Control-Allow-Headers','username');
//     response.setHeader('Access-Control-Max-Age','6000');
//     //注意预检请求也必须返回内容，否则会一直等待
//     response.send('HELLO CORS');
// });



