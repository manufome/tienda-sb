package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.dto.UserDTO;
import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.models.UsersEntity;
import com.laFortaleza.tienda.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsersService implements UserDetailsService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity userEntity = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró el nombre de usuario"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        String role = userEntity.getRol().toString();
        authorities.add(new SimpleGrantedAuthority(role.equals("admin") ? "ROLE_ADMIN" : "ROLE_USER"));
        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
    public String saveUser(UserDTO user){
        String name = user.getName();
        String username = user.getUsername();
        String email = user.getEmail();
        String address = user.getAddress();
        String password = user.getPassword();
        usersRepository.saveUser(name, username, email, address, password);
        return "message=Usuario registrado con éxito";
    }

    public UserDTO getUserInfo(String username){
        return usersRepository.getUserInfo(username).orElse(new UserDTO());
    }
    public UsersEntity saveOrUpdate(UsersEntity user){
        return usersRepository.save(user);
    }
}
