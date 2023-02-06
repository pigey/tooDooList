package com.pigey.toodoolist.controllers;

import com.pigey.toodoolist.accounts.UserModel;
import com.pigey.toodoolist.accounts.UserModelRepository;
import com.pigey.toodoolist.tooDoLists.TooDoModel;
import com.pigey.toodoolist.tooDoLists.TooDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class TooDoController {

    private final UserModelRepository userModelRepository;
    private final TooDoRepository tooDoRepository;

    @Autowired
    public TooDoController(UserModelRepository userModelRepository, TooDoRepository tooDoRepository) {
        this.userModelRepository = userModelRepository;
        this.tooDoRepository = tooDoRepository;
    }


    @GetMapping("/tooDoCards")
    public String displayTooDoCards(TooDoModel tooDoModel, Model model){
        model.addAttribute("allCards", tooDoRepository.findAll());
        return "tooDoCards";
    }

    @PostMapping("/tooDoCards")
        public String createTooDoCards(TooDoModel tooDoList){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //Get the logged in username

        tooDoList.setListInformation(tooDoList.getListInformation());
        tooDoList.setAuthor(name);
        tooDoRepository.save(tooDoList);
        tooDoList.setListInformation("");
        return"/tooDoCards";
    }

}
