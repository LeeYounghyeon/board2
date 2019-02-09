package com.example.demo.controller;

import com.example.demo.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class HomeController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("lists",boardService.findAll());
        return "board/list";
    }

}
