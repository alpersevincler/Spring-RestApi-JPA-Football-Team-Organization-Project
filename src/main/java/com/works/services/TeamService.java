package com.works.services;

import com.works.entities.Team;
import com.works.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    final TeamRepository teamRepository;

    public ResponseEntity save(Team team) {
        //Takım adını ve fid(footballer id)'i teamRepository'deki optional cevap verecek fonksiyona yolla
        Optional<Team> optionalTeam = teamRepository.findByNameEqualsAndFidEqualsAllIgnoreCase(team.getName(), team.getFid());

        if (optionalTeam.isPresent()) {
            return new ResponseEntity("Save Fail!", HttpStatus.BAD_REQUEST);
        }else {
            teamRepository.save(team);
            return new ResponseEntity(team,HttpStatus.OK);
        }
    }

}
