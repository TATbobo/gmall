package com.tucker.gmall.manageservice;

import com.tucker.gmall.bean.PmsProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class GmallManageServiceApplicationTests {

    @Test
    public void contextLoads() {
        List<PmsProductInfo> pmsProductInfos= new ArrayList();
        for (PmsProductInfo pmsProductInfo:pmsProductInfos) {
            System.out.println(pmsProductInfo.getSpuImageList());
        }
    }

}
