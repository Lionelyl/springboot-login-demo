package lionel.springbootlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ContextController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/context")
    public String context(){
        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        String s = "";
        for (String bean : beans)
        {
            if(applicationContext.getBean(bean).getClass().toString().contains("logindemo")) {
                s += bean + " of Type :: " + applicationContext.getBean(bean).getClass();
                s += "<br />";
            }
        }
        return s;
    }

}
