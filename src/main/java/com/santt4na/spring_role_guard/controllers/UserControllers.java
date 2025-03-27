package com.santt4na.spring_role_guard.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllers {
  @GetMapping("/")
  public String root() {
    return "Bem-vindo à API Spring Role Guard!";
  }

  @GetMapping("/public")
  public String publicRouter() {
    return "Public Router";
  }

  @GetMapping("/admin")
  public String adminRouter() {
    return "Admin Router";
  }

  @GetMapping("/merchant")
  public String userRouter() {
    return "User Router";
  }

  @GetMapping("/motoboy")
  public String motoboyRouter() {
    return "User Motoboy";
  }

  @GetMapping("/customer")
  public String customerRouter() {
    return "User customer";
  }
}
