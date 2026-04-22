package com.sarni.springmvc.controller;

import com.sarni.springmvc.pojo.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
public class ResponseTestController {

    @RequestMapping("/resp01")
    public Person resp01(){
        Person person = new Person();
        person.setUsername("sarni");
        person.setPassword("<PASSWORD>");
        person.setCellphone("1234567890");
        person.setAgreement(true);
        return person;
    }

    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        // 1 指明要响应的文件 以及对文件流进行包装
        FileInputStream fis = new FileInputStream("/Users/sarni/Documents/哥伦比亚.png");
        InputStreamResource isr = new InputStreamResource(fis);

        // 2 指明文件名 以及使用UTF-8编码 解决中文乱码问题
        String encode = URLEncoder.encode("哥伦比亚.png", StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // 指明响应的媒体类型为文件流
                .contentLength(fis.available())
                .header("Content-Disposition", "attachment; filename=" + encode)
                .body(isr);
    }
}
