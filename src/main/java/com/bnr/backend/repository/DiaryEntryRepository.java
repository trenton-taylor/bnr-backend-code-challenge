package com.bnr.backend.repository;

import com.bnr.backend.domain.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {


}
