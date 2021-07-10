package hello.hellospring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    //비동기로 시작하는 메소드
    @Async
    public void onAsync() {
        try {
            Thread.sleep(5000);
            logger.info("onAsync");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    //동기로 시작하는 메소드
    public void onSync() {
        try {
            Thread.sleep(5000);
            logger.info("onSync");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}