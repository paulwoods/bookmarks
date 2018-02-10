package org.mrpaulwoods.bookmarks.bookmark

import groovy.transform.Canonical

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Canonical
class BookmarkForm implements Serializable {

    private static final long serialVersionUID = 0

    @NotBlank
    @NotNull
    @Size(min = 1, max = 100)
    String name

    @NotBlank
    @NotNull
    @Size(min = 1, max = 500)
    String url

}
