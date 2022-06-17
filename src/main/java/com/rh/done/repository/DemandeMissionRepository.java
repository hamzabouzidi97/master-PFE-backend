package com.rh.done.repository;

import com.rh.done.entity.DemandeMission;
import com.rh.done.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeMissionRepository extends JpaRepository<DemandeMission, Long> {

      List<DemandeMission> findByDemandeur(User user);
}
