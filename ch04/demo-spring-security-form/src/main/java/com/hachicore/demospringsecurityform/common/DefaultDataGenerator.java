package com.hachicore.demospringsecurityform.common;

import com.hachicore.demospringsecurityform.account.Account;
import com.hachicore.demospringsecurityform.account.AccountService;
import com.hachicore.demospringsecurityform.book.Book;
import com.hachicore.demospringsecurityform.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultDataGenerator implements ApplicationRunner {

    private final AccountService accountService;
    private final BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account hahcicore = createUser("hachicore");
        Account rokuthread = createUser("rokuthread");

        createBook("spring", hahcicore);
        createBook("hibernate", rokuthread);
    }

    private void createBook(String title, Account hahcicore) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(hahcicore);
        bookRepository.save(book);
    }

    private Account createUser(String username) {
        Account account = new Account(username, "123", "USER");
        return accountService.createNew(account);
    }
}
