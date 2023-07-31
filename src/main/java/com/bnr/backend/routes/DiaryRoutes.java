package com.bnr.backend.routes;

import com.bnr.backend.domain.DiaryEntry;
import com.bnr.backend.service.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("diary")
public class DiaryRoutes {

    DiaryService diaryService;

    public DiaryRoutes(DiaryService DiaryService){
        this.diaryService = DiaryService;
    }

    @GetMapping("/")
    public List<DiaryEntry> getAllPosts(){
        return diaryService.getAllPosts();
    }

    @GetMapping("/posts/{authorId}")
    public List<DiaryEntry> getAllPostsByAuthor(@PathVariable("authorId") Long authorId){
        return diaryService.getAllPosts().stream().filter(d -> d.getAuthor().id == authorId).toList();
    }


}
