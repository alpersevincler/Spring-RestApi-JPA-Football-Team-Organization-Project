package com.works.services;

import com.works.entities.Footballer;
import com.works.projections.IFootballer;
import com.works.repositories.FootballerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballerService {

    final FootballerRepository footballerRepository;
    final HttpServletRequest req;

    public ResponseEntity register(Footballer footballer) {
        try {
            Optional<Footballer> optionalFootballer = footballerRepository.findByEmailEqualsIgnoreCase(footballer.getEmail());
            if (optionalFootballer.isPresent()) {
                return new ResponseEntity( footballer.getEmail() + ": This email address is already being used!", HttpStatus.BAD_REQUEST);
            }else {
                footballerRepository.save(footballer);
                return new ResponseEntity(footballer,HttpStatus.OK);
            }
        }catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity login(Footballer footballer) {
        Optional<Footballer> optionalFootballer = footballerRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(footballer.getEmail(), footballer.getPassword());
        if (optionalFootballer.isPresent()) {
            req.getSession().setAttribute("user", optionalFootballer.get());
            return new ResponseEntity(optionalFootballer.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity("Error: The email address or password is incorrect", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity teamCreate() {
        List<IFootballer> alist = footballerRepository.getTeamCreate("A", 6,0);
        List<IFootballer> blist = footballerRepository.getTeamCreate("B",6,0);

        Map hm = new LinkedHashMap();
        hm.put( "Team A", alist );
        hm.put( "Team B", blist );

        return new ResponseEntity(hm,HttpStatus.OK);
    }


    public ResponseEntity backUpCreate() {
        List<IFootballer> alist = footballerRepository.getTeamCreate("A", 3,7);
        List<IFootballer> blist = footballerRepository.getTeamCreate("B",3,7);

        Map hm = new LinkedHashMap();
        hm.put( "Team A", alist );
        hm.put( "Team B", blist );

        return new ResponseEntity(hm,HttpStatus.OK);
    }

}
