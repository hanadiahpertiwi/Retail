package com.ERetail.service;

import com.ERetail.model.AppUsers;
import com.ERetail.model.Role;
import com.ERetail.repository.AppUsersRepository;
import com.ERetail.repository.RoleRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = { SQLException.class, Exception.class })
@Slf4j
public class AppUsersService implements UserDetailsService {
    @Autowired
    private AppUsersRepository appUsersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows(UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) {

        val appUsers = appUsersRepository.findByUsername(username);

        if (Optional.ofNullable(appUsers).isPresent()) {

            log.info("user {} is available in the database", username);

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

            appUsers.getRoles().forEach(role -> {

                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });

            return new org.springframework.security.core.userdetails.User(appUsers.getUsername(), appUsers.getPassword(),
                    authorities);

        } else {

            log.info("user {} is not available in the database", username);
            throw new UsernameNotFoundException("user " + username + " is not available in the database");
        }
    }

    @SneakyThrows(Exception.class)
    public AppUsers saveUsers(AppUsers appUsers) {

        log.info("saving new user {} to the database", appUsers.getName());

        appUsers.setPassword(passwordEncoder.encode(appUsers.getPassword()));

        return appUsersRepository.save(appUsers);
    }

    @SneakyThrows(Exception.class)
    public Role saveRole(Role role) {

        log.info("saving new role {} to the database", role.getName());

        return roleRepository.save(role);
    }

    @SneakyThrows(Exception.class)
    public void addRoleToUser(String username, String roleName) {

        log.info("adding role {} to user {}", roleName, username);

        val appUsers = appUsersRepository.findByUsername(username);
        val role = roleRepository.findByName(roleName);

        appUsers.getRoles().add(role);
    }

    @SneakyThrows(Exception.class)
    public AppUsers getUsers(String username) {

        log.info("getting user{} from the database", username);

        return appUsersRepository.findByUsername(username);
    }

    @SneakyThrows(Exception.class)
    public List<AppUsers> getUsers() {

        log.info("getting all users from the database");

        return appUsersRepository.findAll();
    }
}
