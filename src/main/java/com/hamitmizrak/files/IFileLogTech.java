package com.hamitmizrak.files;

import java.util.List;

public interface IFileLogTech {

    //LocalDateTime
    public String logTechLocalDateTime();

    //logTechFileInformation
    public String logTechFileInformation();

    //logTechFileCreate
    public String logTechFileCreate(String fileName);

    //logTechFileList
    public List<String> logTechFileList();

    //logTechFileWriter
    public void logTechFileWriter(String username, String password);

    //logTechFileReader
    public void logTechFileReader();

    //logTechFileDelete
    public String logTechFileDelete(String fileName);
}
