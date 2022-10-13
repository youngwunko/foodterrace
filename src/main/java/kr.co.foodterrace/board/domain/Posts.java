package kr.co.foodterrace.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
