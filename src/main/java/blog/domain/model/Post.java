package blog.domain.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Post {

    private Long id;

    private String writer;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDateTime postTime;

    public Post(){}

    public Post(String writer,String title, String content, LocalDateTime postTime) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.postTime = postTime;
    }
}
