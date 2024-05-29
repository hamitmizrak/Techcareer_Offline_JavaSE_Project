package com.hamitmizrak.files;

import lombok.Data;

import java.io.File;
import java.util.Date;
import java.util.List;

// LOMBOK
@Data
public class FilePathDataImplements implements IFileLogTech{

    // Variable
    private String id;
    private String filePathName;
    private String fileDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;


    /////////////////////////////////////////////////////
    @Override
    public String logTechLocalDateTime() {
        return "";
    }

    @Override
    public String logTechFileInformation() {
        return "";
    }

    @Override
    public String logTechFileCreate(String fileName) {
        return "";
    }

    @Override
    public List<String> logTechFileList() {
        return List.of();
    }

    @Override
    public String logTechFileWriter(String fileName) {
        return "";
    }

    @Override
    public String logTechFileReader(String fileName) {
        return "";
    }

    @Override
    public String logTechFileDelete(String fileName) {
        return "";
    }
}
