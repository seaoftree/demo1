package com.example.demo1;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
public class People {
    private String name;
    private Integer age;
}
