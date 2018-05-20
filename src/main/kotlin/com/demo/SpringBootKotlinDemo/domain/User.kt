package com.demo.SpringBootKotlinDemo.domain

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "user")
data class User(
        @Id
        val id:String? = null,

        var name:String? = null,

        var username:String? = null,

        var password: String? = null

)