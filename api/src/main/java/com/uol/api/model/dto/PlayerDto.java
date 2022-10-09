package com.uol.api.model.dto;

import com.uol.api.enums.HeroiEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    @NotBlank
    private String name;
    @Email @NotBlank
    private String email;
    private String phoneNumber;
    private HeroiEnum heroiEnum;
}
