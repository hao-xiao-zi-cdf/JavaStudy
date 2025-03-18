1.第一个springMVC执行流程
    （1）.前端发送一个http请求过来，被tomcat拦截，之后解析web.xml配置文件
    （2）.发现请求路径没有带.jsp,交由DispatcherServlet处理
    （3）.DispatcherServlet根据请求路径以及RequestMapping请求映射找到对应的控制器，并执行对应方法
    （4）.方法返回逻辑视图名称，模板引擎根据前缀和后缀拼接出物理逻辑视图名称
    （5）.模板引擎根据路径找到对应的模板文件，模板文件里面编写的是符合thymeleaf语法的模板语句
    （6）.模板引擎将模板语句解析为对应的html代码，并创建出视图对象，返回给DispatcherServlet对象
    （7）.DispatcherServlet对象将视图对象转化为浏览器能够看懂的html代码响应给前端，前端进行页面展示
2.如何在thymeleaf模板文件中动态获取项目的根路径名称？
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<a th:href="@{/hei}">跳转</a>
在需要的标签前面添加th:一旦模板引擎识别就知道这是符合thymeleaf语法的模板语句，会进行解析，解析成html代码