package com.pigey.toodoolist.controllers;

import com.pigey.toodoolist.accounts.UserModel;
import com.pigey.toodoolist.accounts.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRestController {

    private final UserModelRepository userModelRepository;

    @Autowired
    public TestRestController(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @GetMapping("/find")
    public List<UserModel> findByUsername(){

        return userModelRepository.findAll();
    }
}
