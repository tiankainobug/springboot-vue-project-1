/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hello.helloworld.demos.web;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
public class BasicController {

    // http://localhost:8080/hello?name=lisi&phone=123
    @GetMapping("/hello")
    public String hello(String name, String phone) {
        return "hello " + name + phone;
    }

    @GetMapping("/user")
    public String user(@RequestParam(value = "name", required = false) String nickName) {
        return "user" + nickName;
    }

    /**
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);

        saveFile(file, request);
        return "上传成功";
    }

    private void saveFile(MultipartFile file, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/upload");
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        try {
            file.transferTo(new File(file1 + "/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
