package com.uol.api.controller;

import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.repository.PlayerRepository;
import com.uol.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid PlayerDto playerDto) {
        playerService.savePlayer(playerDto);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}