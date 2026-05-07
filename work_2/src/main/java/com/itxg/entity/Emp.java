package com.itxg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Integer id;

    private String name;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    private Integer deptId;
}