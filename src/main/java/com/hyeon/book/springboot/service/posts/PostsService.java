package com.hyeon.book.springboot.service.posts;
import com.hyeon.book.springboot.domain.posts.Posts;
import com.hyeon.book.springboot.domain.posts.PostsRepository;
import com.hyeon.book.springboot.web.dto.PostsListResponseDto;
import com.hyeon.book.springboot.web.dto.PostsResponseDto;
import com.hyeon.book.springboot.web.dto.PostsSaveRequestDto;
import com.hyeon.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    // Save 트랜젝션
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    // Update 트랜젝션
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    // Delete 트랜젝션
    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto((entity));
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()   // 결과로 넘어온 List<Posts>의 Stream을
                .map(PostsListResponseDto::new)         // map을 통해 PostsListResponseDto로 변환 -> List로 반환
                .collect(Collectors.toList());          // List 형태로 처리
    }

}
