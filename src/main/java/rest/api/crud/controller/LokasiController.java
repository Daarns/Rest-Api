package rest.api.crud.controller;

import rest.api.crud.model.Lokasi;
import rest.api.crud.model.Proyek_Lokasi_Id;
import rest.api.crud.model.Proyek_lokasi;
import rest.api.crud.service.LokasiService;
import rest.api.crud.service.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Integer id) {
        Lokasi lokasi = lokasiService.getLokasiById(id);
        return new ResponseEntity<>(lokasi, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addLokasi(@RequestBody Lokasi lokasi) {
        Lokasi savedLokasi = lokasiService.addLokasi(lokasi);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil ditambahkan");
        response.put("data", savedLokasi);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasi) {
        Lokasi updatedLokasi = lokasiService.updateLokasi(id, lokasi);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil diupdate");
        response.put("data", updatedLokasi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLokasi(@PathVariable Integer id) {
        lokasiService.deleteLokasi(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Lokasi berhasil dihapus");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{lokasi_id}/proyek/{proyek_id}")
    public Proyek_lokasi addProyekToLokasi(Integer lokasiId, Integer proyekId) {
        Proyek_Lokasi_Id id = new Proyek_Lokasi_Id(proyekId, lokasiId);
        Proyek_lokasi proyekLokasi = new Proyek_lokasi();
        proyekLokasi.setId(id);
        return proyekLokasiService.saveProyekLokasi(proyekLokasi);
    }

    @DeleteMapping("/{lokasi_id}/proyek/{proyek_id}")
    public void removeProyekFromLokasi(Integer lokasiId, Integer proyekId) {
        Proyek_Lokasi_Id id = new Proyek_Lokasi_Id(proyekId, lokasiId);
        proyekLokasiService.deleteProyekLokasi(id);
    }

}
