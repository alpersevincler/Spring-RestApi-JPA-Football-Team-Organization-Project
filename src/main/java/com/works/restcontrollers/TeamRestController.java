package com.works.restcontrollers;

import com.works.services.TeamService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamRestController {

    final TeamService teamService;
    final HttpServletRequest req;

    @PostMapping("/teamInsert/{teamName}")
    public ResponseEntity teamInsert(@PathVariable String teamName) {
        boolean loginStatus = req.getSession().getAttribute("user") == null;

        //loginStatus null(boş) ise giriş yapılmamış anlamına gelir ve geriye "Please Login" cevabı yollanır
        if (loginStatus) {
            return new ResponseEntity("Please Login", HttpStatus.UNAUTHORIZED);
        }

        return teamService.save(teamName);
    }


}
