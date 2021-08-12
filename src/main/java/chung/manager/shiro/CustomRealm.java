package chung.manager.shiro;

import chung.manager.config.ApplicationContextUtil;
import chung.manager.config.ByteSourceConfig;
import chung.manager.entities.EmployeeInfo;
import chung.manager.service.EmployeeInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();
        EmployeeInfoService employeeInfoService = (EmployeeInfoService)ApplicationContextUtil.getBean("employeeInfoServiceImpl");
        EmployeeInfo info = employeeInfoService.queryByUsername(principal);

        if(!ObjectUtils.isEmpty(info)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(info.getUsername(), info.getPassword(), ByteSourceConfig.Util.bytes(info.getId().toString()), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
