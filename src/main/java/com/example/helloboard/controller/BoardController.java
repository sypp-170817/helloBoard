package com.example.helloboard.controller;

import com.example.helloboard.common.BoradStatic;
import com.example.helloboard.param.request.BoardReq;
import com.example.helloboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/writeForm")
    public String writeForm_secure(Model model){
        model.addAttribute(BoradStatic.CONTENT_HTML,"writeForm");
        return BoradStatic.ROOT_HTML;
    }

    @PostMapping("write")
    public String writeBoard_secure(@ModelAttribute BoardReq boardReq){
        boardService.writeBoard(boardReq);
        return "redirect:/";
    }
}
