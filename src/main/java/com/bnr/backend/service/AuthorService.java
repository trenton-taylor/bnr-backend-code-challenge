package com.bnr.backend.service;

import com.bnr.backend.domain.Author;
import com.bnr.backend.exception.DiaryServiceException;
import com.bnr.backend.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Long id){
        try{
            return authorRepository.findById(id).get();
        } catch (Exception e){
            throw new DiaryServiceException("Error retrieving author by id " + id);
        }
    }

    public Author createAuthor(String name, String email, String expertise){
        try{
            Author a = new Author();
            a.setName(name);
            a.setEmail(email);
            a.setExpertise(expertise);
            return authorRepository.save(a);
        } catch (Exception e){
            throw new DiaryServiceException("Error saving new author with name " + name);
        }
    }

}
