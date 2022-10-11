package kr.co.foodterrace.board.dto;

import kr.co.foodterrace.board.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {
    private Long idx;
    private String title;
    private String author;
    private String content;
    private Long viewNum;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public PostsResponseDto(Posts entity) {
        this.idx = entity.getIdx();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.viewNum = entity.getViewNum();
        this.createdDate = entity.getCreatedDate();
        this.lastModifiedDate = entity.getLastModifiedDate();
    }
}
