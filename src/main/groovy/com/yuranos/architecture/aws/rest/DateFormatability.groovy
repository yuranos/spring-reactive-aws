package com.yuranos.architecture.aws.rest

import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
/**
 * Created by yuranos on 10/2/17.
 */
trait DateFormatability {

    /**
     * Called before Controller methods.
     * @param binder
     */
    @InitBinder
    void initBinder(WebDataBinder binder) {
//        will be overridden by yml properties file configuration
//        binder.addCustomFormatter(new DateFormatter("dd-MM-yyyy"))
    }


}
