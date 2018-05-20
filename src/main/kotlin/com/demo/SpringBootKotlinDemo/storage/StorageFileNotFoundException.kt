package com.demo.SpringBootKotlinDemo.storage

/**
 * Created by pooja on 17/5/18.
 */
class StorageFileNotFoundException : StorageException {

    constructor(message: String) : super(message)

//    constructor(message: String, cause: Throwable) : super(message, cause)
}