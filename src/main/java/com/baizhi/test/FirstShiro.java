package com.baizhi.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class FirstShiro {
    public static void main(String[] args) {

        //第一步 获取安全管理器的工厂
        IniSecurityManagerFactory iniSecurityManagerFactory=new IniSecurityManagerFactory("classpath:shiro.ini");

        //获取安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //获取主体对象
        Subject subject=SecurityUtils.getSubject();

        //token就是用户的令牌 包含用户的身份信息和凭证信息
        AuthenticationToken token=new UsernamePasswordToken("zhangsan","123456");

        try {
            subject.login(token);
            System.out.println("验证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("验证失败");
        }

        boolean b=subject.isAuthenticated();

        System.out.println(b);
    }
}
