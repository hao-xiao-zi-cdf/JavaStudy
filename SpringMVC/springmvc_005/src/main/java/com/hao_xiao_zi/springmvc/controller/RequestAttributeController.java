package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-20
 * Time: 17:30
 */
@Controller
public class RequestAttributeController {

    @RequestMapping("/testModel")
    public String testModel(Model model){
        //往请求域中存储数据
        model.addAttribute("requestAttribute","使用Model接口实现两个组件之间的数据共享");
        //跳转视图，默认使用的是转发机制，再同一次请求内
        System.out.println(model);
        System.out.println(model.getClass().getName());
        return "ok";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        //只要往中存储数据，就会往request中存储数据
        map.put("requestAttribute","使用Map接口实现两个组件之间的数据共享");
        System.out.println(map);
        System.out.println(map.getClass().getName());
        return "ok";
    }

    @RequestMapping("/testModelMap")
    public String testMap(ModelMap modelMap){
        modelMap.addAttribute("requestAttribute","使用ModelMap接口实现两个组件之间的数据共享");
        System.out.println(modelMap);
        System.out.println(modelMap.getClass().getName());
        return "ok";
    }
//    测试发现，不论用上面哪个接口来存储数据，底层使用的具体类都为org.springframework.validation.support.BindingAwareModelMap

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("requestAttribute","使用ModelAndView类实现两个组件之间的数据共享");
        System.out.println(modelAndView);
        System.out.println(modelAndView.getClass().getName());
        modelAndView.setViewName("ok");
        //底层最终还是会返回给DisPatcherServlet对象，对象根据view视图名称再决定跳转到哪个视图对象
        return modelAndView;
    }
}
