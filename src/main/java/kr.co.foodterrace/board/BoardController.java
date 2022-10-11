package kr.co.foodterrace.board;

import kr.co.foodterrace.board.dto.PostsResponseDto;
import kr.co.foodterrace.board.services.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final PostsService postsService;

    @GetMapping("/board")
    public String showBoard(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "board";
    }

    @GetMapping("/post/save")
    public String savePost() {
        return "post-save";
    }

    @GetMapping("/post/{idx}")
    public String showPost(@PathVariable Long idx, Model model) {
        PostsResponseDto responseDto = postsService.findByIdx(idx);
        model.addAttribute("post", responseDto);
        return "post-show";
    }
}
