package com.codve.read;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author admin
 * @date 2019/10/26 14:22
 */
@Entity
public class Reader implements UserDetails {
    private static final long serialVersionUID = 1;

    @Id
    private String username;

    private String fullname;

    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 授予 READER 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    /**
     * 不过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 不加锁
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证不过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 不禁用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
