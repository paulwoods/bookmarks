package org.mrpaulwoods.bookmarks.security.jwt

import org.mrpaulwoods.bookmarks.security.User
import org.mrpaulwoods.bookmarks.security.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository applicationUserRepository

    UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = applicationUserRepository.findByUsername(username)
        if (user == null) {
            throw new UsernameNotFoundException(username)
        }
        user
    }
}