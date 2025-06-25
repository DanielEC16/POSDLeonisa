package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.Users;
import com.dleonisa.dleonisa.back_end.modelo.dto.AuthRequest;
import com.dleonisa.dleonisa.back_end.modelo.dto.AuthResponse;
import com.dleonisa.dleonisa.back_end.repository.IRole;
import com.dleonisa.dleonisa.back_end.repository.IUser;
import com.dleonisa.dleonisa.back_end.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUser iUser;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Users users = iUser.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        String rol = "ROLE_" + users.getRole().getName();

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(rol);

        return new User(
                users.getUsername(),
                users.getPassword(),
                authorities);
    }

    public AuthResponse loginUser(AuthRequest authRequest){
        String username = authRequest.username();
        String password = authRequest.password();
        Authentication authentication = this.authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username,"Usuario logueado",accesToken);
        return authResponse;
    }
    public Authentication authenticate(String username,String password){
        UserDetails userDetails = this.loadUserByUsername(username);
        if(userDetails ==null){
            throw new BadCredentialsException("Usuario o contraseña incorrecto");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Contraseña invalida");
        }
        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }

}
