package grupo1.examen.services;
import grupo1.examen.models.Lamina;
import grupo1.examen.repositories.LaminaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaminaService {
    private final LaminaRepository laminaRepository;

    public LaminaService(LaminaRepository laminaRepository) {
        this.laminaRepository = laminaRepository;
    }

    public Lamina saveLamina(Lamina lamina) {
        return laminaRepository.save(lamina);
    }

    public List<Lamina> getLaminasFaltantes(Long albumId) {
        return laminaRepository.findAll().stream()
                .filter(lamina -> lamina.getAlbum().getId().equals(albumId) && lamina.getCantidad() == 0)
                .collect(Collectors.toList());
    }

    public List<Lamina> getLaminasRepetidas(Long albumId) {
        return laminaRepository.findAll().stream()
                .filter(lamina -> lamina.getAlbum().getId().equals(albumId) && lamina.getCantidad() > 1)
                .collect(Collectors.toList());
    }


}
// Other methods as needed