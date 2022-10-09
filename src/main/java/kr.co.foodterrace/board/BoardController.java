package kr.co.foodterrace.board;

import kr.co.foodterrace.board.domain.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final PostsRepository postsRepository;

    @GetMapping("/board")
    public String showBoard(Model model) {
        model.addAttribute("posts", postsRepository.findAll());
        return "board";
    }

    @GetMapping("/post/save")
    public String postSave() {
        return "post-save";
    }
}
