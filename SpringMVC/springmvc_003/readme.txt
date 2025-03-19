RequestMapping注解的value属性支持ant风格，支持模糊匹配请求路径
    1.?:代表除了 / ? 以外的任意一个字符
    2.*:代表除了 / ? 以外的N个任意字符组合
    3.**:代表N个任意字符组合，并且可以出现/
    注意：**使用时左右两边不能出现字符，否则效果与x*z一样
    spring5之前支持/**/
    但是spring6之后要求**必须放置在请求路径末尾才有效果
RequestMapping注解中value属性值的占位符用法
    传统的url
    springmvc/login?username=zhan&password=123
    RESTFul风格的url
    springmvc/login/zhan/123
    那在java程序中如何获取RESTFul风格的字符串参数呢？使用占位符
    @RequestMapping("/login/{username}/{password}")
    public String testRESTFul(@PathVariable("username") String username,
                              @PathVariable("password") String password){
        System.out.println("用户名：" + username + "密码：" + password);
        return "ok";
    }