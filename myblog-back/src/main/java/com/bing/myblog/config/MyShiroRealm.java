package com.bing.myblog.config;


import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.servics.CommentService;
import com.bing.myblog.servics.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo  = (UserInfo)session.getAttribute("UserInfo");
        String permissions = userInfo.getPermissions();
        String[] permissionsArray = permissions.split(";");
        for (String permission:permissionsArray) {
            authorizationInfo.addStringPermission(permission);
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = loginService.getByUserName(username);

        //System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null || !userInfo.getUserPassword().equals(new Md5Hash(password,password+userInfo.getSalt()).toHex())){
        //if(userInfo == null || !userInfo.getUserPassword().equals(password)){
            System.out.println("throw new UnknownAccountException();");
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUserName(), //用户名
                password, //密码
                getName()  //realm name
        );
        userInfo.setUserPassword(null);
        SecurityUtils.getSubject().getSession().setAttribute("UserInfo", userInfo);
        return authenticationInfo;
    }

}