package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.Caching
import org.springframework.stereotype.Service

@Slf4j
@Service
class BookmarkService {

    BookmarkRepository bookmarkRepository

    BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository
    }

    @Caching(evict = [@CacheEvict("bookmarks")], put = [@CachePut(value = "bookmark", key = "#bookmark.id")])
    Bookmark create(Bookmark bookmark) {
        log.info "create(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    @Cacheable(value = "bookmark", key = "#id")
    Bookmark read(Long id) {
        log.info "read(id:$id)"
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id)
        if (!bookmark.isPresent()) {
            throw new BoomkarkNotFoundException()
        }
        bookmark.get()
    }

    @Caching(evict = [@CacheEvict("bookmarks")], put = [@CachePut(value = "bookmark", key = "#bookmark.id")])
    void update(Bookmark bookmark) {
        log.info "update(bookmark:$bookmark)"
        bookmarkRepository.save bookmark
    }

    @Caching(evict = [@CacheEvict("bookmarks"), @CacheEvict("bookmarks")])
    void delete(Bookmark bookmark) {
        log.info "delete(bookmark:$bookmark)"
        bookmarkRepository.delete bookmark
    }

    @Cacheable("bookmarks")
    List<Bookmark> list() {
        bookmarkRepository.findAll()
    }

    boolean count() {
        bookmarkRepository.count()
    }
}
