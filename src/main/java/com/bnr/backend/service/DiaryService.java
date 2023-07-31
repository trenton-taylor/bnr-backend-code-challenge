package com.bnr.backend.service;

import com.bnr.backend.domain.Author;
import com.bnr.backend.domain.DiaryEntry;
import com.bnr.backend.exception.DiaryServiceException;
import com.bnr.backend.repository.DiaryEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class DiaryService {

    private final DiaryEntryRepository diaryEntryRepository;

    public DiaryService(DiaryEntryRepository diaryEntryRepository){
        this.diaryEntryRepository = diaryEntryRepository;
    }

    public List<DiaryEntry> getAllDiaryEntries(){
        return diaryEntryRepository.findAll();
    }

    public DiaryEntry createDiaryEntry(Author author, String title, String body){
        try{
            DiaryEntry de = new DiaryEntry();
            de.setBody(body + " " + Math.random());
            de.setTitle(title + " " + Math.random());
            de.setAuthor(author);
            log.info("Saving diary...");
            return diaryEntryRepository.save(de);
        } catch (Exception e){
            throw new DiaryServiceException("Error creating new diary entry for author " + author.getId());
        }

    }

    public DiaryEntry saveDiaryEntry(DiaryEntry diaryEntry){
        try{
            return diaryEntryRepository.save(diaryEntry);
        } catch (Exception e){
            throw new DiaryServiceException("Error saving diary with id " + diaryEntry.getId());
        }
    }

    public DiaryEntry getDiaryEntry(Long id){
        Optional diaryEntry = diaryEntryRepository.findById(id);
        if(diaryEntry.isPresent()){
            return (DiaryEntry) diaryEntry.get();
        } else {
            throw new DiaryServiceException("Diary entry for id " + id + " does not exist.");
        }
    }

    public void updateDiaryEntry(Long id, String title, String body){
        try{
            if(diaryEntryRepository.existsById(id)){
                DiaryEntry de = diaryEntryRepository.findById(id).get();
                de.setTitle(title);
                de.setBody(body);
                diaryEntryRepository.save(de);
            } else {
                throw new DiaryServiceException("Diary entry with id " + id + "does not exist.");
            }
        } catch (Exception e){
            throw new DiaryServiceException("Error updating diary entry with id " + id);
        }
    }

    public void deleteDiaryEntry(Long id){
        try {
            if(diaryEntryRepository.existsById(id)){
                diaryEntryRepository.deleteById(id);
            } else {
                throw new DiaryServiceException("Diary entry with id " + id + " does not exist.");
            }
        } catch (Exception e){
            throw new DiaryServiceException("Error deleting diary entry with id " + id);
        }
    }

}
