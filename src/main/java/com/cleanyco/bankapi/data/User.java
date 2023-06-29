package com.cleanyco.bankapi.data;

import com.cleanyco.bankapi.security.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "username")
    @Min(value = 2, message = "Username must be at least 2 characters long")
    @Max(value = 50, message = "Username must be no longer than 50 characters")
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(name = "password") //TODO: написать регулярку для поиска спецсимволов в пароле
    @Min(value = 8, message = "Username must be at least 8 characters long")
    @Max(value = 100, message = "Username must be no longer than 100 characters")
    private String password;

    @Column(name = "email")
    @Email(message = "Provided email is not correct")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotBlank
    private Role role;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
