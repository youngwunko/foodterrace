package kr.co.foodterrace.board.services.posts;

import kr.co.foodterrace.board.domain.Posts;
import kr.co.foodterrace.board.domain.PostsRepository;
import kr.co.foodterrace.board.dto.PostsListResponseDto;
import kr.co.foodterrace.board.dto.PostsResponseDto;
import kr.co.foodterrace.board.dto.PostsSaveRequestDto;
import kr.co.foodterrace.board.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getIdx();
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostsResponseDto findByIdx(Long idx) {
        Posts entity = postsRepository.findByIdx(idx).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long updatePost(Long idx, PostsUpdateRequestDto requestDto) {
        Posts post = postsRepository.findByIdx(idx).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return idx;
    }

    @Transactional
    public void deletePost(Long idx) {
        Posts post = postsRepository.findByIdx(idx).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        postsRepository.delete(post);
    }
}
