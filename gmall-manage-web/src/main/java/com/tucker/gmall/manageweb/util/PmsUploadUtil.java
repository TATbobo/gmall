package com.tucker.gmall.manageweb.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class PmsUploadUtil {

    private static Logger logger = LoggerFactory.getLogger(PmsUploadUtil.class);

    private static String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();

    private static String BASE_URL = "http://188.131.254.195:8888";

    public static String fileUpload(MultipartFile multipartFile){

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StorageClient storageClient = new StorageClient(trackerServer,null);

        String[] upload_file = new String[0];
        try {
            
            byte[] imageBytes = multipartFile.getBytes();//获取上传二进制字节流

            //获取文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String extName =originalFilename.substring(i);

            upload_file = storageClient.upload_file(imageBytes,extName,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imageUrl = "";
        imageUrl+=BASE_URL;
        for (int i = 0; i < upload_file.length; i++) {
            imageUrl = imageUrl+"/"+upload_file[i];
        }
        logger.info("url =="+imageUrl);
        return imageUrl;
    }

}
