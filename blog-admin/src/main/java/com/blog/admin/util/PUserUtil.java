package com.blog.admin.util;

import javax.servlet.http.HttpSession;

import com.blog.user.core.entity.PUser;

public class PUserUtil {

    //SessionKey
    public static final String PUSER_SESSION_KEY = "BLOG_PUSER_SESSION_KEY";

    /**
     * 检测是否登录
     * @param httpSession
     * @return
     */
    public static boolean isLogin(HttpSession httpSession) {
        PUser PUser = getPUser(httpSession);
        if (null == PUser) {
            return false;
        }
        return true;
    }

    /**
     * 从Session中获取用户
     *
     * @param httpSession
     * @return
     */
     public static PUser getPUser(HttpSession httpSession) {
         return (PUser) httpSession.getAttribute(PUSER_SESSION_KEY);
    }

    /**
     * 登录后设置PUser至session中.
     *
     * @param u
     * @param httpSession
     */
    public static void setPUser(PUser u, HttpSession httpSession) {
        httpSession.setAttribute(PUSER_SESSION_KEY, u);
    }

    /**
     * 用户登出.
     * @param httpSession
     */
    public static void removePUser(HttpSession httpSession) {
        httpSession.removeAttribute(PUSER_SESSION_KEY);
        httpSession.invalidate();
    }

}