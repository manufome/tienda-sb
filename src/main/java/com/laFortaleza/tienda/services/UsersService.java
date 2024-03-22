package com.laFortaleza.tienda.services;

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
        authorities.add(new SimpleGrantedAuthority("USER"));
        return  new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }

    public UsersEntity saveOrUpdate(UsersEntity user){
        return usersRepository.save(user);
    }
}
