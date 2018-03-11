package org.mrpaulwoods.bookmarks.security

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username)
}
