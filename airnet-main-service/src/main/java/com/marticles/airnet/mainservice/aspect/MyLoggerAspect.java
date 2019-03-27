package com.marticles.airnet.mainservice.aspect;

import com.marticles.airnet.mainservice.dao.LogDAO;
import com.marticles.airnet.mainservice.model.Log;
import com.marticles.airnet.mainservice.model.UserLocal;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * AOP+反射实现日志打印
 *
 * @author Marticles
 * @description MyLoggerAspect
 * @date 2019/3/26
 */
@Aspect
@Component
@Slf4j
@EnableAspectJAutoProxy
public class MyLoggerAspect {

    @Autowired
    private UserLocal userLocal;

    @Autowired
    private LogDAO logDAO;

    // 切点
    @Pointcut("@annotation(com.marticles.airnet.mainservice.annotation.MyLogger)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void around(JoinPoint point) {
        Log myLog = new Log();
        Signature signature = point.getSignature();
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = point.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i]).append(":").append(args[i]).append("; ");
        }
//        log.info("****************MyLogger Start****************");
//        log.info("Class name:{}", className);
//        log.info("Method name:{}", methodName);
//        log.info("Method return type:{}", methodSignature.getReturnType());
//        log.info("****************MyLogger End****************\n");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        myLog.setRequestTime(new Date());
        myLog.setAuthHeaders(null!=request.getHeader("Authorization")?request.getHeader("Authorization"):"UnKnown");
        myLog.setRequestURL(request.getRequestURL().toString());
        myLog.setUserIP(request.getRemoteAddr());
        myLog.setUserId(null != userLocal.getUser() ? userLocal.getUser().getId().toString() : "UnKnown");
        myLog.setUserName(null != userLocal.getUser() ? userLocal.getUser().getName() : "UnKnown");
        myLog.setClassName(className);
        myLog.setMethodName(methodName);
        myLog.setReturnType(methodSignature.getReturnType().getName());
        myLog.setParameters(sb.toString());
        logDAO.addLog(myLog);
    }

}
