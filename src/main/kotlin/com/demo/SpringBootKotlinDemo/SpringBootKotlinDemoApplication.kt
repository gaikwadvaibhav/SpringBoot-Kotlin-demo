package com.demo.SpringBootKotlinDemo

import com.demo.SpringBootKotlinDemo.storage.StorageProperties
import com.demo.SpringBootKotlinDemo.storage.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(StorageProperties::class)
@SpringBootApplication
class SpringBootKotlinDemoApplication(private val storageService: StorageService): CommandLineRunner{
    override fun run(vararg args: String?) {
        storageService.initFiles()
    }
}
fun main(args: Array<String>) {
    runApplication<SpringBootKotlinDemoApplication>(*args)
}
