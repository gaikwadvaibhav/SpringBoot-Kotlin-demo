package com.demo.SpringBootKotlinDemo.util

import com.demo.SpringBootKotlinDemo.storage.StorageFileNotFoundException
import com.demo.SpringBootKotlinDemo.storage.StorageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes

/**
 * Created by pooja on 17/5/18.
 */
class UploadFileController
constructor(private val storageService: StorageService)
{

    @PostMapping("/")
    @RequestMapping("saveFile")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile,
                         redirectAttributes: RedirectAttributes): String {
        storageService.demokt(file, file.originalFilename!!)
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.originalFilename + "!")
        return "redirect:/"
    }

    @ExceptionHandler(StorageFileNotFoundException::class)
    fun handleStorageFileNotFound(exc: StorageFileNotFoundException): ResponseEntity<*> {
        return ResponseEntity.notFound().build<Any>()
    }
}