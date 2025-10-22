package org.lyb.jpa.repository;

import org.lyb.jpa.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
//    @Query("select b from Board b where b.title like concat('%',:keyword,'%') or b.content like concat('%', :keyword, '%')")
//    List<Board> findByTitleAndContent(String keyword);

    @Query("select b from Board b where b.title like concat('%',:keyword,'%') or b.content like concat('%', :keyword, '%')")
    Page<Board> findKeyword(String keyword, Pageable pageable);
}
