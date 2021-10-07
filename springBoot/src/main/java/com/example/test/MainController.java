package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@ControllerAdvice
public class MainController {
    @Autowired
    CoderRepo repoObj;

//    @RequestMapping("/home")
    @GetMapping("/home")
    public String homepage(){
        return "homePage.html";
    }

//    @RequestMapping(value="/addCoder", method = RequestMethod.POST)
    @PostMapping("/addCoder")
    public String addProg(@ModelAttribute("c") Coder coder){
        repoObj.save(coder);
        return "redirect:/home";
    }
    @PostMapping("/findById")
    public String findById(@RequestParam int pId, Model model){
       Coder coderObj = repoObj.getById(pId);
       model.addAttribute("c", coderObj);

       return "coder.html";
    }

    @GetMapping("/delById")
    public String deleteById(@RequestParam int pId){
        repoObj.deleteById(pId);
        return "redirect:/home";
    }

    @PostMapping("/update")
    public String Update(@ModelAttribute("c") Coder coder){

        Coder cd = repoObj.getById( coder.getpId());
        cd.setpName(coder.getpName());
        cd.setpLang(coder.getpLang());
        repoObj.save(cd);
        return "coder.html";
    }

    @PostMapping("/findByName")
    public String findByName(@RequestParam String pName, Model model){
        List<Coder> cd = repoObj.findBypName(pName);
        model.addAttribute("coders", cd);
        return "allCoder.html";
    }

    @PostMapping("/findByLang")
    public String findByLang(@RequestParam String pLang, Model model){
        List<Coder> cd = repoObj.findByLang(pLang);
        model.addAttribute("coders", cd);
        return "allCoder.html";
    }



}
