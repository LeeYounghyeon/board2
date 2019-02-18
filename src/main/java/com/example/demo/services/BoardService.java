package com.example.demo.services;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Board updateBoard(Board board){
        board.setCreatedDate(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public void boardDelete(int idx){
        long id = (long)idx;
        boardRepository.deleteById(id);
    }

    public int paging(){
        int totalPageNo;
        int pageSize=5;
        int pageCount = (int)boardRepository.count();

        totalPageNo = pageCount/pageSize;
        if(pageCount % pageSize >0){
            totalPageNo++;
        }

        return totalPageNo;
    }

    public Page<Board> boardListFind(int pageNo){
        Pageable pageable;
        pageable = PageRequest.of(pageNo,5);
        return boardRepository.findAll(pageable);
    }
}
