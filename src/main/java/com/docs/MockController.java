package com.docs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by UI03 on 2017/8/18.
 */
@RestController
public class MockController {

    @GetMapping("/")
    public Map<String, String> mockHello(@RequestParam String name){
        return Collections.singletonMap("message","hello "+name) ;
//        return Collections.singletonMap("message", "Hello World");
    }
}
