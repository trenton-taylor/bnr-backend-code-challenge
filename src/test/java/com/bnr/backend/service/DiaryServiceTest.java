package com.bnr.backend.service;

import com.bnr.backend.domain.Author;
import com.bnr.backend.domain.DiaryEntry;
import com.bnr.backend.exception.DiaryServiceException;
import com.bnr.backend.repository.DiaryEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DiaryServiceTest {

    @Mock
    DiaryEntryRepository diaryEntryRepository;

    @InjectMocks
    DiaryService diaryService;

    @Test
    public void testGetDiaryEntry(){
        Author a = new Author(1L,"trenton", "trenton.a.taylor@gmail.com", "java");
        DiaryEntry de = new DiaryEntry(1L, a, "title", "body");
        Mockito.when(diaryEntryRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(de));
        Assertions.assertTrue(diaryService.getDiaryEntry(1L).getAuthor().getName().equals("trenton"));
    }

    @Test
    public void testGetDiaryEntryException(){
        DiaryEntry de = null;
        Mockito.when(diaryEntryRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(de));
        Assertions.assertThrows(DiaryServiceException.class, () -> diaryService.getDiaryEntry(1L));
    }

}
