package com.hamitmizrak.controller;

import com.hamitmizrak.dao.RegisterDao;
import java.util.Scanner;

public class RegisterController {


    private RegisterDao registerDao = new RegisterDao();

    // LOGIN
    public void login(){
        for(;;){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\nEmail giriniz");
        String email=scanner.nextLine();
        System.out.println("Şifre giriniz");
        String password=scanner.nextLine();

        String defaultEmailAddress="hamitmizrak@gmail.com";
        String defaultPassword="123456";
        if(email.equals(defaultEmailAddress)&&password.equals(defaultPassword)){
            while(true){
                allProcess();
            }
        }else{
            System.out.println("Şifreniz Yanlıştır");
        }
        }
    }


    private void allProcess(){
        System.out.println("\nLütfen seçim yapınız\n1-)Dosya Bilgileri\n2-)Dosyaları  Listele\n3-)Dosya Oluştur \n4-)Dosya Yaz\n5-)Dosya Oku");
        System.out.println("6-)Dosya Sil\n7-)Çıkış");

        Scanner scanner = new Scanner(System.in);
        int chooise=scanner.nextInt();
        switch (chooise){
            case 1:
                registerDao.information();
                break;
            case 2:
                registerDao.fileList();
                break;
            case 3:
                //registerDao.fileCreate("C:\\io\\techcareer\\deneme.log");
                System.out.println("Dosya oluşturmak için dosya adını giriniz");
                Scanner scannerCreate=new Scanner(System.in);
                String fileName=scannerCreate.nextLine().concat(".txt");
                String fileDirectoryName ="C:\\io\\techcareer";
                String url=fileDirectoryName.concat("\\").concat(fileName);
                System.out.println("Dosya uzantısı: "+url);
                registerDao.fileCreate(url);
                break;
            case 4:
                Scanner scanner1=new Scanner(System.in);
                System.out.println("Username yazınız");
                String username=scanner1.nextLine();
                System.out.println("Şifre yazınız");
                String password=scanner1.nextLine();
                registerDao.fileWrite(username,password);
                break;
            case 5:
                registerDao.fileRead();
                break;
            case 6:
               registerDao.fileDelete();
                break;
            case 7:
                System.out.println("Çıkış yapılıyor");
                break;
        } //end while
    } //end allProcess

}
