package com.hamitmizrak.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
//@Data
// @NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter @Setter
@ToString
abstract public class BaseDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // Common Properties Values
    private Long ID;

    @Builder.Default
    private Date createDate= new Date(System.currentTimeMillis());

    // Parametresiz Constructur
    public BaseDto() {
        System.out.println("Hash Code: "+BaseDto.class.hashCode());
    }

} //end BaseDto
