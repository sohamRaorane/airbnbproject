package com.soham.airbnb.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    @NotBlank(message ="Name is Required ")
    public String getName;


    @Email(message = "Invalid Email Format")
    @NotBlank(message ="Name is Required ")
    private String email;

    @Size(min = 6 , message = "Paaword must be atleast 6 characters")
    private String password;
}


