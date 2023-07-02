package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.PercentSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesLiquidez {

    @JsonSerialize(using = PercentSerializer.class)
    private Double liquidezGeral;

    @JsonSerialize(using = PercentSerializer.class)
    private Double liquidezCorrente;

    @JsonSerialize(using = PercentSerializer.class)
    private Double liquidezSeca;
}
