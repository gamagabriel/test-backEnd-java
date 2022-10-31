package com.uol.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeroType {
    VINGADORES(1,"Os vingadores"),
    LIGA_DA_JUSTICA(2, "Liga da Justiça");

    private final Integer number;
    private final String description;
}
