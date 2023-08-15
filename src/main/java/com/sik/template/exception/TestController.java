package com.sik.template.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/{id}")
    public ResponseEntity<?> test(@PathVariable String id){


        if(id.equals("bad")){
            throw new IllegalArgumentException();
        }

        if(id.equals("user-ex")){
            throw new UserException();
        }

        return new ResponseEntity<>("gg",HttpStatus.OK);
    }


    @Data
    @AllArgsConstructor
    static class MemberDTO{
        private String memberId;
        private String name;
    }
}
