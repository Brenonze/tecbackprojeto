package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/filme")
public class FilmeController {

    private FilmeService service;

    @PostMapping
    public Filme salvar(@Valid @RequestBody Filme filme){
        return service.salvar(filme);
    }

    @GetMapping
    public List<Filme> listarTodos(){
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Integer id, @RequestBody Filme filme){
        filme.setId(id);
        return service.atualizar(filme);
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluir(id);
    }
}
