package br.com.unifeicontabilidade.dto;

import lombok.Data;

@Data
public class IndicesRentabilidade {

    private Double giroDoAtivo;
    private Double margemLiquida;
    private Double rentabilidadeDoAtivo;
    private Double rentabilidadeDoPatrimonioLiquido;
}
