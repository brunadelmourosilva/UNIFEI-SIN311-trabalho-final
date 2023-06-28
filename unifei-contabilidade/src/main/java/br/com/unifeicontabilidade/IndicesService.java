package br.com.unifeicontabilidade;

import br.com.unifeicontabilidade.dto.IndicesDto;
import br.com.unifeicontabilidade.factory.DadosPopuladosFactory;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;
import br.com.unifeicontabilidade.models.DadosDre;
import org.springframework.stereotype.Service;

@Service
public class IndicesService {


    public IndicesDto calculateAllIndices(String year) {
        var dadosPopuladosBP = DadosPopuladosFactory.generateBPValuesByYear(year);
        var dadosPopuladosDRE = DadosPopuladosFactory.generateDREValuesByYear(year);

        var indicesDto = new IndicesDto();

        // Indices de estrutura de capital
        indicesDto.getIndicesEstruturaCapital().setParticipacaoDeCapitalDeTerceiros(calculatePTC(dadosPopuladosBP));
        indicesDto.getIndicesEstruturaCapital().setComposicaoDoEndividamento(calculateEND(dadosPopuladosBP));
        indicesDto.getIndicesEstruturaCapital().setImobilizacaoDoPatrimonioLiquido(calculateIPL(dadosPopuladosBP));

        // Indices de liquidez
        indicesDto.getIndicesLiquidez().setLiquidezGeral(calculateLG(dadosPopuladosBP));
        indicesDto.getIndicesLiquidez().setLiquidezCorrente(calculateLC(dadosPopuladosBP));
        indicesDto.getIndicesLiquidez().setLiquidezSeca(calculateLS(dadosPopuladosBP));

        // Indices de rentabilidade
        indicesDto.getIndicesRentabilidade().setGiroDoAtivo(calculateGA(dadosPopuladosBP, dadosPopuladosDRE));
        indicesDto.getIndicesRentabilidade().setMargemLiquida(calculateML(dadosPopuladosBP, dadosPopuladosDRE));
        indicesDto.getIndicesRentabilidade().setRentabilidadeDoAtivo(calculateRA(dadosPopuladosBP, dadosPopuladosDRE));
        indicesDto.getIndicesRentabilidade().setRentabilidadeDoPatrimonioLiquido(calculateRPL(dadosPopuladosBP, dadosPopuladosDRE));


        //TODO + 3 INDICES


        return indicesDto;
    }

    // Indices de estrutura de capital
    private Double calculatePTC(DadosBalancoPatrimonial bp) {

        return
                (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante()) / bp.getTotalPatrimonioLiquido();
    }

    private Double calculateEND(DadosBalancoPatrimonial bp) {

        return
                bp.getTotalPassivoCirculante() / (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante());
    }

    private Double calculateIPL(DadosBalancoPatrimonial bp) {

        return
                bp.getImobilizadoLiquidoTotal() / bp.getTotalPatrimonioLiquido();
    }

    private Double calculateLG(DadosBalancoPatrimonial bp) {

        return (bp.getTotalAtivoCirculante() + bp.getRealizavelLongoPrazo()) / (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante());
    }

    private Double calculateLC(DadosBalancoPatrimonial bp) {

        return (bp.getTotalAtivoCirculante()) / (bp.getTotalPassivoCirculante());
    }

    private Double calculateLS(DadosBalancoPatrimonial bp) {
        //TODO ALEX
        return null;
    }

    private Double calculateGA(DadosBalancoPatrimonial bp, DadosDre dre) {
        return dre.getReceitaTotal() / bp.getTotalAtivo();
    }

    private Double calculateML(DadosBalancoPatrimonial bp, DadosDre dre) {
        return dre.getLucroLiquido() / dre.getReceitaTotal();
    }

    private Double calculateRA(DadosBalancoPatrimonial bp, DadosDre dre) {
        return dre.getLucroLiquido() / bp.getTotalAtivo();
    }

    private Double calculateRPL(DadosBalancoPatrimonial bp, DadosDre dre) {
        //// TODO ALEX
        //return dre.getLucroLiquido() / MEDIA PL;
        return null;
    }
}
