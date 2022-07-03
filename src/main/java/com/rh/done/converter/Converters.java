package com.rh.done.converter;

import com.rh.done.dto.*;
import com.rh.done.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converters {

    public static Client convertClietDtoToEntity(ClientDto clientDto){
        Client client = new Client();
        client.setNomClient(clientDto.getNomClient());
        if(Objects.nonNull(clientDto.getId())){
            client.setId(clientDto.getId());
        }
        return client;
    }
   public static ClientDto convertClientToDto(Client client){
        ClientDto clientDto = new ClientDto();
        if(Objects.nonNull(client.getId())){
            clientDto.setId(client.getId());
        }
        clientDto.setNomClient(client.getNomClient());

        return clientDto;
   }

   public static List<ClientDto> convetListClientToDto(List<Client> clients){
        List<ClientDto> clientDtos = new ArrayList<>();
        for(Client client :  clients){
            clientDtos.add(convertClientToDto(client));
        }
        return clientDtos;
   }
    public static Projet convertProjetDtoToEntity(ProjetDto projetDto){
        Client client = new Client();
        Projet projet = new Projet();
        projet.setNomProjet(projetDto.getNomProjet());
        if(Objects.nonNull(projetDto.getId())) {
            client.setId(projetDto.getClient().getId());
        }
        projet.setClient(client);
        return projet;
    }

    public static ProjetDto convertProjetToDto(Projet projet){
        ProjetDto projetDto = new ProjetDto();
        projetDto.setId(projet.getId());
        projetDto.setNomProjet(projet.getNomProjet());
        projetDto.setClient(convertClientToDto(projet.getClient()));
        return projetDto;
    }

    public static List<ProjetDto> convetListProjetToDto(List<Projet> projets){
        List<ProjetDto> projetDtos = new ArrayList<>();
        for(Projet projet :  projets){
            projetDtos.add(convertProjetToDto(projet));
        }
        return projetDtos;
    }
    public static DemandeMissionDto convertDemandeMissionToDto(DemandeMission  demandeMission){

        return DemandeMissionDto.builder().commentaire(demandeMission.getCommentaire())
                .dateDebut(demandeMission.getDateDebut())
                .dateFin(demandeMission.getDateFin())
                .villeDepart(demandeMission.getVilleDepart())
                .villeRetour(demandeMission.getVilleRetour())
                .duree(demandeMission.getDuree())
                .validParManager(demandeMission.isValidParManager())
                .projet(convertProjetToDto(demandeMission.getProjet()))
                .objetMission(demandeMission.getObjetMission())
                //.client(convertClientToDto(demandeMission.getClient()))
                .build();
    }

    public static DemandeMission convertDemandeMissionToEntity(DemandeMissionDto demandeMissionDto){
        return DemandeMission.builder()
                .dateDebut(demandeMissionDto.getDateDebut())
                .dateFin(demandeMissionDto.getDateFin())
                .villeDepart(demandeMissionDto.getVilleDepart())
                .villeRetour(demandeMissionDto.getVilleRetour())
                .objetMission(demandeMissionDto.getObjetMission())
                .commentaire(demandeMissionDto.getCommentaire())
                //.projet(convertProjetDtoToEntity(demandeMissionDto.getProjet()))
                //.client(convertClietDtoToEntity(demandeMissionDto.getClient()))
                //.validParManager(demandeMissionDto.isValidParManager())
                .build();
    }

    public static List<DemandeMissionDto> convertListDemandeMissionToDto(List<DemandeMission> demandeMissions){
        List<DemandeMissionDto> demandeMissionDtos = new ArrayList<>();
        for(DemandeMission demandeMission: demandeMissions){
            demandeMissionDtos.add(convertDemandeMissionToDto(demandeMission));
        }
        return demandeMissionDtos;
    }

    public static DemandeConge convertCongeDtoMissionToEntity(DemandeCongeDto demandeCongeDto){
        return DemandeConge.builder()
                .dateDebut(demandeCongeDto.getDateDebut())
                .dateFin(demandeCongeDto.getDateFin())
                .validerParManager(demandeCongeDto.isValiderParManager())
                .validerParRh(demandeCongeDto.isValiderParRh())
                .refuserParManager(demandeCongeDto.isRefuserParManager())
                .refuserParRh(demandeCongeDto.isRefuserParRh())
                .commentaire(demandeCongeDto.getCommentaire())
                .typeConge(convertTypeCongeDtoToEntity(demandeCongeDto.getTypeCongeDto()))
                .duree(demandeCongeDto.getDuree())
                .build();
    }

    public static DemandeCongeDto convertCongeEntityToDto(DemandeConge demandeConge){
        return DemandeCongeDto.builder()
                .dateDebut(demandeConge.getDateDebut())
                .dateFin(demandeConge.getDateFin())
                .commentaire(demandeConge.getCommentaire())
                .id(demandeConge.getId())
                .refuserParManager(demandeConge.isRefuserParManager())
                .refuserParRh(demandeConge.isRefuserParRh())
                .validerParManager(demandeConge.isValiderParManager())
                .validerParRh(demandeConge.isValiderParRh())
                .typeCongeDto(convertTypeCongeToDto(demandeConge.getTypeConge()))
                .duree((int)demandeConge.getDuree())
                .build();
    }

    public static List<DemandeCongeDto> convertListDemandeCongeToDto(List<DemandeConge> demandeConges){
        List<DemandeCongeDto> demandeCongeDtos = new ArrayList<>();
        for(DemandeConge demandeConge: demandeConges){
            demandeCongeDtos.add(convertCongeEntityToDto(demandeConge));
        }
        return demandeCongeDtos;
    }
    public static TypeConge convertTypeCongeDtoToEntity(TypeCongeDto typeCongeDto){
        return TypeConge.builder()
                .typeConge(typeCongeDto.getTypeConge())
                .maxJour(typeCongeDto.getMaxJour())
                .minJour(typeCongeDto.getMinJour())
                .id(typeCongeDto.getId())
                .build();
    }


    public static TypeCongeDto convertTypeCongeToDto(TypeConge typeConge){
        return TypeCongeDto.builder()
                .typeConge(typeConge.getTypeConge())
                .maxJour(typeConge.getMaxJour())
                .minJour(typeConge.getMinJour())
                .id(typeConge.getId())
                .build();
    }

    public static List<TypeCongeDto> convertListTypeCongeToDto(List<TypeConge> typeCongeList){
        List<TypeCongeDto> typeCongeDtoList = new ArrayList<>();
        for(TypeConge typeConge: typeCongeList){
            typeCongeDtoList.add(convertTypeCongeToDto(typeConge));
        }
        return typeCongeDtoList;
    }
}
