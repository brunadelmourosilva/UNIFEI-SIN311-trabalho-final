package br.com.unifeicontabilidade.services;

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
        indicesDto.getIndicesRentabilidade().setMargemLiquida(calculateML(dadosPopuladosDRE));
        indicesDto.getIndicesRentabilidade().setRentabilidadeDoAtivo(calculateRA(dadosPopuladosBP, dadosPopuladosDRE));
        indicesDto.getIndicesRentabilidade().setRentabilidadeDoPatrimonioLiquido(calculateRPL(dadosPopuladosDRE));

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

        return bp.getTotalAtivoCirculante() / bp.getTotalPassivoCirculante();
    }

    private Double calculateLS(DadosBalancoPatrimonial bp) {
        var disponivel = bp.getCaixaInvestimentoCurtoPrazoTotal() + bp.getContasReceberLiquidoTotal();

        return disponivel / bp.getTotalPassivoCirculante();
    }

    private Double calculateGA(DadosBalancoPatrimonial bp, DadosDre dre) {
        return dre.getReceitaTotal() / bp.getTotalAtivo();
    }

    private Double calculateML(DadosDre dre) {
        return dre.getLucroLiquido() / dre.getReceitaTotal();
    }

    private Double calculateRA(DadosBalancoPatrimonial bp, DadosDre dre) {
        return dre.getLucroLiquido() / bp.getTotalAtivo();
    }

    private Double calculateRPL(DadosDre dre) {
        var pl2022 = DadosPopuladosFactory.generateBPValuesByYearForAcer("2022");
        var pl2021 = DadosPopuladosFactory.generateBPValuesByYearForAcer("2021");

        var plMedio2021E2022 = (pl2022.getTotalPatrimonioLiquido() + pl2021.getTotalPatrimonioLiquido()) / 2;

        return dre.getLucroLiquido() / plMedio2021E2022;
    }

    private Double calculateMB(DadosDre dre) {
        return dre.getLucroBruto() / dre.getReceitaTotal();
    }

    //// TODO: 6/28/2023 dúvida prof - lucro operacional
    private Double calculateMO(DadosDre dre) {

        return dre.getReceitasOperacionaisTotal() / dre.getReceitaTotal();
    }

    // // TODO: 6/28/2023 livro: página 121 - como calcular o EBITDA
    //// TODO: 6/28/2023 dúvida prof
    private Double calculateMargemEbitda(DadosBalancoPatrimonial bp, DadosDre dre) {
        //// TODO: 6/29/2023 alex
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