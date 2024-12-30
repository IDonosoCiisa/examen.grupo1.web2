package grupo1.examen.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fechaLanzamiento;
    private String tipoLaminas;
    private int cantidadLaminas;

    @JsonManagedReference
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Lamina> laminas;

    public Album() {
    }

    public List<Lamina> getLaminas() {
        return laminas;
    }

    public void setLaminas(List<Lamina> laminas) {
        this.laminas = laminas;
    }

    public int getCantidadLaminas() {
        return cantidadLaminas;
    }

    public void setCantidadLaminas(int cantidadLaminas) {
        this.cantidadLaminas = cantidadLaminas;
    }

    public String getTipoLaminas() {
        return tipoLaminas;
    }

    public void setTipoLaminas(String tipoLaminas) {
        this.tipoLaminas = tipoLaminas;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final class AlbumBuilder {
        private Long id;
        private String nombre;
        private Date fechaLanzamiento;
        private String tipoLaminas;
        private int cantidadLaminas;
        private List<Lamina> laminas;

        private AlbumBuilder() {
        }

        public static AlbumBuilder anAlbum() {
            return new AlbumBuilder();
        }

        public AlbumBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AlbumBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public AlbumBuilder withFechaLanzamiento(Date fechaLanzamiento) {
            this.fechaLanzamiento = fechaLanzamiento;
            return this;
        }

        public AlbumBuilder withTipoLaminas(String tipoLaminas) {
            this.tipoLaminas = tipoLaminas;
            return this;
        }

        public AlbumBuilder withCantidadLaminas(int cantidadLaminas) {
            this.cantidadLaminas = cantidadLaminas;
            return this;
        }

        public AlbumBuilder withLaminas(List<Lamina> laminas) {
            this.laminas = laminas;
            return this;
        }

        public Album build() {
            Album album = new Album();
            album.setId(id);
            album.setNombre(nombre);
            album.setFechaLanzamiento(fechaLanzamiento);
            album.setTipoLaminas(tipoLaminas);
            album.setCantidadLaminas(cantidadLaminas);
            album.setLaminas(laminas);
            return album;
        }
    }
}