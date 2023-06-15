package com.soulyun.aop;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class ControllerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    /**
     * 定义拦截规则：拦截com.soulyun.*.controller包下面的所有的类中，有@RequestMapper注解的方法
     */
    @Pointcut("execution(* com.soulyun..controller..*.*(..)) ")
    public void controllerMethodPointcut() {

    }

    @Around("controllerMethodPointcut()")
    public Object interceptor (ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Object result = null;
        StringBuilder params = new StringBuilder();
        for (Object arg : pjp.getArgs()) {
            if (!(arg instanceof InputStream) && !(arg instanceof OutputStream)) {
                params.append(JSON.toJSONString(arg));
            }
        }
        String fullMethodName = method.getDeclaringClass() + method.getName();
        logger.info("The request params for method {} is >>>>>>{}", fullMethodName, params);

        try {
            result = pjp.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("The result for method {} is >>>>>>{}", fullMethodName, JSON.toJSONString(result));
            logger.info("The cost for method {} is >>>>>{}ms", fullMethodName, (endTime - startTime));
        }

    }
}
