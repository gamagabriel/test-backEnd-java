package com.uol.api.model;

import com.uol.api.enums.HeroiEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Heroi {

    private HeroiEnum heroiEnum;
    @Id
    private String heroi;

}
