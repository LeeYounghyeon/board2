package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class HomeController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("lists",boardService.findAll());
        return "/board/list";
    }

    @PostMapping("/create_board")
    public String create_board(Board board){
        boardService.createdBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        return "/board/create";
    }

    @GetMapping("/detail")
    public String detail(Model model,int idx){
        model.addAttribute("board_detail",boardService.findByBoardId(idx));
        return "/board/detail";
    }
}
