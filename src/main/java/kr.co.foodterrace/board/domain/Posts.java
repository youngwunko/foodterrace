package kr.co.foodterrace.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
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

    private Long viewNum;

    @Builder
    public Posts(String title, String author, String content, Long viewNum) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.viewNum = viewNum;
    }

    public void update(String author, String content) {
        this.author = author;
        this.content = content;
    }
}
