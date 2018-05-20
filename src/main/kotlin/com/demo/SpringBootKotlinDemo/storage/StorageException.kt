package com.demo.SpringBootKotlinDemo.storage

/**
 * Created by pooja on 17/5/18.
 */
open class StorageException : RuntimeException{
    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}