package grupo1.examen.services;

import grupo1.examen.models.Album;
import grupo1.examen.models.Lamina;
import grupo1.examen.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album saveAlbum(Album album) {
        List<Lamina> laminas = getLaminaList(album);
        album.setLaminas(laminas);

        return albumRepository.save(album);
    }

    private static List<Lamina> getLaminaList(Album album) {
        Map<Integer, Lamina> laminaMap = album.getLaminas().stream()
                .collect(Collectors.toMap(Lamina::getNumero, lamina -> lamina));

        List<Lamina> laminas = new ArrayList<>();
        for (int i = 0; i < album.getCantidadLaminas(); i++) {
            Lamina lamina = laminaMap.getOrDefault(i, new Lamina());
            lamina.setAlbum(album);
            lamina.setNumero(i);
            laminas.add(lamina);
        }
        return laminas;
    }
}