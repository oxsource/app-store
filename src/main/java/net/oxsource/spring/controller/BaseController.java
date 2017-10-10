package net.oxsource.spring.controller;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpException;
import net.oxsource.spring.service.validator.HttpResult;
import net.oxsource.spring.utils.TextUtils;

/**
 * 基础Controller
 */
abstract class BaseController {

    public String successResult(Object obj, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(HttpCodes.SUCCESS);
        result.setMsg(msg);
        if (null != obj) {
            result.setData(TextUtils.json(obj));
        }
        return TextUtils.json(result);
    }

    public String successResult(String msg) {
        return successResult(null, msg);
    }
}
