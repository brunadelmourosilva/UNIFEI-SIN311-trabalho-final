package br.com.unifeicontabilidade.dto;

import br.com.unifeicontabilidade.serializer.DecimalSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class IndicesEficienciaAtividadeOuRotatividade {

    @JsonSerialize(using = DecimalSerializer.class)
    private Double giroDoContasAReceber;
}
