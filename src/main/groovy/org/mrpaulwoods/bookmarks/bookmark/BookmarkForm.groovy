package org.mrpaulwoods.bookmarks.bookmark

import groovy.transform.Canonical
import org.hibernate.validator.constraints.URL

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Canonical
class BookmarkForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    String name

    @NotNull
    @NotBlank
    @URL
    @Size(min = 1, max = 300)
    String url

}
