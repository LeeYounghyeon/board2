package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/board")
public class HomeController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "pageNo", defaultValue="1")int pageNo){
        model.addAttribute("lists",boardService.boardListFind(pageNo-1));
        model.addAttribute("board_list_size",boardService.paging());
        return "/board/list";
    }

    @PostMapping("/create_board")
    @ResponseBody
    public boolean create_board(@RequestBody Board board){
        boardService.createdBoard(board);
        return true;
    }

    @GetMapping("/create")
    public String create(Model model){
        return "/board/create";
    }

    @GetMapping("/detail")
    public String detail(Model model,@RequestParam(value = "idx", defaultValue = "0") int idx){
        model.addAttribute("board_detail",boardService.findByBoardId(idx));
        return "/board/detail";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam(value = "idx", defaultValue = "0") int idx){
        model.addAttribute("board",boardService.findByBoardId(idx));
        return "/board/update";
    }

    @PutMapping("/update_list")
    @ResponseBody
    public boolean update_list(@RequestBody Board board){
        boardService.updateBoard(board);
        return true;
    }

    @DeleteMapping("/board_delete")
    public String delete(@RequestParam(value = "idx", defaultValue = "0") int idx){
        boardService.boardDelete(idx);
        return "redirect:/board/list";
    }
}
