package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository repository;

    public Transferencia findById(Integer id){
        Optional<Transferencia> transferenciaEncontrada = repository.findById(id);
        return transferenciaEncontrada.orElse(null);
    }

    public List<Transferencia> findAll() {
        return repository.findAll();
    }

    public List<Transferencia> findSeach(LocalDate dateStart, LocalDate dateEnd, String name) {
        List<Transferencia> transferencias = repository.findAll();
        
        if(!name.isEmpty()){
            transferencias = transferencias.stream().filter(
                transferecia -> transferecia.getNome_operador_transacao() != null 
                && transferecia.getNome_operador_transacao().equals(name)).toList();
        }

        if(dateStart != null && dateEnd != null){
            transferencias = transferencias.stream().filter(
                transferecia -> transferecia.getData_transferencia().isAfter(dateStart) 
                && transferecia.getData_transferencia().isBefore(dateEnd)
                || transferecia.getData_transferencia().isEqual(dateStart)
                || transferecia.getData_transferencia().isEqual(dateEnd) ).toList();
        }

        return transferencias;
    }
}
