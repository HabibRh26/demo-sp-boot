package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class MainController {
    @ModelAttribute
    public void welcomMsg(Model m){
        m.addAttribute("msg","Welcome Message for All");
    }
    @RequestMapping("/home")
    public String homepage(){
        return "homePage.html";
    }
    @RequestMapping("/addCoder")
    public String addProg(@ModelAttribute("c") Coder coder){
//        System.out.println(id+" "+name+" "+lang);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("coder.html");


        return "coder.html";
    }






}
