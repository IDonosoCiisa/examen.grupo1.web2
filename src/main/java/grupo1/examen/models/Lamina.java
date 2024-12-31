package grupo1.examen.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Lamina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nullable
    private String imagen;
    private int cantidad;
    private int numero;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "album_id")
    private Album album;

    public Lamina() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public static final class LaminaBuilder {
        private Long id;
        private String imagen;
        private int cantidad;
        private Album album;
        private int numero;
        private LaminaBuilder() {
        }

        public static LaminaBuilder aLamina() {
            return new LaminaBuilder();
        }

        public LaminaBuilder withId(Long id) {
            this.id = id;
            return this;
        }
        public LaminaBuilder withNumero(int numero) {
            this.numero = numero;
            return this;
        }

        public LaminaBuilder withImagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public LaminaBuilder withCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public LaminaBuilder withAlbum(Album album) {
            this.album = album;
            return this;
        }

        public Lamina build() {
            Lamina lamina = new Lamina();
            lamina.setNumero(numero);
            lamina.setId(id);
            lamina.setImagen(imagen);
            lamina.setCantidad(cantidad);
            lamina.setAlbum(album);
            return lamina;
        }
    }
}