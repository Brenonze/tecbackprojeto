package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.repository.CartaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao criar(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public Cartao atualizar(Cartao cartao){
        /// Confirma se o cartão existe por ID ///
        if (cartao.getId() == null || !cartaoRepository.existsById(String.valueOf(cartao.getId()))) {
            throw new EntityNotFoundException("Cartão não encontrado ou ID de cartão inválido: " + cartao.getId());
        }
        return cartaoRepository.save(cartao);
    }

    public Cartao buscarPorId(Integer id){
        return cartaoRepository.findById(String.valueOf(id)).get();
    }

    public void excluir(Integer id){
        cartaoRepository.deleteById(String.valueOf(id));
    }

}
