package com.rh.done.converter;

import com.rh.done.dto.ClientDto;
import com.rh.done.dto.DemandeMissionDto;
import com.rh.done.dto.UserDto;
import com.rh.done.entity.Client;
import com.rh.done.entity.DemandeMission;
import com.rh.done.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    ModelMapper modelMapper;

    public  UserDto convertToDto(User user){

//        TypeMap<User, UserDto> propertyMapper = modelMapper.createTypeMap(User.class, UserDto.class);
//        propertyMapper.addMappings(mapper -> {mapper.skip(UserDto::getId)});
        UserDto userDto =  modelMapper.map(user,UserDto.class);
        return userDto;
    }

    public  User convertToEntity(UserDto userDto){
       // TypeMap<UserDto, User> propertyMapper = modelMapper.createTypeMap(UserDto.class, User.class);
        return modelMapper.map(userDto,User.class);
    }

    public DemandeMission convertDemandeMissionDtoToEntity(DemandeMissionDto demandeMissionDto){
        return modelMapper.map(demandeMissionDto, DemandeMission.class);
    }


    public Client convertClientDtoToEntity(ClientDto clientDto){
        return modelMapper.map(clientDto, Client.class);
    }

    public ClientDto convertClientToDto(Client client){
        return modelMapper.map(client, ClientDto.class);
    }
}
