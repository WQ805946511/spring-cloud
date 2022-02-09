package com.example.service01.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 发送请求的切面入口类,需要在Spring中注入
 *
 * @author sunt
 * @version V1.0
 * @ClassName: RequestAsprct
 * @date 2017年11月10日
 */
@Component
@Aspect
@Slf4j
public class RequestAsprct {

    @Pointcut("execution(public * com.example.service01.controller.*.*(..))")
    // 切入点说明:包下的任意类，任意方法，任意参数，任意返回值的方法都进行切入
    public void sysLog() {

    }

    @Before("sysLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 得到请求的资源
        String requestUri = request.getRequestURI();
        // 得到来访者的IP地址
        String remoteAddr = request.getRemoteAddr();
        // 得到请求URL地址时使用的方法
        String method = request.getMethod();
        //客户端主机名
        String remoteHost = request.getRemoteHost();
        String className = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        log.info("+++++++从切入点开始处切入内容...");
        log.info("requestUri=" + requestUri + ",remoteAddr=" + remoteAddr
                + ",method=" + method + ",remoteHost=" + remoteHost + ",className=" + className);

    }

    @After("sysLog()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("------------->在切入点结尾处(方法执行后)切入内容...");
    }


    @AfterReturning(returning = "result", pointcut = "sysLog()")
    public void doAfterReturning(Object result) {
        log.info("在切入点return内容之后切入内容:" + result);
    }

}