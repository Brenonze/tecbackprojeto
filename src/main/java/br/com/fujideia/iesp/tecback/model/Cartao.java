package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nomeTitular;
    private Date dataValidade;

    @NotBlank
    @Length(max = 16)
    private String numero;

    @NotBlank
    @Length(max = 3)
    private String codigoSeguranca;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public String getNumero() {
        return numero;
    }
}
