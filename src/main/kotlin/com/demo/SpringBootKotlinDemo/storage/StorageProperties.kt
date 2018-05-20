package com.demo.SpringBootKotlinDemo.storage

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by pooja on 17/5/18.
 */
@ConfigurationProperties("storage")
class StorageProperties {

    var location = "./upload-dir"
    var userProfileLocation = "./upload-dir/user/user_profile"
    var postLocation = "./upload-dir/post"


}