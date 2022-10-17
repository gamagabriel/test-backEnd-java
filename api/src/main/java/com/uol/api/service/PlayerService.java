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
        this.modelMapper.typeMap(PlayerDto.class, Player.class).addMappings(c -> c.skip(Player::setHeroi));
        final Player player = this.modelMapper.map(playerDto, Player.class);
        player.setHeroi(this.heroiService.salvaHeroi(playerDto.getHeroiEnum()));
        return playerRepository.save(player);
    }

}
