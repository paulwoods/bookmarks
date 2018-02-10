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

    List<Bookmark> list() {
        this.bookmarkRepository.findAll()
    }

    Bookmark read(String id) {
        Optional<Bookmark> bookmark = this.bookmarkRepository.findById(id)
        if (bookmark.isPresent()) {
            bookmark.get()
        } else {
            throw new BookmarkNotFoundException()
        }
    }

    void update(Bookmark bookmark) {
        bookmarkRepository.save bookmark
    }

    void delete(Bookmark bookmark) {
        bookmarkRepository.delete bookmark.id
    }

    Bookmark upVote(String id) {
        Bookmark bookmark = read(id)
        bookmark.votes++
        update bookmark
        bookmark
    }

    Bookmark downVote(String id) {
        Bookmark bookmark = read(id)
        bookmark.votes--
        update bookmark
        bookmark
    }
}
