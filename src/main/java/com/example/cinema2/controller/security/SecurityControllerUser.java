//package com.example.cinema2.controller.security;
//
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class SecurityControllerUser {
//
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
//    @PreAuthorize("hasRole('OPERATOR') and hasAuthority('READ')")
//    @GetMapping("/operator")
//    public String operator(){
//        return "operator";
//    }
//
//    @PreAuthorize("hasRole('MANAGER')")
//    @GetMapping("/manager")
//    public String manager(){
//        return "manager";
//    }
//
//    @PreAuthorize("hasRole('MANAGER') and hasAuthority('WRITE')")
//        @GetMapping("/manager_write")
//    public String manager_write(){
//        return "manager_write";
//    }
//
//}
