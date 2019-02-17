package com.drc;

import com.drc.utils.LogUtil;
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
        LogUtil.info("aaaaaa");
        LoggerFactory.getLogger(this.getClass()).info("sss");
    }

}

