package org.mrpaulwoods.bookmarks.bookmark

class BookmarkNotFoundException extends RuntimeException {

    BookmarkNotFoundException() {
        super("The bookmark was not found.")
    }

}
