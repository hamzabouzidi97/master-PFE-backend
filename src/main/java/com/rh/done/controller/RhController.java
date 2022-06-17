package com.rh.done.controller;

import com.rh.done.dto.ClientDto;
import com.rh.done.dto.ProjetDto;
import com.rh.done.dto.UserDto;
import com.rh.done.service.RhService;
import com.rh.done.util.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rh")
@CrossOrigin("*")
public class RhController {

    @Autowired
    RhService rhService;


    //I need to add diplomes and CNSS , wives, childrens
    @PostMapping("/save-employer")
    ResponseEntity<?> saveEmployer(@RequestBody UserDto userDto){
        System.out.println("user dto : "+userDto);
        UserDto u = this.rhService.saveEmployer(userDto);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/getEmployer/{matricule}")
    ResponseEntity<?> getEmployerByMatricule(@PathVariable("matricule") String matricule){
       MyResponse response = this.rhService.getEmployerByMatricule(matricule);
       if(response.getCode().equals("00"))
        return new ResponseEntity<>(response.getObject(),HttpStatus.OK);
       else
           return new ResponseEntity<>(response.getObject(),HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/add-client")
    ResponseEntity<?> addClient(@RequestBody ClientDto clientDto){
        try {
            final var cltDto = this.rhService.addClient(clientDto);
            return new ResponseEntity<>(cltDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("not",HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/add-projet")
    ResponseEntity<?> addClient(@RequestBody ProjetDto projetDto){
        try {
            final var p = this.rhService.addProjet(projetDto);
            return new ResponseEntity<>(p,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("not",HttpStatus.BAD_REQUEST);
        }

    }


    // add client



}
