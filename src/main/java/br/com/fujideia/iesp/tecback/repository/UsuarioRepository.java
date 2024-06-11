package br.com.fujideia.iesp.tecback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
    List<Usuario> findAllByOrderByNomeCompletoAsc();
}
