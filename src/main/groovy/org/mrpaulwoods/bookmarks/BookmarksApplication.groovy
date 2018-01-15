package org.mrpaulwoods.bookmarks

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class BookmarksApplication {

    static void main(String[] args) {
        SpringApplication.run BookmarksApplication, args
    }
}
