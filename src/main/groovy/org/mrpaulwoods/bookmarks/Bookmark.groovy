package org.mrpaulwoods.bookmarks

import groovy.transform.Canonical
import org.hibernate.validator.constraints.URL

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@Canonical
class Bookmark {

    @GeneratedValue
    @Id
    Long id

    @Column(length=100, unique=true, nullable = false)
    String name

    @Column(length=300, nullable = false)
    @URL
    String url
}
