package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.PercentSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesLucratividade {

    @JsonSerialize(using = PercentSerializer.class)
    private Double margemBruta;

    @JsonSerialize(using = PercentSerializer.class)
    private Double margemOperacional;

    @JsonSerialize(using = PercentSerializer.class)
    private Double margemEbitda;
}
