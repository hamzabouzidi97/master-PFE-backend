package com.rh.done.controller;

import com.rh.done.dto.DemandeMissionDto;
import com.rh.done.dto.ProjetDto;
import com.rh.done.dto.UserDto;
import com.rh.done.entity.Client;
import com.rh.done.entity.Projet;
import com.rh.done.entity.User;
import com.rh.done.entity.Ville;
import com.rh.done.service.CollaborateurService;
import com.rh.done.service.UserService;
import com.rh.done.util.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coll")
@CrossOrigin("*")
public class CollaborateurController {

    @Autowired
    UserService userService;
    @Autowired
    CollaborateurService collaborateurService;


    @GetMapping("/dossier-administratif/{matricule}")
    ResponseEntity<?> getEmployerByMatricule(@PathVariable("matricule") String matricule) {
        MyResponse response = this.collaborateurService.dossierAdministratif(matricule);
        if (response.getCode().equals("00"))
            return new ResponseEntity<>(response.getObject(), HttpStatus.OK);
        else
            return new ResponseEntity<>(response.getObject(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/villes")
    List<Ville> getVilles() {
        return this.collaborateurService.getVilles();
    }

    @GetMapping("/clients")
    List<Client> getClients() {
        return this.collaborateurService.getClients();
    }

    @GetMapping("/{id-client}/projet")
    List<ProjetDto> getProjets(@PathVariable("id-client") Long idClient) {
        return this.collaborateurService.getProjetsByClient(idClient);
    }


    @PostMapping("/save-demande-mission")
    ResponseEntity<?> demanderMission(@RequestBody DemandeMissionDto demandeMissionDto) {
        try {
            System.out.println("d ==> "+demandeMissionDto.toString());
            MyResponse response = this.collaborateurService.saveDemandeMission(demandeMissionDto);
            if(response.getCode().equals("00"))
            return new ResponseEntity<>(response, HttpStatus.OK);
            else
                return new ResponseEntity<>(response.getObject(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("bed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mes-demandes-mission/{id}")
    ResponseEntity<?> getMesDemandesMissions(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(this.collaborateurService.getMesDemandesMissions(id), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("bed", HttpStatus.BAD_REQUEST);
        }
    }

}
