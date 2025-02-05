package com.example.board.service;

import com.example.board.dto.BoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardResponseDto save(String title, String contents, String username) {
        // 멤버가 있는지 확인한다.
        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        // 멤버가 있다면 -> 저장한다.
        Board board = new Board(title, contents);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);

        // 반환값은 BoardResponseDto
        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    public List<BoardResponseDto> findAll() {
        List<BoardResponseDto> boards = boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::toDto)
                .collect(Collectors.toList());

        return boards;
    }
}
