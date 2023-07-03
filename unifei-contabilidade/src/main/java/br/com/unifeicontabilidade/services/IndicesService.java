package br.com.unifeicontabilidade.services;

import br.com.unifeicontabilidade.dto.Indices;
import br.com.unifeicontabilidade.factory.DadosPopuladosFactory;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;
import br.com.unifeicontabilidade.models.DadosDre;
import org.springframework.stereotype.Service;

/**
 * referências para os cálculos
   https://plataforma.bvirtual.com.br/Acervo/Publicacao/1799
 **/
@Service
public class IndicesService {


    public Indices calculateAllIndices(String year) {
        var dadosPopuladosBP = DadosPopuladosFactory.generateBPValuesByYearForAcer(year);
        var dadosPopuladosDRE = DadosPopuladosFactory.generateDREValuesByYearForAcer(year);

        var indicesDto = new Indices();

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

        // Indices de eficiência, atividade ou rotatividade
        // Mostram quanto tempo uma empresa leva, em média, para receber o dinheiro oriundo de suas vendas,
        // para pagar seus fornecedores e para vender seus estoques.

        //A função principal do índice de giro de contas a receber é avaliar a eficiência e a gestão do ciclo de
        // recebimento da empresa. Ao acompanhar esse indicador ao longo do tempo, é possível identificar se a
        // empresa está tendo sucesso na cobrança de seus clientes e se está otimizando o prazo médio de recebimento.
        // Um giro de contas a receber alto indica que a empresa está recebendo os valores devidos mais rapidamente,
        // o que é positivo, pois reduz o risco de inadimplência e permite que a empresa utilize esses recursos para
        // suas atividades operacionais ou investimentos. Por outro lado, um giro de contas a receber baixo pode
        // indicar que a empresa enfrenta dificuldades na cobrança de valores em tempo hábil ou pode estar
        // concedendo prazos de pagamento muito longos aos clientes.
        indicesDto.getIndicesEficienciaAtividadeOuRotatividade().setGiroDoContasAReceber(calculateGiroContasAReceber(dadosPopuladosBP, dadosPopuladosDRE));

        // Indices de lucratividade
        // Mostram o lucro auferido pela empresa em relação aos recursos obtidos pelas vendas em um determinado
        // periodo de tempo.

        // Essa margem revela o quanto a empresa lucrou na operação em relação às vendas líquidas mensurando sua
        // eficiência no processo de produção. - MARGEM DE FÁBRICA
        indicesDto.getIndicesLucratividade().setMargemBruta(calculateMB(dadosPopuladosDRE));

        // Essa margem mostra, após deduzir as despesas operacionais, quanto a empresa obteve de resultado em
        // relação às vendas. - MARGEM DE OPERAÇÃO
        indicesDto.getIndicesLucratividade().setMargemOperacional(calculateMO(dadosPopuladosDRE));

        // Essa margem mostra quanto da receita líquida de uma empresa é gerada como lucro operacional.
        // Quanto maior a margem EBITDA, melhor, pois indica que a empresa está conseguindo transformar
        // uma maior parcela de sua receita líquida em lucro operacional.
        indicesDto.getIndicesLucratividade().setMargemEbitda(calculateMargemEbitda(dadosPopuladosBP, dadosPopuladosDRE));

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

    private Double calculateGiroContasAReceber(DadosBalancoPatrimonial bp, DadosDre dre) {

        return dre.getReceitaTotal() / bp.getContasReceberLiquidoTotal();
    }

    private Double calculateMB(DadosDre dre) {

        return dre.getLucroBruto() / dre.getReceitaTotal();
    }

    private Double calculateMO(DadosDre dre) {
        var lucroOperacional = -(dre.getReceitaTotal() - dre.getCustoReceitasTotal() - dre.getDespesasOperacionaisTotal());

        return lucroOperacional / dre.getReceitaTotal();
    }

    private Double calculateMargemEbitda(DadosBalancoPatrimonial bp, DadosDre dre) {
        var lucroOperacional = -(dre.getReceitaTotal() - dre.getCustoReceitasTotal() - dre.getDespesasOperacionaisTotal());

        var ebitda =
                lucroOperacional +
                bp.getDepreciacaoAcumulada() +
                dre.getDepreciacaoAmortizacao();

        return ebitda / dre.getReceitaTotal();
    }
}