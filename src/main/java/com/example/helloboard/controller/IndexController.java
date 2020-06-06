package com.example.helloboard.controller;

import com.example.helloboard.common.BoradStatic;
import com.example.helloboard.entity.BoardEntity;
import com.example.helloboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public ModelAndView index(@RequestParam(required = false, defaultValue = "0") int page, ModelAndView model) {
        int contnetSize = 5;

        Pageable pageable = PageRequest.of(page, contnetSize, Sort.by("seq").descending());
        model.addObject("content", "board");
        Page<BoardEntity> pages = boardService.boardList(pageable);
        model.addObject("pages", pages);

        log.info("총 element 수 : {},      전체 page 수 : {},       페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의 element 수 : {}",
                pages.getTotalElements(), pages.getTotalPages(),   pages.getSize(),                pages.getNumber(),     pages.getNumberOfElements());

        int curBlock = (int)Math.floor((pages.getNumber()) / 10);
        int totalBlock = (int)Math.ceil(pages.getTotalPages() / 10);
        int start = (int)Math.floor(pages.getNumber()/10)*10 + 1;
        int last = start + 9 < pages.getTotalPages() ? start + 9 : pages.getTotalPages();

        model.addObject("curBlock", curBlock);
        model.addObject("totalBlock", totalBlock);
        model.addObject("start", start);
        model.addObject("last", last);

        model.setViewName("root");
        return model;
    }

    @RequestMapping("/exceptionTest")
    public String exceptionTest(){

        int a = 1/0;

        return null;
    }

}
