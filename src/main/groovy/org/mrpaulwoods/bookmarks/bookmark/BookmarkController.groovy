package org.mrpaulwoods.bookmarks.bookmark

import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@Slf4j
@RestController
@RequestMapping("/bookmark")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAuthority('ROLE_USER')")
class BookmarkController {

    BookmarkService bookmarkService

    BookmarkController(
            BookmarkService bookmarkService
    ) {
        this.bookmarkService = bookmarkService
    }

    @GetMapping
    ResponseEntity<List<Bookmark>> list() {
        log.info "list()"
        new ResponseEntity<List<Bookmark>>(bookmarkService.list(), HttpStatus.OK)
    }

    @PostMapping("/")
    ResponseEntity<Bookmark> create(@Valid @RequestBody BookmarkForm bookmarkForm, BindingResult result) {
        log.info "create(bookmarkForm:$bookmarkForm, result:$result)"
        if (result.hasErrors()) {
            new ResponseEntity<Bookmark>(HttpStatus.BAD_REQUEST)
        } else {
            Bookmark bookmark = new Bookmark(name: bookmarkForm.name, url: bookmarkForm.url)
            new ResponseEntity<Bookmark>(bookmarkService.create(bookmark), HttpStatus.OK)
        }
    }

    @PostMapping("/{id}/up")
    ResponseEntity<Bookmark> upVote(@PathVariable String id) {
        log.info "up(id:$id)"
        new ResponseEntity<Bookmark>(bookmarkService.upVote(id), HttpStatus.OK)
    }

    @PostMapping("/{id}/down")
    ResponseEntity<Bookmark> downVote(@PathVariable String id) {
        log.info "down(id:$id)"
        new ResponseEntity<Bookmark>(bookmarkService.downVote(id), HttpStatus.OK)
    }

}
