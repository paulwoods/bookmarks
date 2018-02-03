package org.mrpaulwoods.bookmarks.bookmark

class BoomkarkNotFoundException extends RuntimeException {

    BoomkarkNotFoundException() {
        super("The bookmark was not found")
    }
}
