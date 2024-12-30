package com.xproce.controller;

import com.xproce.config.BankUserDetails;
import com.xproce.dao.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final BankUserDetails bankUserDetails;
    @GetMapping("/myAccount")
    public String getAccountDetails(@RequestParam String customer) {
        System.out.println(bankUserDetails.loadUserByUsername(customer));
        System.out.println(customer);
        return "Here are the account details from the DB";
    }

}
