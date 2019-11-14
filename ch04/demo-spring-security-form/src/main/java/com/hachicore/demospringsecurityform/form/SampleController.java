package com.hachicore.demospringsecurityform.form;

import com.hachicore.demospringsecurityform.account.Account;
import com.hachicore.demospringsecurityform.account.AccountRepository;
import com.hachicore.demospringsecurityform.common.CurrentUser;
import com.hachicore.demospringsecurityform.common.SecurityLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model, @CurrentUser Account account) {
        if (account == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello, " + account.getUsername());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @CurrentUser Account account) {
        model.addAttribute("message", "Hello " + account.getUsername());
        sampleService.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, @CurrentUser Account account) {
        model.addAttribute("message", "Hello Admin, " + account.getUsername());
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model, @CurrentUser Account account) {
        model.addAttribute("message", "Hello, User, " + account.getUsername());
        return "user";
    }

    @GetMapping("/async-handler")
    @ResponseBody
    public Callable<String> asyncHandler() {
        SecurityLogger.log("MVC");
        return () -> {
            SecurityLogger.log("Callable");
            return "Async Handler";
        };
    }

    @GetMapping("/async-service")
    @ResponseBody
    public String asyncService() {
        SecurityLogger.log("MVC, before async service");
        sampleService.asyncService();
        SecurityLogger.log("MVC, after async service");
        return "Async Service";
    }

}
