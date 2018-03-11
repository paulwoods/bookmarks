package org.mrpaulwoods.bookmarks

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class BookmarksApplication implements WebMvcConfigurer {

    static void main(String[] args) {
        SpringApplication.run BookmarksApplication, args
    }

    @Override
    void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login")
        registry.addViewController("/logout").setViewName("logout")
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
