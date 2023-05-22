package com.voloshyn.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
@GetMapping("/")
    public String showAllEmployee(){
        return "show_all_employee";
    }
@GetMapping("/student_info")
    public String showOnlyStudent(){
    return "show_only_student";
}
@GetMapping("/manager_info")
    public String showOnlyManager(){
    return "show_only_manager";
}
}
