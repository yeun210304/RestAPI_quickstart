package com.helloworld.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo,
        @RequestParam("year") int year) {
        log.info("empNo : {}", empNo);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String company(@PathVariable("id") String id) {
        log.info("id : {}", id);
        return "id";
    }

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto itemDto) {
        log.info("입력값 : ", itemDto.toString());

        boolean res = quickService.registerItem(itemDto);
        
        if(res) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        
        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        return quickService.getItemById(id);
    }

}
