package net.software.backendcursojava.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.software.backendcursojava.share.dto.UserDTO;

public interface UserSeviceInterface extends UserDetailsService{
    
    public UserDTO createUser(UserDTO userDto);

}
