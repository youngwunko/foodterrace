package kr.co.foodterrace.board;

import kr.co.foodterrace.board.dto.PostsResponseDto;
import kr.co.foodterrace.board.dto.PostsSaveRequestDto;
import kr.co.foodterrace.board.services.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/post")
    public Long savePost(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/api/post/{idx}")
    public PostsResponseDto showPost(@PathVariable Long idx) {
        PostsResponseDto responseDto = postsService.findByIdx(idx);
        return responseDto;
    }
}
