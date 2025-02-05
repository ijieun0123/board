package com.example.board.controller;

import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardWithAgeResponseDto;
import com.example.board.dto.CreateBoardRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 생성
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto createBoardRequestDto){
        BoardResponseDto boardResponseDto = boardService.save(createBoardRequestDto.getTitle(), createBoardRequestDto.getContents(), createBoardRequestDto.getUsername());

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll(){
        List<BoardResponseDto> boards = boardService.findAll();

        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    // 게시글 선택 조회 ( with age )
    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id){
        BoardWithAgeResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boardService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
