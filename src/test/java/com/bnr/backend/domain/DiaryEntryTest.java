package com.bnr.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DiaryEntryTest {

    private DiaryEntry entry;

    @BeforeEach
    public void init(){
        Author a = new Author(1L, "trenton", "trenton.a.taylor@gmail.com", "java");
        entry = new DiaryEntry(1L, a, "title", "body");
    }

    @Test
    public void testUpdateStockData(){

        Assertions.assertEquals(entry.getId(), 1L);
        Assertions.assertEquals(entry.getTitle(), "title");
        Assertions.assertEquals(entry.getBody(), "body");

        Assertions.assertNotNull(entry.getAuthor());
        Assertions.assertEquals(entry.getAuthor().getId(), 1L);
        Assertions.assertEquals(entry.getAuthor().getName(), "trenton");
        Assertions.assertEquals(entry.getAuthor().getEmail(), "trenton.a.taylor@gmail.com");
        Assertions.assertEquals(entry.getAuthor().getExpertise(), "java");
    }

}
