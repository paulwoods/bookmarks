package org.mrpaulwoods.bookmarks.bookmark

import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Slf4j
@Controller
@RequestMapping("/bookmark")
@CrossOrigin(origins = "http://localhost:3000")
class BookmarkController {

    BookmarkService bookmarkService

    BookmarkController(
            BookmarkService bookmarkService
    ) {
        this.bookmarkService = bookmarkService
    }

    @GetMapping
    ResponseEntity<List<Bookmark>> list() {
        new ResponseEntity<List<Bookmark>>(bookmarkService.list(), HttpStatus.OK)
    }

    @PostMapping("/{id}/up")
    ResponseEntity<Bookmark> upVote(@PathVariable String id) {
        new ResponseEntity<Bookmark>(bookmarkService.upVote(id), HttpStatus.OK)
    }

    @PostMapping("/{id}/down")
    ResponseEntity<Bookmark> downVote(@PathVariable String id) {
        new ResponseEntity<Bookmark>(bookmarkService.downVote(id), HttpStatus.OK)
    }

}
