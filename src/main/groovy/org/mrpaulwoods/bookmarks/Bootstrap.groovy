package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Slf4j
@Service
class Bootstrap {

    private BookmarkService bookmarkService

    Bootstrap(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService
    }

    @PostConstruct
    void init() {
        if(!bookmarkService.count()) {
            bookmarkService.create new Bookmark(name:"Google", url:"http://www.google.com")
            bookmarkService.create new Bookmark(name:"Yahoo", url:"http://www.yahoo.com")
            bookmarkService.create new Bookmark(name:"Facebook", url:"http://www.facebook.com")
        }
    }

}
