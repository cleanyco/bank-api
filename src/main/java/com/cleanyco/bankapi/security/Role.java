package com.cleanyco.bankapi.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;


public enum Role {
    USER(EnumSet.of(Permission.GET_BALANCE, Permission.PUT_MONEY)),
    ADMIN(EnumSet.noneOf(Permission.class));

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                               .map(permission -> new SimpleGrantedAuthority(permission.name())).toList();
    }
}
