package com.hachicore.demospringsecurityform.form;

import com.hachicore.demospringsecurityform.account.Account;
import com.hachicore.demospringsecurityform.account.AccountContext;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public void dashboard() {
        Account account = AccountContext.getAccount();
        System.out.println("===============");
        System.out.println(account.getUsername());
    }
}
