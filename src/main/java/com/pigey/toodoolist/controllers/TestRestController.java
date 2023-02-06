package com.pigey.toodoolist.controllers;

import com.pigey.toodoolist.accounts.UserModel;
import com.pigey.toodoolist.accounts.UserModelRepository;
import com.pigey.toodoolist.tooDoLists.TooDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TestRestController {

    private final UserModelRepository userModelRepository;
    private final TooDoRepository tooDoRepository;

    @Autowired
    public TestRestController(UserModelRepository userModelRepository, TooDoRepository tooDoRepository) {
        this.userModelRepository = userModelRepository;
        this.tooDoRepository = tooDoRepository;
    }

    @GetMapping("/viewCards")
    public ModelAndView viewAllCards(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tooDoCards");
        modelAndView.addObject("allCards", tooDoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/find")
    public List<UserModel> findByUsername(){

        return userModelRepository.findAll();
    }
}
