package com.tistory.seinenim.springboot.domain.posts;

//Posts 클래스로 DB 접근하게해줌
//DB Layer 접근자. JPA에선 Repository로 부름. 인터페이스로 생성
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    
}
