package com.bnr.backend.routes;

import com.bnr.backend.domain.Author;
import com.bnr.backend.domain.DiaryEntry;
import com.bnr.backend.domain.ServiceResponse;
import com.bnr.backend.exception.DiaryServiceException;
import com.bnr.backend.service.AuthorService;
import com.bnr.backend.service.DiaryService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("diary")
public class DiaryRoutes {

    DiaryService diaryService;
    AuthorService authorService;

    public DiaryRoutes(DiaryService DiaryService, AuthorService authorService){
        this.diaryService = DiaryService;
        this.authorService = authorService;
    }

    @GetMapping("entries")
    public List<DiaryEntry> getAllEntries(){
        return diaryService.getAllDiaryEntries();
    }

    @GetMapping("entry/{id}")
    public DiaryEntry getDiaryEntry(@PathVariable("id") Long id){
        return diaryService.getDiaryEntry(id);
    }

    @PostMapping("entry")
    public DiaryEntry saveDiaryEntry(@RequestBody DiaryEntry diary){
        if(diary.getAuthor() != null){
            diary.setAuthor(authorService.getAuthor(diary.getAuthor().getId()));
        } else {
            throw new DiaryServiceException("Error saving diary entry. Author for diary entry " + diary.getId() + " not specified.");
        }
        return diaryService.saveDiaryEntry(diary);
    }

    @PostMapping("author")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author.getName(), author.getEmail(), author.getExpertise());
    }

    @GetMapping("author/{id}")
    public List<DiaryEntry> getDiaryEntriesByAuthor(@PathVariable("id") Long authorId){
        return diaryService.getAllDiaryEntries().stream().filter(d -> d.getAuthor().id == authorId).toList();
    }

    @PostMapping("author/{id}")
    public DiaryEntry saveDiaryEntry(@PathVariable("id") Long authorId){
        String title = "title " + Math.random();
        String body = "body " + Math.random();
        return diaryService.createDiaryEntry(authorService.getAuthor(authorId), title, body);
    }

    @DeleteMapping("entries/{id}")
    public ServiceResponse deleteDiaryEntry(@PathVariable("id") Long id){
        diaryService.deleteDiaryEntry(id);
        return new ServiceResponse(HttpStatus.OK.value(), "Successfully deleted diary entry with id " + id);
    }

}
