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

    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String name;
    @Email(message = "Digite um formato de e-mail válido.")
    @NotBlank (message = "O campo nome não pode estar vazio.")
    private String email;

    private String phoneNumber;
    private HeroiEnum heroiEnum;
}
