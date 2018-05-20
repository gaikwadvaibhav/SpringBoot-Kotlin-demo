package com.demo.SpringBootKotlinDemo.controller

import com.demo.SpringBootKotlinDemo.config.Constant.FAIL
import com.demo.SpringBootKotlinDemo.config.Constant.IMG_SAVE_SUCCESS
import com.demo.SpringBootKotlinDemo.config.Constant.LOGIN_SUCCESS
import com.demo.SpringBootKotlinDemo.config.Constant.MESSAGE
import com.demo.SpringBootKotlinDemo.config.Constant.NOT_FOUND
import com.demo.SpringBootKotlinDemo.config.Constant.RESULT
import com.demo.SpringBootKotlinDemo.config.Constant.STATUS
import com.demo.SpringBootKotlinDemo.config.Constant.SUCCESS
import com.demo.SpringBootKotlinDemo.domain.User
import com.demo.SpringBootKotlinDemo.repository.UserRepo
import com.demo.SpringBootKotlinDemo.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono

@CrossOrigin(allowedHeaders = ["Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"],
        methods = [RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/api/user")
class UserController(
        private val userRepo: UserRepo,
        private val userService: UserService
) {
    companion object {
        private val map = HashMap<String, Any>()
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }
    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): Mono<ResponseEntity<*>> {

        val re = userRepo.save(user).block()!!

        map[STATUS] = SUCCESS
        map[RESULT] = re
        return Mono.just(ResponseEntity.ok(map))
    }

    @GetMapping("login")
    fun login(@RequestParam username: String, @RequestParam password: String): Mono<ResponseEntity<*>> {
        val existingUser = userRepo.findByUsername(username).block()!!
        log.info("existingUser : $existingUser")

        if (existingUser.username.equals(username) && existingUser.password.equals(password)) {

            map[STATUS] = SUCCESS
            map[RESULT] = existingUser
            map[MESSAGE] = LOGIN_SUCCESS
            return Mono.just(ResponseEntity.ok(map))
        } else {
            map[STATUS] = FAIL
            map[MESSAGE] = NOT_FOUND
            return Mono.just(ResponseEntity.badRequest().body(map))
        }
    }

    @PostMapping("/uploadProfilePic")
    fun uploadProfilePic(@RequestParam userId: String,
                         @RequestParam multipartFile: MultipartFile
    ): Mono<ResponseEntity<*>> {
        map.clear()
        userService.uploadProfilePicture(userId, multipartFile)

        map[STATUS] = SUCCESS
        map[MESSAGE] = IMG_SAVE_SUCCESS
        return Mono.just(ResponseEntity.ok(map))
    }
}