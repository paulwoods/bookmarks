package org.mrpaulwoods.bookmarks.home

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Slf4j
@Controller
@RequestMapping
class HomeController {

    @RequestMapping
    String index() {
        log.info "index()"
        "home/index"
    }

}
