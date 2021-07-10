package hello.hellospring.controller;

import hello.hellospring.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    AsyncService asyncService;

    @Autowired
    private AsyncService service;

    @GetMapping("/async")
    public String goAsync() {
        service.onAsync();
        String str = "Hello Spring boot Async!";
        logger.info(str);
        logger.info("==================================");
        return str;
    }

    @GetMapping("/sync")
    public String goSync() {
        service.onSync();
        String str = "Hello Spring Boot Sync!";
        logger.info(str);
        logger.info("==================================");
        return str;
    }

}
