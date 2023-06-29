package br.com.unifeicontabilidade.dto;

import lombok.Data;

@Data
public class IndicesDto {

    private IndicesEstruturaCapital indicesEstruturaCapital;
    private IndicesLiquidez indicesLiquidez;
    private IndicesRentabilidade indicesRentabilidade;
    private IndicesLucratividade indicesLucratividade;

    {
        this.indicesEstruturaCapital = new IndicesEstruturaCapital();
        this.indicesLiquidez = new IndicesLiquidez();
        this.indicesRentabilidade = new IndicesRentabilidade();
        this.indicesLucratividade = new IndicesLucratividade();
    }
}
