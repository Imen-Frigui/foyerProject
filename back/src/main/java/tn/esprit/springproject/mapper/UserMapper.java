package tn.esprit.springproject.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.springproject.dtos.SignUpDto;
import tn.esprit.springproject.dtos.UserDto;
import tn.esprit.springproject.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

//    @Mapping(target = "motDePasse",ignore = true)
    User signUpToUser(SignUpDto signUpDto);


}
