package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.services.FootballerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/footballer")
public class FootballerRestController {

    final FootballerService footballerService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Footballer footballer) {
        return footballerService.register(footballer);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Footballer footballer) {
        return footballerService.login(footballer);
    }

}
