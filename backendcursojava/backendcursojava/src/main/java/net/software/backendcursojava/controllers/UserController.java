package net.software.backendcursojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.software.backendcursojava.models.request.UserDetailRequestModel;
import net.software.backendcursojava.models.responses.UserRest;
import net.software.backendcursojava.services.UserSeviceInterface;
import net.software.backendcursojava.share.dto.UserDTO;

@RestController
@RequestMapping("/users") //localgost:8080/users
public class UserController {

    @Autowired
    UserSeviceInterface userService;

    @GetMapping
    public String getUser(){
        return "Obtener usuarios";
    }

    @PostMapping //Crea información 
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
        
        UserRest userToReturn = new UserRest();
        
        UserDTO userDTO = new UserDTO();
        
        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO); 
        
        BeanUtils.copyProperties(createdUser, userToReturn);

        return userToReturn;
    }

}
