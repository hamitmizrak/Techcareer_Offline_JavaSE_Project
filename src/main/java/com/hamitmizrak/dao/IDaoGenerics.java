package com.hamitmizrak.dao;

import java.util.ArrayList;

// DAO GENERICS
public interface IDaoGenerics <T> {

    // CRUD
    // CREATE
    public void information();
    public void fileList();
    public void fileCreate(String url);
    public void fileWrite(String username, String password);
    public void fileRead();
    public void fileDelete();

} //end interface IDaoGenerics
