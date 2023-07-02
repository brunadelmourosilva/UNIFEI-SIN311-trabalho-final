package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.DecimalSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesLiquidez {

    @JsonSerialize(using = DecimalSerializer.class)
    private Double liquidezGeral;

    @JsonSerialize(using = DecimalSerializer.class)
    private Double liquidezCorrente;

    @JsonSerialize(using = DecimalSerializer.class)
    private Double liquidezSeca;
}
