package br.com.unifeicontabilidade.dto;

import lombok.Data;

@Data
public class IndicesDto {

    private IndicesEstruturaCapital indicesEstruturaCapital;
    private IndicesLiquidez indicesLiquidez;

    {
        this.indicesEstruturaCapital = new IndicesEstruturaCapital();
        this.indicesLiquidez = new IndicesLiquidez();
    }
}
