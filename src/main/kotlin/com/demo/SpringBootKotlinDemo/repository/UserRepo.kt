package com.demo.SpringBootKotlinDemo.repository

import com.demo.SpringBootKotlinDemo.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

/**
 * Created by pooja on 15/5/18.
 * Newly created repo on 19/05/18
 */
interface UserRepo: ReactiveMongoRepository<User, String> {

    fun findByUsername(username:String): Mono<User>
}