package com.rh.done.repository;

import com.rh.done.entity.Client;
import com.rh.done.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    List<Projet> findByClient(Client client);
}
