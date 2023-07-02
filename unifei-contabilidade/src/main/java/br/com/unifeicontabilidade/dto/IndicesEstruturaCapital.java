package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.PercentSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesEstruturaCapital {

    @JsonSerialize(using = PercentSerializer.class)
    private Double participacaoDeCapitalDeTerceiros;

    @JsonSerialize(using = PercentSerializer.class)
    private Double composicaoDoEndividamento;

    @JsonSerialize(using = PercentSerializer.class)
    private Double imobilizacaoDoPatrimonioLiquido;
}
