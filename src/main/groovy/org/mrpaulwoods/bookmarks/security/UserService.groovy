package org.mrpaulwoods.bookmarks.security

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Service
@Transactional
class UserService {

    private UserRepository userRepository

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    User findByUsername(String username) {
        log.info "findByUsername(username:$username)"
        userRepository.findByUsername(username)
    }

    User create(User user) {
        userRepository.save user
    }
}
