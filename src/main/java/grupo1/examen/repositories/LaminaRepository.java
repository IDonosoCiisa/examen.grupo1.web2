package grupo1.examen.repositories;

import grupo1.examen.models.Lamina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaminaRepository extends JpaRepository<Lamina, Long> {
}
