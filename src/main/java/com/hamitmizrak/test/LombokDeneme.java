package com.hamitmizrak.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LombokDeneme {

    private String data;

    /*
    public LombokDeneme() {
    }

    public LombokDeneme(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    */

    public static void main(String[] args) {
        LombokDeneme deneme = new LombokDeneme();
        deneme.setData("data 44");
        System.out.println(deneme.getData());
    }
}
