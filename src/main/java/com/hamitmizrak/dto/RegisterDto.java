package com.hamitmizrak.dto;

import com.hamitmizrak.roles.ERoles;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
//@Builder
public class RegisterDto extends BaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // Variable
    private String nickName;
    private String emailAddress;
    private String password;
    private String role;
    private String phoneNumber;
    private Boolean isPassive;

    public RegisterDto() {
        super();
    }

    public RegisterDto(Long ID, Date createDate, String nickName, Boolean isPassive, String phoneNumber, String role, String password, String emailAddress) {
        super(ID, createDate);
        this.nickName = nickName;
        this.isPassive = isPassive;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "nickName='" + nickName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isPassive=" + isPassive +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        //RegisterDto registerDto = new RegisterDto();
        /*RegisterDto registerDto =  RegisterDto
                .builder()
                .emailAddress("hamitmizrak@gmail.com")
                .password("123456")
                .isPassive(false)
                .nickName("computer science")
                .role(ERoles.ADMIN.toString())
                .build();*/

        RegisterDto registerDto = new RegisterDto();
        registerDto.setID(1L);
        registerDto.setNickName("computer science");
        registerDto.setEmailAddress("hamitmizrak@gmail.com");
        registerDto.setPassword("123456");
        registerDto.setIsPassive(Boolean.FALSE);
        registerDto.setRole(ERoles.ADMIN.toString());
        System.out.println(registerDto);
    }
}
