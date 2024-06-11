package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Favoritos;
import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
    List<Favoritos> findByUsuario(Usuario usuario);
    List<Favoritos> findByUsuarioAndFilmeIsNotNull(Usuario usuario);
    List<Favoritos> findByUsuarioAndSerieIsNotNull(Usuario usuario);
}
