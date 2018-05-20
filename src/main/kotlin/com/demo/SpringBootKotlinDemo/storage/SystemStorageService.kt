package com.demo.SpringBootKotlinDemo.storage

import com.demo.SpringBootKotlinDemo.config.Constant.USER_PROFILE
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Created by pooja on 17/5/18.
 */
@Service
class SystemStorageService(
        properties: StorageProperties
) : StorageService {

    private val rootLocation: Path = Paths.get(properties.location)
    private val userProfileLocation: Path = Paths.get(properties.userProfileLocation)

    override fun initLocal() {
        try {
            if (!rootLocation.toFile().exists())
                Files.createDirectory(rootLocation)
        }catch (e: IOException){
            throw StorageException("Could not initialize storage",e)
        }
    }

    override fun initFiles() {
        try {
            if (!userProfileLocation.toFile().exists())
                Files.createDirectories(userProfileLocation)
        }catch (e: IOException){
                throw StorageException("Could not initialize storage",e)
        }
    }

    override fun demokt(file: MultipartFile, fileName: String) {

        try {
            if (file.isEmpty) {
                throw StorageException("Failed to lookout empty file " + file.originalFilename!!)
            }
            Files.copy(file.inputStream, this.rootLocation.resolve(fileName))
        } catch (e: IOException) {
            throw StorageException("Failed to lookout file " + file.originalFilename!!, e)
        }
    }

    override fun demoktTemp(file: MultipartFile, fileName: String, fileType: String) {

        if (file.isEmpty) {
            throw StorageException("Failed to lookout empty file " + file.originalFilename!!)
        }

        try {
            if (fileType == USER_PROFILE)
                Files.copy(file.inputStream, this.userProfileLocation.resolve(fileName))
//
//            if (fileType == POST)
//                Files.copy(file.inputStream, this.eventPostLocation.resolve(fileName))

        } catch (e: IOException) {
            throw StorageException("Failed to lookout file " + file.originalFilename!!, e)
        }
    }
}