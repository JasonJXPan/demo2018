package com.pjx.demo2018.aop.handler;

import com.pjx.demo2018.aop.ReplaceAble;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by juqi on 19/6/15.
 */
public class UserHandler {

    private static Logger logger = LoggerFactory.getLogger(UserHandler.class);

    public static String SESSION_ID = "session_id";
    public static String PJP = "pjp";

    private Map<String, Object> entityParameters = new HashMap();

    public void set(String key, Object object) {
        entityParameters.put(key, object);
    }

    public void validate() {
        ProceedingJoinPoint joinPoint = (ProceedingJoinPoint)entityParameters.get(PJP);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[][] methodAnnotations = method.getParameterAnnotations();
        HashMap<Integer, ReplaceAble> index_anno = new HashMap<>();
        for (int i = 0; i < methodAnnotations.length; i++) {
            for (Annotation annotation : methodAnnotations[i]) {
                if (ReplaceAble.class.isInstance(annotation)) {
                    ReplaceAble sessionValueReplaceable = (ReplaceAble) annotation;
                    if (!index_anno.containsKey(i)) {
                        index_anno.put(i, sessionValueReplaceable);
                    }
                }
            }
        }
        String sessionValue = (String) entityParameters.get(SESSION_ID)+"AA";
        if (StringUtils.isEmpty(sessionValue)) {
            logger.error("null value");
            return ;
        }
        Object[] args = joinPoint.getArgs();
        for (Integer i : index_anno.keySet()) {
            Object arg = args[i];
            replaceWithSessionValue(sessionValue, arg, "任意");
        }
    }
    private void replaceWithSessionValue(String sessionValue, Object target, String sessionkey) {
        logger.debug("replaceWithSessionValue({},{},{})", sessionValue, target, sessionkey);
        if (String.class.isInstance(target)) {
            String strTarget = (String) target;
            if (target != null && !StringUtils.isEmpty(sessionValue)) {
                logger.info("will replace " + strTarget + " with session " + sessionkey + " value " + sessionValue);
                replaceValue(strTarget, sessionValue);
            } else {
                logger.info("session " + sessionkey + " value is " + sessionValue + " and target value is " + strTarget + ", will ignore replacement");
            }
        }
    }
    private void replaceValue(String target, String value) {
        Field field = ReflectionUtils.findField(String.class, "value");
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, target, value.toCharArray());
    }
}
