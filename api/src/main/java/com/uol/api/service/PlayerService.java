package com.uol.api.service;

import com.uol.api.model.Persister;
import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService implements Persister <PlayerDto> {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final HeroService heroService;

    @Override
    public void save(PlayerDto playerDto) {
        this.modelMapper.typeMap(PlayerDto.class, Player.class).addMappings(skip -> skip.skip(Player::setHero));
        final Player player = this.modelMapper.map(playerDto, Player.class);
        player.setHero(heroService.save(playerDto.getHeroType()));
        playerRepository.save(player);
    }
}
