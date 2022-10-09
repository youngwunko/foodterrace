package kr.co.foodterrace.board;

import kr.co.foodterrace.board.dto.PostsSaveRequestDto;
import kr.co.foodterrace.board.services.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
