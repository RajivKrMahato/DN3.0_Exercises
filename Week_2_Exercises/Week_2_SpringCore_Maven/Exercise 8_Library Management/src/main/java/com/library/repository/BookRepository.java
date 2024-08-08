package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void performRepositoryOperation() {
        System.out.println("Performing repository operation in BookRepository");
    }
}
