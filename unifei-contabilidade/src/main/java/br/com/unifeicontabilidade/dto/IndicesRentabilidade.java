package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.PercentSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesRentabilidade {

    @JsonSerialize(using = PercentSerializer.class)
    private Double giroDoAtivo;

    @JsonSerialize(using = PercentSerializer.class)
    private Double margemLiquida;

    @JsonSerialize(using = PercentSerializer.class)
    private Double rentabilidadeDoAtivo;

    @JsonSerialize(using = PercentSerializer.class)
    private Double rentabilidadeDoPatrimonioLiquido;
}
