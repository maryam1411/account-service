package com.example.account.controller;

import com.example.account.exception.DuplicateUserName;
import com.example.account.handler.AccountHandler;
import com.example.account.model.AccountModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@Api(value = "Account Registration Controller")
public class AccountController {

    private final AccountHandler accountHandler;

    @Autowired
    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @PostMapping
    @ApiOperation(value = "Create account", response = Iterable.class)
    public ResponseEntity<String> save(@Valid @RequestBody AccountModel accountModel) throws JSONException {
        try {
            accountHandler.save(accountModel);
            return new ResponseEntity<>("Account Created", HttpStatus.OK);
        } catch (DuplicateUserName e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update account information", response = Iterable.class)
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody AccountModel accountModel) {
        try {
            accountHandler.updateAccountRegistration(id, accountModel);
            return new ResponseEntity<>("Account Updated Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userName}")
    @ApiOperation(value = "Get created account", response = Iterable.class)
    public AccountModel getRegisteredAccount(@PathVariable String userName) {
        return accountHandler.getRegisteredAccount(userName);

    }
}
