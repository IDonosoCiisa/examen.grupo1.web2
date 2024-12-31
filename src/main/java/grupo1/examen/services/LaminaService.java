package grupo1.examen.services;

import grupo1.examen.models.Album;
import grupo1.examen.models.Lamina;
import grupo1.examen.repositories.AlbumRepository;
import grupo1.examen.repositories.LaminaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaminaService {
    private final LaminaRepository laminaRepository;
    private final AlbumRepository albumRepository;

    public LaminaService(LaminaRepository laminaRepository, AlbumRepository albumRepository) {
        this.laminaRepository = laminaRepository;
        this.albumRepository = albumRepository;
    }

    public List<Lamina> getAllLaminas() {
        return laminaRepository.findAll();
    }

    public Lamina getLaminaById(Long id) {
        return laminaRepository.findById(id).orElseThrow(() -> new RuntimeException("Lamina not found"));
    }

    public Lamina saveLamina(Lamina lamina) {
        return laminaRepository.save(lamina);
    }

    public Lamina updateLamina(Long id, Lamina laminaDetails) {
        Lamina lamina = getLaminaById(id);
        lamina.setNumero(laminaDetails.getNumero());
        lamina.setImagen(laminaDetails.getImagen());
        lamina.setCantidad(laminaDetails.getCantidad());
        lamina.setAlbum(laminaDetails.getAlbum());
        return laminaRepository.save(lamina);
    }

    public void deleteLamina(Long id) {
        Lamina lamina = getLaminaById(id);
        Album album = albumRepository.findById(lamina.getAlbum().getId()).orElseThrow(() -> new RuntimeException("Album not found"));
        album.setCantidadLaminas(album.getCantidadLaminas() - 1);
        albumRepository.save(album);
        laminaRepository.deleteById(id);
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
