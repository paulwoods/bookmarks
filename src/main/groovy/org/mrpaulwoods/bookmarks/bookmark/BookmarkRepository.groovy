package org.mrpaulwoods.bookmarks.bookmark

import org.springframework.data.mongodb.repository.MongoRepository

interface BookmarkRepository extends MongoRepository<Bookmark, Long> {
}
