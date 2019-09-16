package com.pjx.demo2018.aop;

import com.pjx.demo2018.aop.handler.UserHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juqi on 19/6/15.
 */
@Aspect
@Component
public class SessionTestValidator {

    private Logger logger = LoggerFactory.getLogger(SessionTestValidator.class);
    public static List<ProceedingJoinPoint> list = new ArrayList<>();

    @Around(value = "@annotation(SessionValidator)")
    public void validateSession(ProceedingJoinPoint proceedingJoinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String sessionId = request.getHeader("sessionId");

        logger.info("aaaaa thread - {}, sessionId- {}, proceedingJoinPoint.hashcode={}", Thread.currentThread().getName(), sessionId, proceedingJoinPoint.hashCode());

        list.add(proceedingJoinPoint);
        logger.info("aaaa size={}, contains={}, same={}", list.size(), list.contains(proceedingJoinPoint), proceedingJoinPoint == list.get(list.size()-1));
        System.out.println("");
        UserHandler userHandler = new UserHandler();
        userHandler.set(UserHandler.PJP, proceedingJoinPoint);
        userHandler.set(UserHandler.SESSION_ID, sessionId);
//        userHandler.validate();

        SessionContextHolder.getContext().setId(sessionId+"A");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
