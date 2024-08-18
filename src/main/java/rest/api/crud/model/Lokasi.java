package rest.api.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_lokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private Timestamp created_at;

    @OneToMany(mappedBy = "lokasi")
    @JsonManagedReference
    private Set<Proyek_lokasi> proyekLokasi;

    public Lokasi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Set<Proyek_lokasi> getProyek_lokasi() {
        return proyekLokasi;
    }

    public void setProyek_lokasi(Set<Proyek_lokasi> Proyek_lokasi) {
        this.proyekLokasi = Proyek_lokasi;
    }

    @PrePersist
    protected void onCreate() {
        created_at = Timestamp.from(Instant.now());
    }
}
