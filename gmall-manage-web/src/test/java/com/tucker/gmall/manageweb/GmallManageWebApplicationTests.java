package com.tucker.gmall.manageweb;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    Logger logger = LoggerFactory.getLogger(GmallManageWebApplicationTests.class);

    @Test
    public void contextLoads() throws Exception {

        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();

        String url = "188.131.254.195:8888";

        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String originalFilename = "C://Users//tucker//Pictures//头像//null-3c7d7cf1dc62405d.jpg";
        String[] upload_file = storageClient.upload_file(originalFilename,"jpg",null);
        for (int i = 0; i < upload_file.length; i++) {
            url = url+"/"+upload_file[i];
        }
        logger.info("url =="+url);
    }

}
