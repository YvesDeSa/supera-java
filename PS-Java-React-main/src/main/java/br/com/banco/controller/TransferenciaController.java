package br.com.banco.controller;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/apirest/transferecias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transferencia> getById(@PathVariable(value = "id") Integer id){
        Transferencia transferenciaEmcontrada = service.findById(id);
        return ResponseEntity.ok().body(transferenciaEmcontrada);
    }

    @GetMapping()
    public ResponseEntity<List<Transferencia>> getAll() {
            List<Transferencia> listDeTransferencias = service.findAll();
            return ResponseEntity.ok().body(listDeTransferencias);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Transferencia>> getSeach(
        @RequestParam(name = "datestart", required = false) LocalDate dateStart,
        @RequestParam(name = "dateend", required = false) LocalDate dateEnd,
        @RequestParam(name = "name", required = false) String name
        ) {
            List<Transferencia> listDeTransferencias = service.findSeach(dateStart, dateEnd, name);
            return ResponseEntity.ok().body(listDeTransferencias);
    }
}
