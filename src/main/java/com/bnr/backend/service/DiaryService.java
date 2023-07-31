package com.bnr.backend.service;

import com.bnr.backend.domain.Author;
import com.bnr.backend.domain.DiaryEntry;
import com.bnr.backend.repository.DiaryEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiaryService {

    private final DiaryEntryRepository diaryEntryRepository;

    public DiaryService(DiaryEntryRepository diaryEntryRepository){
        this.diaryEntryRepository = diaryEntryRepository;
    }

    public List<DiaryEntry> getAllPosts(){
        return diaryEntryRepository.findAll();
    }

    public void saveDiaryEntry(Author author, String title, String body){
        DiaryEntry de = new DiaryEntry();
        de.setBody(body);
        de.setTitle(title);
        de.setAuthor(author);
        diaryEntryRepository.save(de);
    }

}
