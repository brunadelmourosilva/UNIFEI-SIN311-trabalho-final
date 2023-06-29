package br.com.unifeicontabilidade;

import br.com.unifeicontabilidade.dto.IndicesDto;
import br.com.unifeicontabilidade.factory.DadosPopuladosFactory;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;
import br.com.unifeicontabilidade.models.DadosDre;
import org.springframework.stereotype.Service;

@Service
public class IndicesService {


    public IndicesDto calculateAllIndices(String year) {
        var dadosPopuladosBP = DadosPopuladosFactory.generateBPValuesByYearForAcer(year);
        var dadosPopuladosDRE = DadosPopuladosFactory.generateDREValuesByYearForAcer(year);

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

        // Indices de lucratividade
        indicesDto.getIndicesLucratividade().setMargemBruta(calculateMB(dadosPopuladosDRE));
        indicesDto.getIndicesLucratividade().setMargemOperacional(calculateMO(dadosPopuladosDRE));
        indicesDto.getIndicesLucratividade().setMargemEbitda(calculateMargemEbitda(dadosPopuladosBP, dadosPopuladosDRE));

        // Indices de endividamento

        return indicesDto;
    }

    private Double calculatePTC(DadosBalancoPatrimonial bp) {

        return (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante()) / bp.getTotalPatrimonioLiquido();
    }

    private Double calculateEND(DadosBalancoPatrimonial bp) {

        return bp.getTotalPassivoCirculante() / (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante());
    }

    private Double calculateIPL(DadosBalancoPatrimonial bp) {

        return bp.getImobilizadoLiquidoTotal() / bp.getTotalPatrimonioLiquido();
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

    private Double calculateMB(DadosDre dre) {
        return dre.getLucroBruto() / dre.getReceitaTotal();
    }

    //// TODO: 6/28/2023 dúvida prof
    private Double calculateMO(DadosDre dre) {

        return dre.getReceitasOperacionaisTotal() / dre.getReceitaTotal();
    }

    // // TODO: 6/28/2023 livro: página 121 - como calcular o EBITDA
    //// TODO: 6/28/2023 dúvida prof
    private Double calculateMargemEbitda(DadosBalancoPatrimonial bp, DadosDre dre) {
        var ebitda =
                dre.getReceitasOperacionaisTotal() +
                dre.getDespesasOperacionaisTotal() +
                bp.getAgioLiquido();

        return ebitda / dre.getReceitaTotal();
    }
}

//// TODO: 6/28/2023
//referencias para a doc
//https://plataforma.bvirtual.com.br/Acervo/Publicacao/1799