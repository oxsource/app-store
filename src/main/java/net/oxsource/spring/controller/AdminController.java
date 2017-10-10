package net.oxsource.spring.controller;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.database.model.user.UserAdmin;
import net.oxsource.spring.database.model.user.UserDevelop;
import net.oxsource.spring.database.repository.user.UserAdminRepos;
import net.oxsource.spring.service.model.ReqLogin;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpException;
import net.oxsource.spring.service.validator.HttpResult;
import net.oxsource.spring.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员Controller
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserAdminRepos userRepos;

    @PostMapping(value = "/login")
    String login(@RequestBody ReqLogin login) throws Exception {
        HttpException.verify(null == login, "缺少验证信息");
        HttpException.verify(TextUtils.isEmpty(login.getAccount()), "账号不能为空");
        HttpException.verify(TextUtils.isEmpty(login.getPassword()), "密码不能为空");

        List<UserAdmin> users = userRepos.findAllByAccountEqualsAndIdentifyEquals(login.getAccount(), login.getPassword());
        HttpException.verify(null == users || users.size() < 1, "用户不存在");
        HttpException.verify(users.size() != 1, "账号冲突");

        UserAdmin user = users.get(0);
        HttpException.verify(UserAdmin.STATUS_ENABLE != user.getStatus(), "用户被禁用，请联系管理员");
        return successResult(user, "登录成功");
    }
}