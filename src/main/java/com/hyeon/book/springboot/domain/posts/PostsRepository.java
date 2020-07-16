package com.hyeon.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

// JapRepository<
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
