package com.pjx.demo2018.aop;

/**
 * Created by juqi on 19/6/24.
 */
public class SessionContextHolder {
    private static final ThreadLocal<SessionContext> contextHolder = new ThreadLocal();

    public SessionContextHolder() {
    }

    public static SessionContext getContext() {
        SessionContext ctx = (SessionContext)contextHolder.get();
        if(ctx == null) {
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }

        return ctx;
    }

    public static void setContext(SessionContext context) {
        contextHolder.set(context);
    }

    public static void clearContext() {
        contextHolder.remove();
    }

    public static SessionContext createEmptyContext() {
        return new SessionContext();
    }
}
