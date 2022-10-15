package com.uol.api.service;

import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HeroiService heroiService;

    public Player savePlayer(PlayerDto playerDto) {
        Player player = new Player();
            player.setName(playerDto.getName());
            player.setEmail(playerDto.getEmail());
            player.setPhoneNumber(playerDto.getPhoneNumber());
            player.setHeroi(heroiService.salvaHeroi(playerDto.getHeroiEnum()));
        return playerRepository.save(player);
    }

}
