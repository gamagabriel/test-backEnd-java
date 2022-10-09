package com.uol.api.controller;

import com.uol.api.model.dto.PlayerDto;
import com.uol.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity savePlayer(@RequestBody @Valid PlayerDto playerDto){
        playerService.savePlayer(playerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
