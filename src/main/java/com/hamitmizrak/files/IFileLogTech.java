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
    public String logTechFileWriter(String fileName);

    //logTechFileReader
    public String logTechFileReader(String fileName);

    //logTechFileDelete
    public String logTechFileDelete(String fileName);
}
