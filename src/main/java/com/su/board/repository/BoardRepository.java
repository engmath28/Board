package com.su.board.repository;

import com.su.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Modifying // delete, update는 필수로 붙는 어노
    @Query(value = "update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id") // Entity 기준(약어 필수)
    void updateHits(@Param("id") Long id);



}
