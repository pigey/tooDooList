package com.pigey.toodoolist.controllers;

import com.pigey.toodoolist.Authorities.UserRoles;
import com.pigey.toodoolist.accounts.UserModel;
import com.pigey.toodoolist.accounts.UserModelRepository;
import com.pigey.toodoolist.configurations.AppPasswordConfig;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserModelController {

    private final UserModelRepository userModelRepository;
    private final AppPasswordConfig appPasswordConfig;


    @Autowired
    public UserModelController(UserModelRepository userModelRepository, AppPasswordConfig appPasswordConfig) {
        this.userModelRepository = userModelRepository;
        this.appPasswordConfig = appPasswordConfig;

    }

    @GetMapping("/register")
    public String displayUser(UserModel userModel){

        return"register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserModel userModel, BindingResult result, Model model){

        if (result.hasErrors()){

            return "register";
        }

        userModel.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(userModel.getPassword()));
        userModel.setAuthorities(UserRoles.USER.getGrantedAuthorities());
        userModel.setAccountNonExpired(true);
        userModel.setAccountNonExpired(true);
        userModel.setCredentialsNonExpired(true);
        userModel.setEnabled(true);
        userModel.setAccountNonLocked(true);
        userModelRepository.save(userModel);

        return "/home";
    }


}