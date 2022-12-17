package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;

import java.util.List;

@RestController
@RequestMapping("/apirest/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Conta> findById(@PathVariable Integer id) {
       Conta contaEmcontrada = service.findById(id);
       return ResponseEntity.ok().body(contaEmcontrada) ;
    }
    @GetMapping
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> listDeContas = service.findAll();
        return ResponseEntity.ok().body(listDeContas);
    }

}
