package com.yuanmeng.starrysky.config;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yuanmeng.starrysky.entity.User;
import com.yuanmeng.starrysky.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    //@Autowired
    //private LoginService loginService;
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        User user = (User) getAvailablePrincipal(principals);
        if (user.getType() == 1){
            Set<String> roles = new HashSet<String>();
            Set<String> permissions = new HashSet<String>();
            roles.add("admin");
            permissions.add("admin:all");
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.setRoles(roles);
            info.setStringPermissions(permissions);
            return info;
        }
        return null;

        //获取登录用户名
        /*
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user = loginService.getUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permissions permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
        }
        return simpleAuthorizationInfo;

         */
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());

        //获取用户信息
        //User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getNickname, username),false);

        String pwd = "123";
        if (username == null) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(pwd)) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(username, pwd, getName());
    }
}

/**

public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     *
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            System.out.println("-------身份认证方法--------");
            String userName = (String) authenticationToken.getPrincipal();
            String userPwd = new String((char[]) authenticationToken.getCredentials());
            //根据用户名从数据库获取密码
            String password = "123";
            if (userName == null) {
                throw new AccountException("用户名不正确");
            } else if (!userPwd.equals(password )) {
                throw new AccountException("密码不正确");
            }
            return new SimpleAuthenticationInfo(userName, password,getName());
    }
}
**/