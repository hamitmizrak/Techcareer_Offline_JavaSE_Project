package com.hamitmizrak.dao;

import com.hamitmizrak.dto.RegisterDto;
import com.hamitmizrak.files.FilePathDataImplements;

public class RegisterDao implements IDaoGenerics<RegisterDto> {


    // Injection
    public FilePathDataImplements filePathDataImplements = new FilePathDataImplements();

    @Override
    public void information() {
        filePathDataImplements.logTechFileInformation();
    }

    @Override
    public void fileList() {
        filePathDataImplements.logTechFileList();
    }

    @Override
    public void fileCreate(String url) {
        filePathDataImplements.logTechFileCreate(url);
    }

    @Override
    public void fileWrite(String username, String password) {
        filePathDataImplements.logTechFileWriter(username, password);
    }

    @Override
    public void fileRead() {
        filePathDataImplements.logTechFileReader();
    }

    @Override
    public void fileDelete() {
        filePathDataImplements.logTechFileDelete();
    }
} //end RegisterDao
