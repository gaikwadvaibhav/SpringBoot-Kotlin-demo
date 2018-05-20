package com.demo.SpringBootKotlinDemo.services

import org.springframework.web.multipart.MultipartFile

/**
 * Created by pooja on 18/5/18.
 */
interface UserService {

    fun uploadProfilePicture(userId: String, multipartFile: MultipartFile)

}