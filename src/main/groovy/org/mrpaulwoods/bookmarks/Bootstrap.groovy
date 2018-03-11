package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.mrpaulwoods.bookmarks.security.Role
import org.mrpaulwoods.bookmarks.security.User
import org.mrpaulwoods.bookmarks.security.UserService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Slf4j
@Service
class Bootstrap {

    UserService userService
    BCryptPasswordEncoder encoder
    Bootstrap(
            UserService userService,
            BCryptPasswordEncoder encoder
    ) {
        this.userService = userService
        this.encoder = encoder
    }

    @PostConstruct
    void init() {

        if(userService.findByUsername("mr.paul.woods@gmail.com")) {
            return
        }

        User user = new User(username:"mr.paul.woods@gmail.com", password: encoder.encode("abcd1234"))
        user.authorities << new SimpleGrantedAuthority(Role.ROLE_USER.toString())
        user.authorities << new SimpleGrantedAuthority(Role.ROLE_ADMIN.toString())

        user = userService.create(user)
    }

//    private BookmarkService bookmarkService
//
//    Bootstrap(BookmarkService bookmarkService) {
//        this.bookmarkService = bookmarkService
//    }
//
//    @PostConstruct
//    void init() {
//        if (!bookmarkService.count()) {
//            bookmarkService.create new Bookmark(name: "Google", url: "http://www.google.com")
//            bookmarkService.create new Bookmark(name: "Yahoo", url: "http://www.yahoo.com")
//            bookmarkService.create new Bookmark(name: "Facebook", url: "http://www.facebook.com")
//        }
//    }

}
