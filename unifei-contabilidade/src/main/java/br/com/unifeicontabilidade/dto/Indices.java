package br.com.unifeicontabilidade.dto;

import lombok.Data;

@Data
public class Indices {

    private IndicesEstruturaCapital indicesEstruturaCapital;
    private IndicesLiquidez indicesLiquidez;
    private IndicesRentabilidade indicesRentabilidade;
    private IndicesEficienciaAtividadeOuRotatividade indicesEficienciaAtividadeOuRotatividade;
    private IndicesLucratividade indicesLucratividade;

    {
        this.indicesEstruturaCapital = new IndicesEstruturaCapital();
        this.indicesLiquidez = new IndicesLiquidez();
        this.indicesRentabilidade = new IndicesRentabilidade();
        this.indicesEficienciaAtividadeOuRotatividade = new IndicesEficienciaAtividadeOuRotatividade();
        this.indicesLucratividade = new IndicesLucratividade();
    }
}
