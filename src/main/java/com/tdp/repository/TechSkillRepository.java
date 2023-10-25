package com.tdp.repository;

import com.tdp.model.TechSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechSkillRepository extends JpaRepository<TechSkill,Long> {
}
