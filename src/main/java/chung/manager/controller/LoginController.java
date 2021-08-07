package chung.manager.controller;

import chung.manager.entities.EmployeeInfo;
import chung.manager.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @RequestMapping("/")
    public String loginSkin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(EmployeeInfo employeeInfo, Model model){
        if("".equals(employeeInfo.getUsername())){
            model.addAttribute("msg", "用户名不能为空");
            return null;
        }
        if("".equals(employeeInfo.getPassword())){
            model.addAttribute("msg", "密码不能为空");
            return null;
        }
        EmployeeInfo info = employeeInfoService.queryByUsername(employeeInfo.getUsername());
        if(ObjectUtils.isEmpty(info) || !employeeInfo.getPassword().equals(info.getPassword())){
            model.addAttribute("msg", "用户名或密码不正确");
            return null;
        }
        return "redirect:/index";
    }
}
