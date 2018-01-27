package org.mrpaulwoods.bookmarks

import groovy.transform.Canonical
import org.springframework.data.annotation.Id

@Canonical
class Bookmark {

    @Id
    String id
    String name
    String url
}
