package net.software.backendcursojava.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.UserRespository;
import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.share.dto.UserDTO;

@Service
public class UserService implements UserSeviceInterface {

    @Autowired
    UserRespository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        if(userRepository.findUserByEmail(userDto.getEmail()) != null) 
            throw new RuntimeException("El email ya existe");

        // TODO lógica den la creación del usuario
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword(
            bCryptPasswordEncoder.encode(userDto.getPassword()) );

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());
        
        UserEntity storedUserDeatil = userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDeatil, userToReturn);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmail(email);

        if(userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    
}
