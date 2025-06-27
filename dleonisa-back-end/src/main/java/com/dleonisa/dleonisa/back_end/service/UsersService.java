package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.entity.Role;
import com.dleonisa.dleonisa.back_end.modelo.entity.Users;
import com.dleonisa.dleonisa.back_end.modelo.dto.auth.AuthCreateUser;
import com.dleonisa.dleonisa.back_end.modelo.dto.auth.AuthRequest;
import com.dleonisa.dleonisa.back_end.modelo.dto.auth.AuthResponse;
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

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUser iUser;

    @Autowired
    private IRole iRole;

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

    public AuthResponse createUser(AuthCreateUser createRoleRequest) {

        String username = createRoleRequest.username();
        String password = createRoleRequest.password();
        String rolesRequest = createRoleRequest.role();
        String nombre = createRoleRequest.nombre();
        String apellido = createRoleRequest.apellido();
        String dni = createRoleRequest.dni();

        Optional<Role> role = iRole.findByName(rolesRequest);

        if (role.isEmpty()) {
            throw new IllegalArgumentException("The roles specified does not exist.");
        }

        Users usuarioNuevo = Users.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(role.get())
                .nombre(nombre)
                .apellido(apellido)
                .dni(dni)
                .build();

        Users userSaved = iUser.save(usuarioNuevo);

        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_"+role)
        );

        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);

        AuthResponse authResponse = new AuthResponse(username, "Usuario creado correctamente con rol correspondiente", null);

        return authResponse;
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
