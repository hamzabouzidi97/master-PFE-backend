package com.rh.done.service;

import com.rh.done.converter.Converters;
import com.rh.done.converter.UserConverter;
import com.rh.done.dto.DemandeCongeDto;
import com.rh.done.dto.DemandeMissionDto;
import com.rh.done.dto.ProjetDto;
import com.rh.done.dto.TypeCongeDto;
import com.rh.done.entity.*;
import com.rh.done.repository.*;
import com.rh.done.util.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CollaborateurService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    VilleRepository villeRepository;

    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DemandeMissionRepository demandeMissionRepository;
    @Autowired
    DemandeCongeRepository demandeCongeRepository;
    @Autowired
    TypeCongeRepository typeCongeRepository;

    public MyResponse dossierAdministratif(String matricule) {
        Optional<User> user = this.userRepository.findByMatricule(matricule);
        return user.map(u -> new MyResponse("00", this.userConverter.convertToDto(u))).orElseGet(() -> new MyResponse("01", "Aucun employer trouver avec ce matricule " + matricule));
    }

    public List<Ville> getVilles() {
        return this.villeRepository.findAll();
    }

    public List<ProjetDto> getProjetsByClient(Long idClient) {
        Client client=this.clientRepository.findById(idClient).get();
        List<Projet> projets=this.projetRepository.findByClient(client);
        List<ProjetDto> projetDtos = Converters.convetListProjetToDto(projets);
        return projetDtos;
    }

    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }


    public MyResponse saveDemandeMission(DemandeMissionDto demandeMissionDto) throws ParseException {
        DemandeMission demandeMission = Converters.convertDemandeMissionToEntity(demandeMissionDto);
        demandeMission.setProjet(projetRepository.findById(demandeMissionDto.getProjet().getId()).get());
        Calendar calDebut = Calendar.getInstance();
        Calendar calFin = Calendar.getInstance();
        calDebut.setTime(demandeMission.getDateDebut());
        calFin.setTime(demandeMission.getDateFin());
        if (calFin.before(calDebut)) {
            return new MyResponse("01", "Date début doit supérieur au date fin");
        }
        if (Calendar.SATURDAY == calDebut.get(Calendar.DAY_OF_WEEK) || Calendar.SUNDAY == calDebut.get(Calendar.DAY_OF_WEEK)) {
            return new MyResponse("01", "Date début ne doit pas un jour de weekend");
        }
        if (Calendar.SATURDAY == calFin.get(Calendar.DAY_OF_WEEK) || Calendar.SUNDAY == calFin.get(Calendar.DAY_OF_WEEK)) {
            return new MyResponse("01", "Date fin ne doit pas un jour de weekend");
        }
        int numberOfDays = 0;
        while (calDebut.before(calFin)) {
            if ((Calendar.SATURDAY != calDebut.get(Calendar.DAY_OF_WEEK))
                    && (Calendar.SUNDAY != calDebut.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
            calDebut.add(Calendar.DATE, 1);
        }
        demandeMission.setDuree(numberOfDays);
        this.demandeMissionRepository.save(demandeMission);
        return new MyResponse("00", "Votre demande ajouté avec succée");
    }


    public List<DemandeMissionDto> getMesDemandesMissions(Long id) {
        Optional<User> user= this.userRepository.findById(id);
        List<DemandeMissionDto> demandeMissionDtos = new ArrayList<>();
        if(user.isPresent()){
            List<DemandeMission> demandeMissions=this.demandeMissionRepository.findByDemandeur(user.get());
            if(!demandeMissions.isEmpty()){
                return Converters.convertListDemandeMissionToDto(demandeMissions);
            }
        }
         return demandeMissionDtos;
    }

    public MyResponse saveDemandeConge(DemandeCongeDto demandeCongeDto){
       DemandeConge demandeConge = Converters.convertCongeDtoMissionToEntity(demandeCongeDto);
       Optional<User> user= this.userRepository.findById((long) demandeCongeDto.getDemandeur());
        if(!user.isPresent()){
            throw new IllegalArgumentException("le demandeur n'existe pas");
        }
       Optional<TypeConge> typeConge= this.typeCongeRepository.findById(demandeCongeDto.getTypeCongeDto().getId());
       if(!typeConge.isPresent()){
           throw new IllegalArgumentException("le type de congé n'existe pas");
       }
       demandeConge.setDemandeur(user.get());
       demandeConge.setTypeConge(typeConge.get());

        this.demandeCongeRepository.save(demandeConge);
       return new MyResponse("00", "Votre demande ajouté avec succée");
    }

    public List<TypeCongeDto> typeCongeList(){
        return Converters.convertListTypeCongeToDto(this.typeCongeRepository.findAll());
    }

        public List<DemandeCongeDto> getMesDemandesConge(Long id) {
        Optional<User> user= this.userRepository.findById(id);
        List<DemandeCongeDto> demandeCongeDtos = new ArrayList<>();
        if(user.isPresent()){
            List<DemandeConge> demandeConges=this.demandeCongeRepository.findByDemandeur(user.get());
            if(!demandeConges.isEmpty()){
                return Converters.convertListDemandeCongeToDto(demandeConges);
            }
        }
        return demandeCongeDtos;
    }
}
