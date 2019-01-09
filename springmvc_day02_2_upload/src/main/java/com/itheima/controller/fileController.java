package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class fileController {
    @RequestMapping("/fileUpload")
    public void testFileUpload(MultipartFile uploadFile, String pickName, HttpServletRequest request) {
        //获取文件真是名称
        String originalFilename = uploadFile.getOriginalFilename();
        //扩展名
        String fileExtendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //随机名称
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        String serviceFileName=uuidName+fileExtendName;

        String realPath = request.getSession().getServletContext().getRealPath("upload");

        File file = new File(realPath);

        if (!file.exists()) {
            file.mkdirs();
        }

        try {
            uploadFile.transferTo(new File(file,serviceFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/fileUpload1")
    public void testFileUpload1(MultipartFile uploadFile, String pickName, HttpServletRequest request) {
        //获取文件真是名称
        String originalFilename = uploadFile.getOriginalFilename();
        //扩展名
        String fileExtendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //随机名称
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        String serviceFileName=uuidName+fileExtendName;

        String realPath = request.getSession().getServletContext().getRealPath("upload");

        File file = new File(realPath);

        if (!file.exists()) {
            file.mkdirs();
        }

        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8888/imgservice/upload" + serviceFileName);
        try {
            resource.put(String.class,uploadFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
