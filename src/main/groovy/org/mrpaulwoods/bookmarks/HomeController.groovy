package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Slf4j
@Controller
@RequestMapping
class HomeController {

    private BookmarkService bookmarkService

    HomeController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService
    }

    @RequestMapping
    String index(final Model model) {
        log.info "index()"
        model.addAttribute "bookmarks", bookmarkService.list()
        "index"
    }

}
