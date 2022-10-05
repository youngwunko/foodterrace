package dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDto {
    private Long idx;
    private String title;
    private String author;
    private Long readNum;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
