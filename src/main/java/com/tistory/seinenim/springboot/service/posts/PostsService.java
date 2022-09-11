package com.tistory.seinenim.springboot.service.posts;

import com.tistory.seinenim.springboot.domain.posts.Posts;
import com.tistory.seinenim.springboot.domain.posts.PostsRepository;
import com.tistory.seinenim.springboot.web.dto.PostsListResponseDto;
import com.tistory.seinenim.springboot.web.dto.PostsResponseDto;
import com.tistory.seinenim.springboot.web.dto.PostsSaveRequestDto;
import com.tistory.seinenim.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//전체 조회 화면 만들기 위해 추가
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class PostsService{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //수정/조회 기능
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
    
    //전체 조회 화면 추가용
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

}

