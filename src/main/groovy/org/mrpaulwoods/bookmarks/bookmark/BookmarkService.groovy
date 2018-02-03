package org.mrpaulwoods.bookmarks.bookmark

import groovy.util.logging.Slf4j
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Slf4j
@Service
class BookmarkService {

    BookmarkRepository bookmarkRepository

    BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository
    }

    Bookmark create(Bookmark bookmark) {
        log.info "create(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    Bookmark read(Long id) {
        log.info "read(id:$id)"
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id)
        if (!bookmark.isPresent()) {
            throw new BoomkarkNotFoundException()
        }
        bookmark.get()
    }

    void update(Bookmark bookmark) {
        log.info "update(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    void delete(Bookmark bookmark) {
        log.info "delete(bookmark:$bookmark)"
        bookmarkRepository.delete bookmark
    }

    List<Bookmark> list() {
        log.info "list()"
        bookmarkRepository.findAll(new Sort(Sort.Direction.ASC, "name"))
    }

    boolean count() {
        log.info "count()"
        bookmarkRepository.count()
    }
}
