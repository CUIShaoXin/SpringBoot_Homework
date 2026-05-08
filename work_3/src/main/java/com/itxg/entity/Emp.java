package com.itxg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Integer id;
    private String name;
    private String gender;
    private Integer deptId;
}