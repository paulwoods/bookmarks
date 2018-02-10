package org.mrpaulwoods.bookmarks.bookmark

import groovy.transform.Canonical
import org.springframework.data.annotation.Id

@Canonical
class Bookmark {

    @Id
    String id

    String name

    String url

    int votes = 0

    List<String> tags = []
}
