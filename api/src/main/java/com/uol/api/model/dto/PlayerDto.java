package com.uol.api.model.dto;

import com.uol.api.enums.HeroType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    @NotBlank(message = "The name field cannot be blank.")
    private String name;
    @Email(message = "Enter a valid email format")
    @NotBlank (message = "The email field cannot be blank")
    private String email;

    private String phoneNumber;

    private HeroType heroType;
}
