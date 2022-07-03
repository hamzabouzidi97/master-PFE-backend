package com.rh.done.repository;

import com.rh.done.entity.DemandeConge;
import com.rh.done.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {

    List<DemandeConge> findByDemandeur(User user);
}
