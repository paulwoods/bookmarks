package org.mrpaulwoods.bookmarks

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@SpringBootApplication
@EnableCaching
class BookmarksApplication {

    static void main(String[] args) {
        SpringApplication.run BookmarksApplication, args
    }

}
