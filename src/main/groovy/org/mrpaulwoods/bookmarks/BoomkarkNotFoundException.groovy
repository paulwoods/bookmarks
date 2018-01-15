package org.mrpaulwoods.bookmarks

class BoomkarkNotFoundException extends RuntimeException {

    BoomkarkNotFoundException() {
        super("The bookmark was not found")
    }
}
