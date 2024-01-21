package edu.miu.SpringBootWebWAA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String content;
    String title;
    String author;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
