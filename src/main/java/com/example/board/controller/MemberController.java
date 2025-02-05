package com.example.board.controller;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignUpRequestDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.dto.UpdatePasswordRequestDto;
import com.example.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        signUpRequestDto.getUsername(),
                        signUpRequestDto.getPassword(),
                        signUpRequestDto.getAge()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto updatePasswordRequestDto
    ){
        memberService.updatePassword(id, updatePasswordRequestDto.getOldPassword(), updatePasswordRequestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
