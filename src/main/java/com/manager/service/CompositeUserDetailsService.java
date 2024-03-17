package com.manager.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CompositeUserDetailsService implements UserDetailsService {

    private final StudentService studentService;
    private final SuperAdminService superAdminService;

    public CompositeUserDetailsService(StudentService studentService, SuperAdminService superAdminService) {
        this.studentService = studentService;
        this.superAdminService = superAdminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = studentService.loadUserByUsername(username);
        if (userDetails == null) {
            userDetails = superAdminService.loadUserByUsername(username);
        }
        return userDetails;
    }
}