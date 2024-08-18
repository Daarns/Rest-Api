package rest.api.crud.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import rest.api.crud.model.Proyek;
import java.util.List;
import rest.api.crud.repository.ProyekRepository;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository ProyekRepository;

    public Proyek getProyekById(Integer id) {
        return ProyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek Tidak Ditemukan"));
    }

    public List<Proyek> getAllProyek() {
        return ProyekRepository.findAll();
    }

    public Proyek addProyek(Proyek proyek) {
        return ProyekRepository.save(proyek);
    }

    public Proyek updateProyek(Integer id, Proyek proyek) {
        Proyek existingProyek = ProyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek Tidak Ditemukan"));
        existingProyek.setNama_proyek(proyek.getNama_proyek());
        existingProyek.setClient(proyek.getClient());
        existingProyek.setTgl_mulai(proyek.getTgl_mulai());
        existingProyek.setTgl_selesai(proyek.getTgl_selesai());
        existingProyek.setPimpinan_proyek(proyek.getPimpinan_proyek());
        existingProyek.setKeterangan(proyek.getKeterangan());
        return ProyekRepository.save(existingProyek);
    }

    public void deleteProyek(Integer id) {
        ProyekRepository.deleteById(id);
    }

}
