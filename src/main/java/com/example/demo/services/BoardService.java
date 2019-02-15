package com.example.demo.services;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Board> findAll(){
       return boardRepository.findAll();
    }

    public void createdBoard(Board board){
        board.setCreatedDate(LocalDateTime.now());
        boardRepository.save(board);
    }

    public Board findByBoardId(int idx){
        long id = (long)idx;
        return boardRepository.findById(id).orElse(new Board());
    }
}
