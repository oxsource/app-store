package net.oxsource.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用商店Controller
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    String index() {
        return "This is store index";
    }
}
