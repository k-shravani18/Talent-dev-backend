package com.tdp.repository;

import com.tdp.model.ClassLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassLinkRepository extends JpaRepository<ClassLink, Long> {
}
