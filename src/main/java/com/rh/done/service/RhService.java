package com.rh.done.service;

import com.rh.done.converter.Converters;
import com.rh.done.converter.UserConverter;
import com.rh.done.dto.ClientDto;
import com.rh.done.dto.ProjetDto;
import com.rh.done.dto.UserDto;
import com.rh.done.entity.Client;
import com.rh.done.entity.Projet;
import com.rh.done.entity.User;
import com.rh.done.repository.ClientRepository;
import com.rh.done.repository.ProjetRepository;
import com.rh.done.repository.RoleRepository;
import com.rh.done.repository.UserRepository;
import com.rh.done.util.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RhService {

    @Autowired
    UserConverter userConverter;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProjetRepository projetRepository;
    public UserDto saveEmployer(UserDto userDto){

        if(Objects.nonNull(userDto.getRoles())){
            User user = this.userConverter.convertToEntity(userDto);
            User userSaved = userRepository.save(user);
            UserDto userDtoSaved = this.userConverter.convertToDto(userSaved);
            return userDtoSaved;
        }
        return new UserDto();
    }

    public MyResponse getEmployerByMatricule(String matricule){
        Optional<User> user=this.userRepository.findByMatricule(matricule);
        return user.map(u -> new MyResponse("00", this.userConverter.convertToDto(u))).orElseGet(() -> new MyResponse("01", "Aucun employer trouver avec ce matricule " + matricule));
    }

    public ClientDto addClient(ClientDto clientDto){
        //Client client= this.userConverter.convertClientDtoToEntity(clientDto);
        Client client= Converters.convertClietDtoToEntity(clientDto);
        System.out.println("client : "+client);
        Client clientSaved=this.clientRepository.save(client);
        return Converters.convertClientToDto(clientSaved);
    }

    public ProjetDto addProjet(ProjetDto projetDto){
        Projet projet = Converters.convertProjetDtoToEntity(projetDto);
        Client client = clientRepository.findById(projetDto.getClient().getId()).get();
        projet.setClient(client);
        return Converters.convertProjetToDto(this.projetRepository.save(projet));
    }
}
