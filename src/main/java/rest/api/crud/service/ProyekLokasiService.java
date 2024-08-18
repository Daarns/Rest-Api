package rest.api.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.api.crud.model.Proyek_lokasi;
import rest.api.crud.model.Proyek_Lokasi_Id;
import rest.api.crud.repository.ProyekLokasiRepository;

import java.util.List;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    public List<Proyek_lokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public Proyek_lokasi getProyekLokasiById(Proyek_Lokasi_Id id) {
        return proyekLokasiRepository.findById(id).orElse(null);
    }

    public Proyek_lokasi saveProyekLokasi(Proyek_lokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    public void deleteProyekLokasi(Proyek_Lokasi_Id id) {
        proyekLokasiRepository.deleteById(id);
    }
}
