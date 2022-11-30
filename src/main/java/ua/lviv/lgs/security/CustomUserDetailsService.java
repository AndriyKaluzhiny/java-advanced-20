package ua.lviv.lgs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.repository.UserRoleRepository;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }
        List<String> roles = userRolesRepository.findRoleByUserName(user.getName());
        System.out.println(roles.toString());
        System.out.println(user.getPassword());
        return new CustomUserDetails(user, roles);
    }
}
