package com.Develop.joblisting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@NoArgsConstructor

@Document(collection = "JobPost")
public class Entity {
    private String desc;
    private int exp;
    private String profile;
    private String[] tech;

}
