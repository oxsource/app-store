package net.oxsource.spring.controller;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.database.model.user.UserAdmin;
import net.oxsource.spring.database.repository.user.UserAdminRepos;
import net.oxsource.spring.service.model.ReqLogin;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpException;
import net.oxsource.spring.service.validator.HttpResult;
import net.oxsource.spring.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员Controller
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserAdminRepos repos;

    @PostMapping(value = "/login")
    String login(@RequestBody ReqLogin login) throws Exception {
        HttpException.verify(null == login, "缺少验证信息");
        HttpException.verify(TextUtils.isEmpty(login.getAccount()), "账号不能为空");
        HttpException.verify(TextUtils.isEmpty(login.getPassword()), "密码不能为空");

        UserAdmin user = repos.queryFirstByAccountEquals(login.getAccount());
        HttpException.verify(null == user, "用户不存在");
        HttpException.verify(UserAdmin.STATUS_ENABLE != user.getStatus(), "用户被禁用，请联系管理员");
        HttpException.verify(!user.getIdentify().equals(login.getPassword()), "用户名或密码错误");

        HttpResult result = new HttpResult();
        result.setCode(HttpCodes.SUCCESS);
        result.setMsg("登录成功");
        return JSON.toJSONString(result);
    }
}