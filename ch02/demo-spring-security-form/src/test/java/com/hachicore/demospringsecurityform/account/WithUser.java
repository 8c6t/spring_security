package com.hachicore.demospringsecurityform.account;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "hachicore", roles = "USER")
public @interface WithUser {

}
