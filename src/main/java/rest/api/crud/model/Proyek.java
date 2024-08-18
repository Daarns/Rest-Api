package rest.api.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Timestamp;
import java.time.Instant;
import java.sql.Date;
import jakarta.persistence.Table;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_proyek;
    private String client;
    private Date tgl_mulai;
    private Date tgl_selesai;
    private String pimpinan_proyek;
    private String keterangan;
    private Timestamp created_at;

    @OneToMany(mappedBy = "proyek", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "proyed_lokasi")
    private Set<Proyek_lokasi> proyekLokasi;

    public Proyek() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_proyek() {
        return nama_proyek;
    }

    public void setNama_proyek(String nama_proyek) {
        this.nama_proyek = nama_proyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(Date tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public Date getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(Date tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getPimpinan_proyek() {
        return pimpinan_proyek;
    }

    public void setPimpinan_proyek(String pimpinan_proyek) {
        this.pimpinan_proyek = pimpinan_proyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
