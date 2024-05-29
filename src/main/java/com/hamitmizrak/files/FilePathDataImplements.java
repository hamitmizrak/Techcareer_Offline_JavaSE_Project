package com.hamitmizrak.files;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

// LOMBOK
@Data
//@Getter
//@Setter
@ToString
public class FilePathDataImplements implements IFileLogTech{

    // Variable
    private String id;
    private String filePathName;
    private String fileDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;

    // Constructor(Parametresiz)
    public FilePathDataImplements() {
        this.id = UUID.randomUUID().toString();
        this.systemCreatedDate=new Date(System.currentTimeMillis());
        this.filePathName="\\car.txt";
        this.fileDirectoryName=FilePathUrl.MY_CAR_FILE_PATH_URL;
        this.url=fileDirectoryName.concat(filePathName);
        this.file=new File(url);
        // İlgili dosya yoksa oluştur varsa birşey yapma
        try {
            if(file.exists()){
                System.out.println(url+" Böyle bir dosya zaten var oluşturulmadı !!!!");
            }else{
                file.createNewFile();
                System.out.println(url+" Başarılı dosya oluşturuldu.");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////
    // METOT

    // DATE
    @Override
    public String logTechLocalDateTime() {
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz", locale);
        Date date=new Date();
        String changeDate=sdf.format(date);
        return changeDate;
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
// WRITER
    @Override
    public void logTechFileWriter(String username, String password) {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(this.url,true))) {
            String nowDate=logTechLocalDateTime();
            String value="["+nowDate+"] "+ username+" "+password;
            bw.write(value+"\n");
            System.out.println("Eklendi");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //READER
    @Override
    public void logTechFileReader() {
        String rows;// okunan satır
        StringBuilder builder=new StringBuilder();
        String builderToString;
        try(BufferedReader br=new BufferedReader(new FileReader(this.url))) {
            while ((rows=br.readLine())!=null) {
                builder.append(rows).append("\n");
            }
            builderToString=builder.toString();
            System.out.println("LOGLAMA:\n"+builderToString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String logTechFileDelete(String fileName) {
        return "";
    }

    // TEST
    public static void main(String[] args) {
        FilePathDataImplements filePathDataImplements=new FilePathDataImplements();
        filePathDataImplements.logTechFileWriter("root","passwd");
        filePathDataImplements.logTechFileReader();
    }
}
