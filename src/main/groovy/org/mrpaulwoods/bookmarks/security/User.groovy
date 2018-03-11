package org.mrpaulwoods.bookmarks.security

import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Canonical
class User implements UserDetails {

    @Id
    String id

    String username
    String password
    boolean enabled = true
    boolean credentialsNonExpired = true
    boolean accountNonLocked = true
    boolean accountNonExpired = true
    List<GrantedAuthority> authorities = []
}
