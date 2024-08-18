package rest.api.crud.controller;

import rest.api.crud.service.ProyekService;
import rest.api.crud.model.Proyek;
import rest.api.crud.model.Proyek_Lokasi_Id;
import rest.api.crud.model.Proyek_lokasi;
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
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @GetMapping("/{id}")
    public Proyek getProyekById(@PathVariable Integer id) {
        return proyekService.getProyekById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addProyek(@RequestBody Proyek proyek) {
        Proyek savedProyek = proyekService.addProyek(proyek);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data Berhasil ditambahkan");
        response.put("data", savedProyek);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProyek(@PathVariable Integer id, @RequestBody Proyek proyek) {
        Proyek updatedProyek = proyekService.updateProyek(id, proyek);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data Berhasil diupdate");
        response.put("data", updatedProyek);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProyek(@PathVariable Integer id) {
        proyekService.deleteProyek(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data Berhasil dihapus");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{proyek_id}/lokasi/{lokasi_id}")
    public Proyek_lokasi addLokasiToProyek(@PathVariable Integer proyek_id, @PathVariable Integer lokasi_id) {
        Proyek_Lokasi_Id id = new Proyek_Lokasi_Id(proyek_id, lokasi_id);
        Proyek_lokasi proyekLokasi = new Proyek_lokasi();
        proyekLokasi.setId(id);
        return proyekLokasiService.saveProyekLokasi(proyekLokasi);
    }

    @DeleteMapping("/{proyek_id}/lokasi/{lokasi_id}")
    public void removeLokasiFromProyek(@PathVariable Integer proyek_id, @PathVariable Integer lokasi_id) {
        Proyek_Lokasi_Id id = new Proyek_Lokasi_Id(proyek_id, lokasi_id);
        proyekLokasiService.deleteProyekLokasi(id);
    }
}
