package rest.api.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek_lokasi")
public class Proyek_lokasi {

    @EmbeddedId
    private Proyek_Lokasi_Id Id;

    @ManyToOne
    @JoinColumn(name = "proyek_id", insertable = false, updatable = false)
    @JsonBackReference(value = "proyed_lokasi")
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", insertable = false, updatable = false)
    @JsonBackReference
    private Lokasi lokasi;

    public Proyek_lokasi() {
    }

    public Proyek_Lokasi_Id getId() {
        return Id;
    }

    public void setId(Proyek_Lokasi_Id id) {
        this.Id = id;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

}
