package com.rh.done.converter;

import com.rh.done.dto.ClientDto;
import com.rh.done.dto.DemandeMissionDto;
import com.rh.done.dto.ProjetDto;
import com.rh.done.entity.Client;
import com.rh.done.entity.DemandeMission;
import com.rh.done.entity.Projet;

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
}
