package com.uol.api.controller;

import com.uol.api.model.Player;
import com.uol.api.model.dto.PlayerDto;
import com.uol.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping()
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid PlayerDto playerDto) {
        playerService.savePlayer(playerDto);
        return ResponseEntity.status(CREATED).build();
    }

}
