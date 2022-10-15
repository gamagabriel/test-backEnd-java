package com.uol.api.repository;

import com.uol.api.enums.HeroiEnum;
import com.uol.api.model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {

    List<Heroi> findByHeroiEnum (HeroiEnum heroiEnum);
}
