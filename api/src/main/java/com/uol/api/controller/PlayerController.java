package com.uol.api.controller;

import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.repository.PlayerRepository;
import com.uol.api.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public void savePlayer(@RequestBody @Valid PlayerDto playerDto) {
        this.playerService.save(playerDto);
    }

    @GetMapping
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}