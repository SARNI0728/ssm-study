package com.sarni.spring03tx.service;

public interface UserService {

    void checkout(String username, Integer bookId, Integer bookNum);
}
