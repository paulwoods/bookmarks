package org.mrpaulwoods.bookmarks.bookmark

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class BookmarkService {

    BookmarkRepository bookmarkRepository

    BookmarkService(
            BookmarkRepository bookmarkRepository
    ) {
        this.bookmarkRepository = bookmarkRepository
    }

    Bookmark create(Bookmark bookmark) {
        log.info "create(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    Bookmark read(String id) {
        log.info "read(id:$id)"
        Optional<Bookmark> bookmark = this.bookmarkRepository.findById(id)
        if (bookmark.isPresent()) {
            bookmark.get()
        } else {
            throw new BookmarkNotFoundException()
        }
    }

    void update(Bookmark bookmark) {
        log.info "update(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    void delete(Bookmark bookmark) {
        log.info "delete(bookmark:$bookmark)"
        bookmarkRepository.delete bookmark.id
    }

    List<Bookmark> list() {
        log.info "list()"
        this.bookmarkRepository.findAll()
    }

    Bookmark upVote(String id) {
        log.info "upVote(id:$id)"
        Bookmark bookmark = read(id)
        bookmark.votes++
        update bookmark
        bookmark
    }

    Bookmark downVote(String id) {
        log.info "downVote(id:$id)"
        Bookmark bookmark = read(id)
        bookmark.votes--
        update bookmark
        bookmark
    }

}
