package rest.api.crud.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Proyek_Lokasi_Id implements Serializable {
    private Integer proyek_id;
    private Integer lokasi_id;

    public Proyek_Lokasi_Id() {
    }

    public Proyek_Lokasi_Id(Integer proyek_id, Integer lokasi_id) {
        this.proyek_id = proyek_id;
        this.lokasi_id = lokasi_id;
    }

    public Integer getProyek_id() {
        return proyek_id;
    }

    public void setProyek_id(Integer proyek_id) {
        this.proyek_id = proyek_id;
    }

    public Integer getLokasi_id() {
        return lokasi_id;
    }

    public void setLokasi_id(Integer lokasi_id) {
        this.lokasi_id = lokasi_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Proyek_Lokasi_Id that = (Proyek_Lokasi_Id) o;
        return Objects.equals(proyek_id, that.proyek_id) && Objects.equals(lokasi_id, that.lokasi_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyek_id, lokasi_id);
    }

}
