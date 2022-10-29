package com.uol.api.repository;

import com.uol.api.enums.HeroType;
import com.uol.api.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findByType (HeroType heroType);
}
