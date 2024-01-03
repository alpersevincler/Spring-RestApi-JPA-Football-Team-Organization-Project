package com.works.repositories;

import com.works.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // Daha önce, şu an gönderilen takım ismi(name'i) ve fid değeri ile bir kayıt oluşturulmuş mu?
    Optional<Team> findByNameEqualsAndFidEqualsAllIgnoreCase(String name, Long fid);
}