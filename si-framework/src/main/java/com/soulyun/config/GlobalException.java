package com.soulyun.config;

import com.soulyun.common.ResponseInfo;
import com.soulyun.common.ResponseServiceEnum;
import com.soulyun.common.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 定义全局异常处理类
 * @author fan
 * @date 2023/6/15 13:31
 */
@RestControllerAdvice(basePackages = {"com.soulyun"})
public class GlobalException {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    /**
     * 捕获自定义异常
     * @author fan
     * @date 2023/6/15 13:32
     * @param e 异常信息
     * @return com.soulyun.common.ResponseInfo
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseInfo<Void> serviceException(ServiceException e) {
        log.error(e.getMessage());
        return ResponseInfo.failed(ResponseServiceEnum.SI_FAILED.getCode(), e.getMessage());
    }

    /**
     * 捕获未知异常
     * @author fan
     * @date 2023/6/15 13:48
     * @param e 异常信息
     * @return com.soulyun.common.ResponseInfo<java.lang.Void>
     */
    @ExceptionHandler(Exception.class)
    public ResponseInfo<Void> exception (Exception e) {
        log.error(e.getMessage());
        return ResponseInfo.failed(ResponseServiceEnum.SI_FAILED.getCode(), e.getMessage());
    }
}
