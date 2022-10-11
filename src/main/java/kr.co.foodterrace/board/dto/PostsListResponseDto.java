package kr.co.foodterrace.board.dto;

import kr.co.foodterrace.board.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostsListResponseDto {
    private Long idx;
    private String title;
    private String author;
    private LocalDateTime createdDate;
    private Long viewNum;

    public PostsListResponseDto(Posts entity) {
        this.idx = entity.getIdx();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createdDate = entity.getCreatedDate();
        this.viewNum = entity.getViewNum();
    }
}
