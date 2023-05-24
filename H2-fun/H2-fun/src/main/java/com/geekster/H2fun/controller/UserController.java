package com.geekster.H2fun.controller;

import com.geekster.H2fun.models.Users;
import com.geekster.H2fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value="/users")
    public Iterable<Users> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/users")
    public String insertUser(@RequestBody List<Users> userList){
        return userService.addUsers(userList);
    }

    @DeleteMapping(value="/user/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.removeUserById(id);
    }

    @GetMapping(value="/users/{name}")
    public List<Users> getUsersByName(@PathVariable String name){
        return userService.fetchUserByName(name);
    }

    @GetMapping(value="users/age/{age}")
    public List<Users> getUserByAge(@PathVariable String age){
        return userService.fetchByAge(age);
    }

    @GetMapping(value="/users/{name}/greaterThan/{age}")
    public List<Users> getUserByNameOrAge(@PathVariable String name, @PathVariable String age){
        return userService.fetchUserByNameOrAge(name,age);
    }

    @GetMapping(value="/users/combined")
    public List<Users> getUserByNameAndAge(@RequestParam String name, @RequestParam String age){
        return userService.fetchUserByNameAndAge(name,age);
    }

    @GetMapping(value="/userSort")
    public List<Users> getOrderedUsers(){
        return userService.getAllUsersSorted();
    }
}
