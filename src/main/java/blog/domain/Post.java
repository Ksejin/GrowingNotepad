package blog.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Post {

    private Long id;

    private String title;

    private String context;

    private LocalDateTime postTime;

    public Post(){}

    public Post(String title, String context, LocalDateTime postTime) {
        this.title = title;
        this.context = context;
        this.postTime = postTime;
    }
}