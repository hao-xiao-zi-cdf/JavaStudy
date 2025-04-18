//1. 引入express
const express = require('express');

//2. 创建应用对象
const app = express();

//3. 创建路由规则
// request 是对请求报文的封装
// response 是对响应报文的封装
// app.get('/server', (request, response)=>{
//     //设置响应头 设置允许跨域
//     response.setHeader('Access-Control-Allow-Origin','*');
//     //设置响应
//     response.send('HELLO EXPRESS');
// });

// app.get('/server', (request, response)=>{
//     //设置响应头 设置允许跨域
//     response.setHeader('Access-Control-Allow-Origin','*');

//     //创建JSON对象
//     var data = {
//         "username" : "zhangsan",
//         "age" : 20,
//         "sex" : "男"
//     }

//     //使用JSON工具将JSON对象转化成字符串
//     var strJson = JSON.stringify(data);
    
//     //设置响应
//     response.send(strJson);
// });

//可以接收任意请求方式的请求
app.all('/server', (request, response)=>{
    //设置响应头 设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');
    
    //设置响应体,所有类型的头信息都可以接收
    response.setHeader('Access-Control-Allow-Headers','*');

    //创建JSON对象
    var data = {
        "username" : "zhangsan",
        "age" : 20,
        "sex" : "男"
    }

    //使用JSON工具将JSON对象转化成字符串
    var strJson = JSON.stringify(data);

    //延迟响应设置
    setTimeout(()=>{
        //设置响应
        response.send(strJson);
    },3000)
});

//axios 服务
app.all('/axios-server', (request, response)=>{
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    var data = {
        "username" : "张三"
    }
    var strJson = JSON.stringify(data);
    response.send(strJson);
});

//fetch 服务
app.all('/fetch-server', (request, response)=>{
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    var data = {
        "username" : "张三"
    }
    var strJson = JSON.stringify(data);
    response.send(strJson);
});

//4. 监听端口启动服务
app.listen(8000, ()=>{
    console.log("服务已经启动, 8000 端口监听中....");
});