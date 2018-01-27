package org.mrpaulwoods.bookmarks

import org.springframework.data.mongodb.repository.MongoRepository

interface BookmarkRepository extends MongoRepository<Bookmark, Long> {

}