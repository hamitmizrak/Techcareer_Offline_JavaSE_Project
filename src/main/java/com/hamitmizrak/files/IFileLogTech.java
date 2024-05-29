package com.hamitmizrak.files;

import java.io.File;

public interface IFileLogTech {

    //LocalDateTime
    public String logTechLocalDateTime();

    //logTechFileInformation
    public void logTechFileInformation();

    //logTechFileCreate
    public void logTechFileCreate(String fileName);

    //logTechFileList
    public File[] logTechFileList();

    //logTechFileWriter
    public void logTechFileWriter(String username, String password);

    //logTechFileReader
    public void logTechFileReader();

    //logTechFileDelete
    public void logTechFileDelete();
}
