package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.service.SerieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/serie")
public class SerieController {

    private SerieService service;

    @PostMapping
    public Serie salvar(@Valid @RequestBody Serie serie){
        return service.salvar(serie);
    }

    @GetMapping
    public List<Serie> listarTodos(){
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Serie atualizar(@PathVariable Integer id, @RequestBody Serie serie){
        serie.setId(id);
        return service.atualizar(serie);
    }

    @GetMapping("/{id}")
    public Serie buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluir(id);
    }
}
