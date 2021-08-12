package chung.manager.controller.hr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addEmployeeController {

    @RequestMapping("/addEmployee")
    public String addEmployeeSkip(){

        return "/hr/addEmployee";
    }
}
