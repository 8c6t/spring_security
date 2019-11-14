package com.hachicore.demospringsecurityform.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountDataBaseInitRunner implements ApplicationRunner {

    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountService.createNew(new Account("admin", "123", "ADMIN"));
        accountService.createNew(new Account("hachicore", "123", "USER"));
    }

}
