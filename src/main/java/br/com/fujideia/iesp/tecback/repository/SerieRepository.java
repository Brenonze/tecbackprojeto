package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    List<Serie> findByTituloAndDescricao(String titulo, String descricao);
    List<Serie> findByTitulo(String titulo);
    List<Serie> findByTituloOrderByTituloAsc(String titulo);

    @Query("SELECT f FROM Serie f ORDER BY f.titulo")
    List<Serie> findByTituloAsc();
}
