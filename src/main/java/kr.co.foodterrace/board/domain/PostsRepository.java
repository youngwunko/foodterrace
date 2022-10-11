package kr.co.foodterrace.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByIdx(Long idx);

    @Query("SELECT p FROM Posts p ORDER BY p.idx DESC")
    List<Posts> findAllDesc();
}
