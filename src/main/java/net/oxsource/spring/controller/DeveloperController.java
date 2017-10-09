package net.oxsource.spring.controller;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.service.model.ReqArtifact;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpResult;
import net.oxsource.spring.utils.IoUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 开发者Controller
 */
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    /**
     * 开发者登录
     *
     * @return
     */
    @PostMapping(value = "/login")
    String login() {
        return "This is developer index";
    }

    /**
     * 开发者上传归档应用
     *
     * @return
     */
    @PostMapping(value = "/upload")
    String upload(MultipartFile mf, @RequestBody ReqArtifact artifact) throws Exception {
        //todo add code here
        InputStream ins = null;
        FileOutputStream fos = null;
        try {
            ins = mf.getInputStream();
            File root = new File("/Users/Peng/Desktop/upload");
            String fileName = mf.getOriginalFilename();
            fos = new FileOutputStream(new File(root, fileName));
            int len = -1;
            byte[] buffer = new byte[2 * 1024];
            while (-1 != (len = ins.read(buffer))) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtils.quietClose(ins);
            IoUtils.quietClose(fos);
        }

        HttpResult result = new HttpResult();
        result.setCode(HttpCodes.SUCCESS);
        result.setMsg("文件上传成功");
        return JSON.toJSONString(result);
    }
}