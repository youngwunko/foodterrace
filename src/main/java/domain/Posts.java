package domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Long readNum;

    public Posts(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.readNum = Long.valueOf(0);
    }

    public void update(String author, String content) {
        this.author = author;
        this.content = content;
    }
}
