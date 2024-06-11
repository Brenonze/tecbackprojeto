package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.validator.SenhaValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
            throw new SenhaValidationException("As senhas não correspondem.");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(Usuario usuario) { return usuarioRepository.save(usuario); }

    public void excluirUsuario(Long id) { usuarioRepository.deleteById(id); }

    public List<Usuario> listarUsuariosOrdenadosPorNome() {
        return usuarioRepository.findAllByOrderByNomeCompletoAsc();
    }

}

