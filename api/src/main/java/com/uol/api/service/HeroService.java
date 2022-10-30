package com.uol.api.service;

import com.uol.api.enums.HeroType;
import com.uol.api.exceptions.GroupIsFullException;
import com.uol.api.model.Hero;
import com.uol.api.model.dto.ContainerAvengers;
import com.uol.api.model.dto.ContainerLeague;
import com.uol.api.repository.HeroRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
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

    @SneakyThrows
    private String checkCodnameAvailable(List<Hero> heroList, List<String> codename) {

        final List<String> verifyCodename = new ArrayList<>(codename);
        try {
            if (isIfElements(heroList, verifyCodename)) {
                heroList.forEach(hero -> verifyCodename.removeIf(comparator -> comparator.equals(hero.getCodename())));
                Random random = new Random(verifyCodename.size());
                return verifyCodename.get(random.nextInt(verifyCodename.size()));
            }
        } catch (IllegalArgumentException e) {
            throw new GroupIsFullException();
        }
        throw new GroupIsFullException();
    }

    private boolean isIfElements(List<Hero> heroList, List<String> verificarNome) {
        return heroList.size() >= 1 || verificarNome.size() >= 1;
    }

    private List<String> getCodenameList(Hero hero) {
        if (hero.getType().equals(HeroType.VINGADORES)) {
            final ContainerAvengers containerVingadores = this.requestHttpAvengers.getVingadores();
            return containerVingadores.getVingadores().stream().map(codename -> codename.get(CODENAME)).toList();
        }
        final ContainerLeague containerLeague = this.requestHttpLeague.getLiga();
        return containerLeague.getLigaDaJustica();

    }
}
