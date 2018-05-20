package com.demo.SpringBootKotlinDemo.storage

import org.springframework.web.multipart.MultipartFile

/**
 * Created by pooja on 17/5/18.
 */
interface StorageService {

    fun initLocal()

    fun initFiles()

    fun demokt(file: MultipartFile, fileName: String)

    fun demoktTemp(file: MultipartFile, fileName: String, fileType : String)

}