package com.drc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrcApplicationTests {

    @Test
    public void contextLoads() {
        LoggerFactory.getLogger(this.getClass()).info("sss");
    }

}

