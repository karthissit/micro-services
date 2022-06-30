package com.demo.userservice.controller;

import com.demo.userservice.departmentwrapper.ResponseTemplateUserDepartment;
import com.demo.userservice.entity.CustomUser;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String sayHello(){
        return "Hello, Welcome to the User Service!";
    }

    @PostMapping("/")
    public CustomUser addUser(@RequestBody CustomUser customUser){
        return userService.addUser(customUser);
    }

    @GetMapping("/{id}")
    public CustomUser getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @GetMapping("/withdept/{id}")
    public ResponseTemplateUserDepartment getUserWithDepartment(@PathVariable("id") Long id){
       return userService.getUserWithDepartment(id);
    }
    @GetMapping("/getall")
    public List<CustomUser> getAllUsers(){
        return userService.getAllUsers();
    }
}
