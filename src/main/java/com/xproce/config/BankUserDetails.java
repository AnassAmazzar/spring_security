package com.xproce.config;

import com.xproce.dao.entities.Customer;
import com.xproce.dao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String login="";
        String password="";
        String role="";
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Customer> customers = customerRepository.findByEmail(username);
        System.out.println(customers.get(0).getEmail());
        if(customers.size()==0){
            throw new UsernameNotFoundException(username + "Does Not Found");
        }else {
            login = customers.get(0).getEmail();
            password = customers.get(0).getPassword();
            role = String.valueOf(customers.get(0).getRole());
            System.out.println("login " + login + " password " + password + " role " + role);
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return new User(login, password, authorities);
    }
}
