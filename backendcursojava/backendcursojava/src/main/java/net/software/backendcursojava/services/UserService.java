package net.software.backendcursojava.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.UserRespository;
import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.share.dto.UserDTO;

@Service

public class UserService implements UserSeviceInterface {

    @Autowired
    UserRespository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        if(userRepository.findUserByEmail(userDto.getEmail()) != null) 
            throw new RuntimeException("El email ya existe");

        // TODO lógica den la creación del usuario
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("testpassword");

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());
        
        UserEntity storedUserDeatil = userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDeatil, userToReturn);

        return null;
    }

    
}
