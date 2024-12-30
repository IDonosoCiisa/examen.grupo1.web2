package grupo1.examen.controllers;

import grupo1.examen.models.Lamina;
import grupo1.examen.services.LaminaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laminas")
public class LaminaController {

    private final LaminaService laminaService;

    @Autowired
    public LaminaController(LaminaService laminaService) {
        this.laminaService = laminaService;
    }

    @PostMapping
    public Lamina createLamina(@RequestBody Lamina lamina) {
        return laminaService.saveLamina(lamina);
    }

    @GetMapping("/faltantes/{albumId}")
    public List<Lamina> getLaminasFaltantes(@PathVariable Long albumId) {
        return laminaService.getLaminasFaltantes(albumId);
    }

    @GetMapping("/repetidas/{albumId}")
    public List<Lamina> getLaminasRepetidas(@PathVariable Long albumId) {
        return laminaService.getLaminasRepetidas(albumId);
    }

    // Other endpoints as needed
}