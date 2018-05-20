package com.demo.SpringBootKotlinDemo.services.impl

import com.demo.SpringBootKotlinDemo.config.Constant.USER_PROFILE
import com.demo.SpringBootKotlinDemo.repository.UserRepo
import com.demo.SpringBootKotlinDemo.services.UserService
import com.demo.SpringBootKotlinDemo.storage.StorageService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

/**
 * Created by pooja on 18/5/18.
 */

@Service("userService")
class UserServiceImpl(
        private val userRepo: UserRepo,
        private  val storageService: StorageService
): UserService {

    override fun uploadProfilePicture(userId: String, multipartFile: MultipartFile) {

        val user = userRepo.findById(userId).block()!!

//        if (user.profilePicturePath != null) {
//            endUserService.deleteExistImg(user.profilePicturePath!!)
//        }

        val file = userId + "_" + System.currentTimeMillis() + "_" + "image" + "_" + multipartFile.originalFilename
        storageService.demoktTemp(multipartFile, file, USER_PROFILE)
//        user.profilePicturePath = file

        userRepo.save(user).block()
    }

}