package com.uol.api.service;

import com.uol.api.enums.HeroiEnum;
import com.uol.api.model.Heroi;
import com.uol.api.model.dto.ContainerJson;
import com.uol.api.model.dto.ContainerXml;
import com.uol.api.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HeroiService {

    @Autowired
    private  HttpService httpService;

    @Autowired
    private HeroiRepository heroiRepository;

    public Heroi salvaHeroi(HeroiEnum heroiEnum) {
        final List<Heroi> heroiList = this.heroiRepository.findByHeroiEnum(heroiEnum);
        final Heroi heroi = new Heroi();
        heroi.setHeroiEnum(heroiEnum);

        if (heroi.getHeroiEnum().equals(HeroiEnum.VINGADORES)) {
            final ContainerJson containerJson = this.httpService.getVingadores();
            final List<String> codinomeJson = containerJson.getVingadores().stream().map(x -> x.get("codinome")).toList();
            heroi.setHeroiCodNome(this.verificarSeCodinomeDisponivel(heroiList, codinomeJson));
        }
        if (heroi.getHeroiEnum().equals(HeroiEnum.LIGA_DA_JUSTICA)) {
            final ContainerXml containerXml = this.httpService.getLiga();
            final List<String> codinomeXml = containerXml.getLigaDaJustica().stream().toList();
            heroi.setHeroiCodNome(this.verificarSeCodinomeDisponivel(heroiList, codinomeXml));

        }
        return heroi;
    }

    private String verificarSeCodinomeDisponivel(List<Heroi> heroiList, List<String> codinome) {
        final List<String> verificarNome = new ArrayList<>(codinome);

        if (heroiList.size() >= 1 || verificarNome.size() >= 1) {
            heroiList.forEach(heroi -> verificarNome.removeIf(comparator -> comparator.equals(heroi.getHeroiCodNome())));
            Random random = new Random(verificarNome.size());
            return verificarNome.get(random.nextInt(verificarNome.size()));
        }

        return null;
    }

}
