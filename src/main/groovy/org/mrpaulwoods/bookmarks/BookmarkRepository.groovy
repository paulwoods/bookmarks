package org.mrpaulwoods.bookmarks

import org.springframework.data.jpa.repository.JpaRepository

interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}