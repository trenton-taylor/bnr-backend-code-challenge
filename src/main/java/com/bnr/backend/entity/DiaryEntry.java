package com.bnr.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaryEntry {

    private Long id;

    private Long userId;

    private String title;

    private String body;

}
