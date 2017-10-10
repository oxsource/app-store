package net.oxsource.spring.controller;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.database.model.app.AppProduction;
import net.oxsource.spring.database.model.user.UserAdmin;
import net.oxsource.spring.database.model.user.UserDevelop;
import net.oxsource.spring.database.repository.user.UserDevelopRepos;
import net.oxsource.spring.service.model.ReqDevelopRegister;
import net.oxsource.spring.service.model.ReqLogin;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpException;
import net.oxsource.spring.service.validator.HttpResult;
import net.oxsource.spring.utils.IoUtils;
import net.oxsource.spring.utils.RegExpUtils;
import net.oxsource.spring.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 开发者Controller
 */
@RestController
@RequestMapping("/develop")
public class DeveloperController extends BaseController {

    @Autowired
    private UserDevelopRepos userRepos;

    /**
     * 开发者注册
     *
     * @return
     */
    @PostMapping(value = "/register")
    String register(@RequestBody UserDevelop reg) throws HttpException {
        HttpException.verify(TextUtils.isEmpty(reg.getUserName()), "开发者名称不能为空");
        final String USER_KEY = TextUtils.md5(reg.getUserName());
        HttpException.verify(RegExpUtils.phone(reg.getPhone()));
        HttpException.verify(RegExpUtils.email(reg.getEmail()));
        HttpException.verify(RegExpUtils.password(reg.getIdentify()));
        //校验唯一性
        UserDevelop user = userRepos.findFirstByUserKeyEquals(USER_KEY);
        HttpException.verify(null != user, "用户名已注册");
        user = userRepos.findFirstByPhoneEquals(reg.getPhone());
        HttpException.verify(null != user, "手机号已注册");
        user = userRepos.findFirstByPhoneEquals(reg.getEmail());
        HttpException.verify(null != user, "邮箱已注册");

        //系统补全注册信息
        reg.setUserKey(USER_KEY);
        reg.setCreateTime(new Date());
        reg.setUpdateTime(new Date());
        UserDevelop result = userRepos.saveAndFlush(reg);
        HttpException.verify(null == result, "注册失败");
        return successResult("注册成功");
    }

    /**
     * 开发者登录
     *
     * @return
     */
    @PostMapping(value = "/login")
    String login(@RequestBody ReqLogin login) throws HttpException {
        HttpException.verify(null == login, "缺少验证信息");
        HttpException.verify(TextUtils.isEmpty(login.getAccount()), "账号不能为空");
        HttpException.verify(TextUtils.isEmpty(login.getPassword()), "密码不能为空");
        List<UserDevelop> users = userRepos.findAllByUserNameEqualsAndIdentifyEquals(login.getAccount(), login.getPassword());
        HttpException.verify(null == users || users.size() < 1, "用户不存在");
        HttpException.verify(users.size() != 1, "账号冲突");

        UserDevelop user = users.get(0);
        HttpException.verify(UserDevelop.STATUS_ENABLE != user.getStatus(), "用户被禁用，请联系管理员");
        return successResult(user, "登录成功");
    }

    /**
     * 修改个人信息(手机号,邮箱,邮箱,邮箱)
     */
    @PostMapping(value = "/person")
    String person(@RequestBody UserDevelop req) throws HttpException {
        final UserDevelop user = userRepos.findFirstByUserKeyEquals(req.getUserKey());
        HttpException.verify(null == user, "用户不存在");
        //手机号
        if (!TextUtils.isEmpty(req.getPhone())) {
            HttpException.verify(RegExpUtils.phone(req.getPhone()));
            UserDevelop ud = userRepos.findFirstByPhoneEquals(req.getPhone());
            HttpException.verify(null != ud && !ud.getUserKey().equals(user.getUserKey()), "该手机号已被使用");
            user.setPhone(req.getPhone());
        }
        //邮箱
        if (!TextUtils.isEmpty(req.getEmail())) {
            HttpException.verify(RegExpUtils.email(req.getEmail()));
            UserDevelop ud = userRepos.findFirstByEmailEquals(req.getEmail());
            HttpException.verify(null != ud && !ud.getUserKey().equals(user.getUserKey()), "该邮箱已被使用");
            user.setPhone(req.getEmail());
        }
        //邮箱
        if (!TextUtils.isEmpty(req.getWebSite())) {
            user.setWebSite(req.getWebSite());
        }
        //密码
        if (!TextUtils.isEmpty(req.getIdentify())) {
            HttpException.verify(RegExpUtils.password(req.getIdentify()));
            user.setIdentify(req.getIdentify());
        }
        user.setUpdateTime(new Date());
        UserDevelop result = userRepos.saveAndFlush(user);
        HttpException.verify(null == result, "修改个人信息失败");
        return successResult("修改成功");
    }

    /**
     * 获取个人信息
     */
    @GetMapping(value = "/person/{uKey}")
    String person(@PathVariable String uKey) throws HttpException {
        UserDevelop user = userRepos.findFirstByUserKeyEquals(uKey);
        HttpException.verify(null == user, "用户不存在");
        return successResult(user, "查询成功");
    }

    /**
     * 创建或修改应用
     */
    @PostMapping(value = "/product")
    String product(@RequestBody AppProduction production) {
    }

    /**
     * 上传应用
     *
     * @return
     */
    @PostMapping(value = "/upload")
    String upload(@RequestParam("uKey") String uKey, @RequestParam("aKey") String aKey, @RequestParam("file") MultipartFile mf) throws Exception {
        //todo add code here
        InputStream ins = null;
        FileOutputStream fos = null;
        try {
            ins = mf.getInputStream();
            File root = new File("/Users/Peng/Desktop/upload");
            String fileName = mf.getOriginalFilename();
            fos = new FileOutputStream(new File(root, fileName));
            int len;
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

        return successResult("文件上传成功");
    }
}