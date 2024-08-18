package rest.api.crud.repository;

import rest.api.crud.model.Proyek_lokasi;
import rest.api.crud.model.Proyek_Lokasi_Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekLokasiRepository extends JpaRepository<Proyek_lokasi, Proyek_Lokasi_Id> {
}
