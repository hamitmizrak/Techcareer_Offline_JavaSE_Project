package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deneme {

    private String data;

    public static void main(String[] args) {
        Deneme deneme = new Deneme();
        deneme.setData("data 44");
        System.out.println(deneme.getData());
    }
}
