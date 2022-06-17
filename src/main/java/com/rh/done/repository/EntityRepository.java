package com.rh.done.repository;

import com.rh.done.entity.Entite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<Entite, Long> {
}
