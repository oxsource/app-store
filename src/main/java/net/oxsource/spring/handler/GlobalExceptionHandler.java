package net.oxsource.spring.handler;

import com.alibaba.fastjson.JSON;
import net.oxsource.spring.service.validator.HttpCodes;
import net.oxsource.spring.service.validator.HttpException;
import net.oxsource.spring.service.validator.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String onCatchException(Exception e) {
        HttpResult result = new HttpResult();
        if (e instanceof HttpException) {
            HttpException ext = (HttpException) e;
            result.setCode(ext.getCode());
            result.setMsg(ext.getMsg());
        } else {
            result.setCode(HttpCodes.FAILURE);
            result.setMsg(e.getMessage());
        }
        return JSON.toJSONString(result);
    }
}