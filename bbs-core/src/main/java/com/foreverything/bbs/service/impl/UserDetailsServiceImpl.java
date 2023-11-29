package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Role;
import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = loginMapper.loadUserByUserEmail(email);

        if (user == null) {
            //TODO 这里后续配一下log4j
            throw new UsernameNotFoundException("用户不存在");
        }

//        这里根据用户ID查询角色
        List<Role> roles = loginMapper.findRoleByUserId(user.getId());

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        session.setAttribute("userName", user.getName());
        session.setAttribute("userEmail", email);
        session.setAttribute("userPoints", user.getPoints());
        session.setAttribute("roleName", roles.get(0).getName());

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
