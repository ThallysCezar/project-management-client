package com.metatelecom.crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    private String name;

    private String contactNumber;

    private String address;

    private String gender;

    private String department;

    private String skills;

    private Boolean isActive;

}