package com.rooban.praisehub.repository;

import com.rooban.praisehub.model.Louvor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LouvorRepository extends JpaRepository<Louvor, Long> {

}
