package com.uol.api.service;

import com.uol.api.enums.HeroiEnum;
import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PlayerRepository playerRepository;

    private PlayerDto playerDto;

    private Player player;

    @BeforeEach
    void setup() {
        playerDto = userDto();
    }

    @Test
    void GivenSaveUserWithSuccessful(){
        when(modelMapper.map(playerDto, Player.class)).thenReturn(player);
        assertDoesNotThrow(() -> playerService.savePlayer(playerDto));
    }

    PlayerDto userDto() {
        return new PlayerDto("Gabriel Gama", "gabriel@gabriel.com", "(27)999999999", HeroiEnum.LIGA_DA_JUSTICA);
    }


}
