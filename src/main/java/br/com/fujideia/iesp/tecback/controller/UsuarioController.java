package br.com.fujideia.iesp.tecback.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) { // O @RequestBody indica que o objeto usuário será preenchido com os dados do corpo da requisição HTTP POST.
        return usuarioService.cadastrarUsuario(usuario);
    }

    //LISTAR USUARIOS
    @GetMapping // Listar todos usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }


    //BUSCAR PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /// Atualizar usuario ///
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        /// Verificar se o usuário existe
        if (!usuarioService.usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        /// Atualizar usuário ///
        usuario.setId(id); // Certificar que o ID do caminho está usado
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    /// RF 7 - Ordenando usuarios por nome ///
    @GetMapping("/ordenados")
    public List<Usuario> listarUsuariosOrdenados() {
        return usuarioService.listarUsuariosOrdenadosPorNome();
    }

    /// Deletar usuario ///
    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
    }
}

