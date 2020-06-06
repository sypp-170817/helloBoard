package com.example.helloboard.service;

import com.example.helloboard.entity.BoardEntity;
import com.example.helloboard.param.request.BoardReq;
import com.example.helloboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public void writeBoard(BoardReq boardReq){
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardReq.getTitle())
                .content(boardReq.getContent())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        boardRepository.save(boardEntity);
    }

    @Transactional
    public Page<BoardEntity> boardList(Pageable pageable){
        Page<BoardEntity> boardEntityPage = boardRepository.findAll(pageable);
        return boardEntityPage;
    }

}
