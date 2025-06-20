package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.Role;
import com.dleonisa.dleonisa.back_end.modelo.Users;
import com.dleonisa.dleonisa.back_end.modelo.dto.AuthLogin;
import com.dleonisa.dleonisa.back_end.modelo.dto.AuthResponse;
import com.dleonisa.dleonisa.back_end.repository.IUser;
import com.dleonisa.dleonisa.back_end.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users = iUser.findUserByUsuario(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario"+username+"no existing comprending"));
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        Role userRole = users.getRole();
        authorityList.add(new SimpleGrantedAuthority("ROLE_"+userRole.getName()));

        userRole.getPermissionList().forEach(permission ->
                authorityList.add(new SimpleGrantedAuthority(permission.getName()))
        );

        return new User(
                users.getUsuario(),
                users.getPassword(),
                users.isEnabled(),
                users.isAccountNoExpired(),
                users.isCredentialNoExpired(),
                users.isAccountNoLocked(),
                authorityList);
    }
    public AuthResponse loginUser(AuthLogin authLogin){
        String username = authLogin.username();
        String password = authLogin.password();
        Authentication authentication = this.authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accesToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username,"Usuario logueado succesfull", accesToken,true);
        return authResponse;
    }
    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);
        if(userDetails == null){
            throw new BadCredentialsException("Invalid username o password");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }
}
