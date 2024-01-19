package edu.miu.SpringBootWebWAA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    long id;
    String name;
    List<Post> posts;
}
