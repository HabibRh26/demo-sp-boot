package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.CoderRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
@ControllerAdvice
public class MainController {
    @Autowired
    CoderRepo repoObj;

    @ModelAttribute
    public void welcomMsg(Model m){
        m.addAttribute("msg","Welcome Message for All");
    }

//    @RequestMapping("/home")
    @GetMapping("/home")
    public String homepage(){
        return "homePage.html";
    }

//    @RequestMapping(value="/addCoder", method = RequestMethod.POST)
    @PostMapping("/addCoder")
    public String addProg(@ModelAttribute("c") Coder coder){

        return "coder.html";
    }
    @GetMapping("/allCoder")
    public String allCoder(Model model){
        List<Coder> cd = new ArrayList<Coder>();
        cd.add(new Coder(45,"hank","c"));
        cd.add(new Coder(56,"white","cpp"));
        cd.add(new Coder(89,"pinkman","c#"));

        model.addAttribute("coders",cd);
        return "allCoder.html";
    }






}
