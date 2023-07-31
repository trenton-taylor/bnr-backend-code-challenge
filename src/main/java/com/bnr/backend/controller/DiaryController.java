package com.bnr.backend.controller;

import com.bnr.backend.entity.DiaryEntry;
import com.bnr.backend.service.DiaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class DiaryController {

    DiaryService diaryService;

    public DiaryController(DiaryService DiaryService){
        this.diaryService = DiaryService;
    }

    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }

    @GetMapping("/posts")
    public List<DiaryEntry> getAllPosts(){
        return diaryService.getAllPosts();
    }
}
