package com.example.passweb.controller.pass;


import com.example.passweb.dto.pass.PassDto;
import com.example.passweb.dto.user.UserDto;
import com.example.passweb.service.pass.PassService;
import com.example.passweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/passes")
public class PassViewController {
    private final UserService userService;
    private final PassService passService;

    @GetMapping
    public ModelAndView getPasses(@RequestParam("userId") String userId){
        ModelAndView modelAndView = new ModelAndView();

        List<PassDto> passes  = passService.getPasses(userId);
        UserDto user = userService.getUser(userId);

        modelAndView.addObject("passes",passes);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("pass/index");

        return modelAndView;
    }
}
