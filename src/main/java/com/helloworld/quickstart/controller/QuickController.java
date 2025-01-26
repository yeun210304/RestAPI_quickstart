package com.helloworld.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuickController {

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
}
