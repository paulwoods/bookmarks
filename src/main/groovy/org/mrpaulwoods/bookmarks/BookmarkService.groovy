package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Slf4j
@Service
@Transactional
class BookmarkService {

    BookmarkRepository bookmarkRepository

    BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository
    }

    @CachePut(value="bookmark", key="#bookmark.id")
    Bookmark create(Bookmark bookmark) {
        log.info "create(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    @Cacheable(value="bookmark", key="#id")
    Bookmark read(Long id) {
        log.info "read(id:$id)"
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id)
        if(!bookmark.isPresent()) {
            throw new BoomkarkNotFoundException()
        }
        bookmark.get()
    }

    @CachePut(value="bookmark", key="#bookmark.id")
    void update(Bookmark bookmark) {
        log.info "update(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    @CacheEvict(value="bookmark", key="#bookmark.id")
    void delete(Bookmark bookmark) {
        log.info "delete(bookmark:$bookmark)"
        bookmarkRepository.delete bookmark
    }

    List<Bookmark> list() {
        bookmarkRepository.findAll()
    }

    boolean count() {
        bookmarkRepository.count()
    }
}
