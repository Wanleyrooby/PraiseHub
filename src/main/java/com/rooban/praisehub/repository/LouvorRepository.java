package com.rooban.praisehub.repository;

import com.rooban.praisehub.model.Louvor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LouvorRepository extends JpaRepository<Louvor, Long> {

    List<Louvor> findByTituloContainingIgnoreCase(String titulo);

    @Query("""
            SELECT l FROM Louvor l
            JOIN l.tags t
            WHERE t = :tag
            """)
    List<Louvor> findbyTag(String tag);
}
