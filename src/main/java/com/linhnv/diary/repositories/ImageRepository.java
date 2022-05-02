package com.linhnv.diary.repositories;

import com.linhnv.diary.models.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "DELETE FROM images i \n" +
            "WHERE i.article_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteByArticleId(String articleId);

    List<Image> findByArticleId(String articleId);

    List<Image> findByStatus(String status);
}
