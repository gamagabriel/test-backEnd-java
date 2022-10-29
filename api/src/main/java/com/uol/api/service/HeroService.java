package com.uol.api.service;

import com.uol.api.enums.HeroType;
import com.uol.api.model.Hero;
import com.uol.api.model.dto.ContainerJson;
import com.uol.api.model.dto.ContainerXml;
import com.uol.api.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class HeroService {
    public static final String CODENAME = "codinome";

    private final RequestHttpAvengers requestHttpAvengers;

    private final RequestHttpLeague requestHttpLeague;

    private final HeroRepository heroRepository;


    public Hero save(HeroType heroType) {
        final List<Hero> heroList = this.heroRepository.findByType(heroType);
        final Hero hero = new Hero();
        hero.setType(heroType);
        hero.setCodename(this.checkCodnameAvailable(heroList, getCodenameList(hero)));
        return hero;
    }

    private String checkCodnameAvailable(List<Hero> heroList, List<String> codename) {

        final List<String> verifyName = new ArrayList<>(codename);

        if (isIfElements(heroList, verifyName)) {
            heroList.forEach(hero -> verifyName.removeIf(comparator -> comparator.equals(hero.getCodename())));
            Random random = new Random(verifyName.size());
            return verifyName.get(random.nextInt(verifyName.size()));
        }
        return null;
    }

    private boolean isIfElements(List<Hero> heroList, List<String> verificarNome) {
        return heroList.size() >= 1 || verificarNome.size() >= 1;
    }

    private List<String> getCodenameList(Hero hero) {
        if (hero.getType().equals(HeroType.VINGADORES)) {
            final ContainerJson containerVingadores = this.requestHttpAvengers.getVingadores();
            return containerVingadores.getVingadores().stream().map(codename -> codename.get(CODENAME)).toList();
        }
        final ContainerXml containerXml = this.requestHttpLeague.getLiga();
        return containerXml.getLigaDaJustica();

    }
}
