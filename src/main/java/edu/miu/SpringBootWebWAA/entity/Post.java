package edu.miu.SpringBootWebWAA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
@AllArgsConstructor
public class Post {
    long id;
    String content;
    String title;
    String author;
}
