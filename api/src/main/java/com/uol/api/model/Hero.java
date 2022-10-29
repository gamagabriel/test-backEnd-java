package com.uol.api.model;

import com.uol.api.enums.HeroType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity()
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Hero {

    private HeroType type;
    @Id
    private String codename;

}
