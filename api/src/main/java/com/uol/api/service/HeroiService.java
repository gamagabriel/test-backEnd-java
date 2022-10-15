package com.uol.api.service;

import com.uol.api.enums.HeroiEnum;
import com.uol.api.model.Heroi;
import com.uol.api.model.dto.ContainerJson;
import com.uol.api.model.dto.ContainerXml;
import com.uol.api.repository.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Criar métodos com as seguintes funções:
// 1° verificar se há codinomes disponíveis para salvar.
// 2° Método para salvar o codinome.
//
@Service
@Transactional
public class HeroiService {

    @Autowired
    private HttpService httpService;

    @Autowired
    private HeroiRepository heroiRepository;

    public Heroi salvaHeroi(HeroiEnum heroiEnum) {
        List<Heroi> heroiList = this.heroiRepository.findByHeroiEnum(heroiEnum);
        Heroi heroi = new Heroi();
        heroi.setHeroiEnum(heroiEnum);

        if (heroi.getHeroiEnum().equals(HeroiEnum.VINGADORES)) {
            ContainerJson containerJson = this.httpService.getVingadores();
            List<String> codinomeJson = containerJson.getVingadores()
                    .stream()
                    .map(x -> x.get("codinome"))
                    .toList();
            heroi.setHeroiCodNome(this.verificarSeCodinomeDisponivel(heroiList, codinomeJson));
        } else {
            ContainerXml containerXml = this.httpService.getLiga();
            List<String> codinomeXml = containerXml.getLigaDaJustica()
                    .stream()
                    .toList();
            heroi.setHeroiCodNome(this.verificarSeCodinomeDisponivel(heroiList, codinomeXml));

        }
        return heroi;
    }

    private String verificarSeCodinomeDisponivel(List<Heroi> heroiList, List<String> codinome) {
        final List<String> verificarNome = new ArrayList<>(codinome);

        try {
            if (heroiList.size() >= 1 || verificarNome.size() >= 1) {
                heroiList.forEach(heroi -> verificarNome
                        .removeIf(comparator ->
                                comparator.equals(heroi.getHeroiCodNome())));
                Random random = new Random(verificarNome.size());
                return verificarNome.get(random.nextInt(verificarNome.size()));
            }
        } catch (IllegalArgumentException | EntityExistsException e) {
            e.printStackTrace();
        }
        return null;
    }

}
