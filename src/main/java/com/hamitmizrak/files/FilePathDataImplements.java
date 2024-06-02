package com.hamitmizrak.files;

import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

// LOMBOK
@Data
//@Getter
//@Setter
@ToString
public class FilePathDataImplements implements IFileLogTech {

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
        this.systemCreatedDate = new Date(System.currentTimeMillis());
        this.filePathName = "\\car.txt";
        this.fileDirectoryName = FilePathUrl.MY_CAR_FILE_PATH_URL;
        this.url = fileDirectoryName.concat(filePathName);
        this.file = new File(url);
        // İlgili dosya yoksa oluştur varsa birşey yapma
        try {
            if (file.exists()) {
                System.err.println(url + " Böyle bir dosya zaten var oluşturulmadı !!!!");
            } else {
                file.createNewFile();
                System.out.println(url + " Başarılı dosya oluşturuldu.");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////
    // METOT

    // DATE
    @Override
    public String logTechLocalDateTime() {
        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz", locale);
        Date date = new Date();
        String changeDate = sdf.format(date);
        return changeDate;
    }

    @Override
    public void logTechFileInformation() {
        Scanner scannerFileInformation=new Scanner(System.in);
        logTechFileList();
        System.out.println("Lütfen bilgisini almak istediğiniz dosya adını yazınız");
        String fileNameInformation=scannerFileInformation.nextLine().concat(".txt");
        String url=fileDirectoryName.concat("\\").concat(fileNameInformation);
        System.out.println("Dosya uzantısı: "+url);
        File file = new File(url);
        System.out.println("Çalışabilinir mi ? "+file.canExecute());
        System.out.println("Okunabilinir  mi ? "+file.canRead());
        System.out.println("Yazılabilinir mi ? "+file.canWrite());
        System.out.println("Dosya  mı? "+file.isFile());
        System.out.println("Dizin mi? "+file.isDirectory());
        System.out.println("parent"+file.getParent());
        System.out.println("gizli mi mi ? "+file.isHidden());
        System.out.println("Free HDD mi ? "+file.getFreeSpace());
        System.out.println("getTotalSpace mi ? "+file.getTotalSpace());
        System.out.println("lastModified mi ? "+ new Date(file.lastModified())  );

    }

    // CREATE
    @Override
    public void logTechFileCreate(String url) {
        this.file = new File(url);
        // İlgili dosya yoksa oluştur varsa birşey yapma
        try {
            if (file.exists()) {
                System.err.println(url + " Böyle bir dosya zaten var oluşturulmadı !!!!");
            } else {
                file.createNewFile();
                System.out.println(url + " Başarılı dosya oluşturuldu.");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // LIST
    @Override
    public File[] logTechFileList() {
        File fileList = new File(FilePathUrl.MY_CAR_FILE_PATH_URL);
        for (File temp : fileList.listFiles()) {
            System.out.println(temp.getName());
        }
        return fileList.listFiles();
    }

    // WRITER
    @Override
    public void logTechFileWriter(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.url, true))) {
            String nowDate = logTechLocalDateTime();
            String value = "[" + nowDate + "] " + username + " " + password;
            bw.write(value + "\n");
            System.out.println("Eklendi");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //READER
    @Override
    public void logTechFileReader() {

        Scanner scanner=new Scanner(System.in);
        logTechFileList();
        System.out.println("Lütfen okumak istediğiniz dosya adını yazınız");
        String fileName=scanner.nextLine().concat(".txt");
        String url=fileDirectoryName.concat("\\").concat(fileName);
        System.out.println("Dosya uzantısı: "+url);


        String rows;// okunan satır
        StringBuilder builder = new StringBuilder();
        String builderToString;
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            while ((rows = br.readLine()) != null) {
                builder.append(rows).append("\n");
            }
            builderToString = builder.toString();
            System.out.println("LOGLAMA:\n" + builderToString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    @Override
    public void logTechFileDelete() {
        Scanner scanner=new Scanner(System.in);
        logTechFileList();
        System.out.println("Lütfen silmek istediğiniz dosya adını yazınız");
        String fileName=scanner.nextLine().concat(".txt");
        String url=fileDirectoryName.concat("\\").concat(fileName);
        System.out.println("Dosya uzantısı: "+url);

        char chooise;
        System.out.println(fileName+" bu dosyayı gerçekten silmek istir musunuz ? E/H");
        chooise=scanner.nextLine().charAt(0);
        if(chooise=='e' || chooise=='E'){
            try {
                File fileDelete=new File(url);
                // Böyle bir dosya var mı yok mu
                if(fileDelete.exists()){
                    fileDelete.delete();
                    System.out.println(fileName+" dosyanız silindi");
                }else{
                    System.out.println(fileName+" Olmayan dosya silinemez");
                }
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }else{
            System.out.println(fileName+" Dosya silinemedi");
        }
    }

    // TEST
    public static void main(String[] args) {
        FilePathDataImplements filePathDataImplements = new FilePathDataImplements();
        //filePathDataImplements.logTechFileWriter("root","passwd");
        //filePathDataImplements.logTechFileReader();
        //filePathDataImplements.logTechFileList();
        //filePathDataImplements.logTechFileCreate("C:\\io\\techcareer\\deneme.log");
        //filePathDataImplements.logTechFileDelete();
        //filePathDataImplements.logTechFileInformation();
    }
}
