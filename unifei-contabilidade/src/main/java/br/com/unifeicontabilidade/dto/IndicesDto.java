package br.com.unifeicontabilidade.dto;

import lombok.Data;

@Data
public class IndicesDto {

    private IndicesEstruturaCapital indicesEstruturaCapital;

    {
        this.indicesEstruturaCapital = new IndicesEstruturaCapital();
    }
}
