package chung.manager.controller.login;

import chung.manager.entities.EmployeeInfo;
import chung.manager.service.EmployeeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @RequestMapping({"/", "/login"})
    public String loginSkin(){
        return "login";
    }

    @RequestMapping(value = "/loginToken", method = RequestMethod.POST)
    public String login(EmployeeInfo employeeInfo, Model model, HttpSession session){
        if("".equals(employeeInfo.getUsername())){
            model.addAttribute("msg", "用户名不能为空");
            return "/login";
        }
        if("".equals(employeeInfo.getPassword())){
            model.addAttribute("msg", "密码不能为空");
            return "/login";
        }
        EmployeeInfo info = employeeInfoService.queryByUsername(employeeInfo.getUsername());
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(employeeInfo.getUsername(), employeeInfo.getPassword()));
            if(ObjectUtils.isEmpty(info) || !employeeInfo.getPassword().equals(info.getPassword())){
                model.addAttribute("msg", "用户名或密码不正确");
                return "/login";
            }
        }catch (UnknownAccountException e){
            log.info("用户名不存在");
            model.addAttribute("msg", "用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            log.info("密码错误");
            model.addAttribute("msg", "密码错误");
            return "/login";
        }
        if(!StringUtils.isEmpty(employeeInfo.getRemember())){
            session.setAttribute("username", employeeInfo.getUsername());
            session.setAttribute("password", employeeInfo.getPassword());
            session.setAttribute("remember", 9984);
        }else{
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.removeAttribute("remember");
        }

        return "redirect:/index";
    }
}
