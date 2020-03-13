package com.yuanmeng.starrysky;

import com.yuanmeng.starrysky.entity.Ugc;
import com.yuanmeng.starrysky.mapper.UgcMapper;
import com.yuanmeng.starrysky.service.UgcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StarryskyApplicationTests {
    @Autowired
    private UgcService ugcService;

    @Test
    void contextLoads() {
        List<Ugc> tmp = ugcService.list();
        Ugc ugc = new Ugc();
        ugc.setGoodsId(111);
        ugc.setSourceUserid(222);
        ugc.setType(1);
        ugcService.save(ugc);

    }

}
