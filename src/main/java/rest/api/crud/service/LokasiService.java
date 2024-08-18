package rest.api.crud.service;

import rest.api.crud.model.Lokasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import rest.api.crud.repository.LokasiRepository;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi getLokasiById(Integer id) {
        return lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi Tidak Ditemukan"));
    }

    public Lokasi addLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public Lokasi updateLokasi(Integer id, Lokasi lokasi) {
        Lokasi existingLokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi Tidak Ditemukan"));
        existingLokasi.setNama_lokasi(lokasi.getNama_lokasi());
        existingLokasi.setNegara(lokasi.getNegara());
        existingLokasi.setProvinsi(lokasi.getProvinsi());
        existingLokasi.setKota(lokasi.getKota());
        return lokasiRepository.save(existingLokasi);
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }

}
