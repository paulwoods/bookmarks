package org.mrpaulwoods.bookmarks.bookmark

import groovy.transform.Canonical
import org.springframework.data.annotation.Id

@Canonical
class Bookmark implements Serializable {

    private static final long serialVersionUID = 0

    @Id
    String id

    String name

    String url

    int votes = 0

    List<String> tags = []
}
