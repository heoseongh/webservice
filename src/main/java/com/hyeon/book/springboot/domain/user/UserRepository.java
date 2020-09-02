package com.hyeon.book.springboot.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// User의 CRUD를 책임질 Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
