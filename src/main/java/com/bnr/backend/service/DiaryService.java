package com.bnr.backend.service;

import com.bnr.backend.entity.DiaryEntry;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DiaryService {

    public List<DiaryEntry> getAllPosts(){
        return Arrays.asList(new DiaryEntry(1L, 1L, "title1", "description1"), new DiaryEntry(2L, 1L, "title2", "description2"));
    }

}
