package br.com.unifeicontabilidade.factory;

import br.com.unifeicontabilidade.models.DadosDre;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;

/**
 * https://br.investing.com/equities/acer-income-statement
 * */
public class DadosPopuladosFactory {

    private DadosPopuladosFactory(){}


    public static DadosBalancoPatrimonial generateBPValuesByYearForAcer(String year) {

        if("2022".equals(year)) {
            return generateBP2022();
        }

        if("2021".equals(year)) {
            return generateBP2021();
        }

        return new DadosBalancoPatrimonial();
    }

    public static DadosDre generateDREValuesByYearForAcer(String year) {

        if("2022".equals(year)) {
            return generateDRE2022();
        }

        if("2021".equals(year)) {
            return generateDRE2021();
        }

        return new DadosDre();
    }

    private static DadosDre generateDRE2022() {
        var dre2022 = new DadosDre();

        // Receita
        dre2022.setReceita(275423.74);
        dre2022.setOutrasReceitastTotal(0.0);
        dre2022.setCustoReceitasTotal(245679.26);

        dre2022.setLucroBruto(29744.49);

        // Receita Total
        dre2022.setReceitaTotal(275423.74);

        // Receitas Operacionais
        dre2022.setDespesasComVendasGeraisAdm(20506.02);
        dre2022.setPesquisaDesenvolvimento(2448.84);
        dre2022.setDepreciacaoAmortizacao(0.0);
        dre2022.setDespesasJuros(-222.8);
        dre2022.setDespesasExtraordinarias(0.0);
        dre2022.setOutrasDespesasOperacionaisLiquidas(84.73);

        // Total Despesas Operacionais
        dre2022.setDespesasOperacionaisTotal(268496.05);

        // Receitas Operacionais
        dre2022.setReceitasOperacionaisTotal(6927.7);

        dre2022.setReceitaJuros(0.0);
        dre2022.setGanhoVendaAtivos(-4.0);
        dre2022.setOutrosLiquidos(-942.12);
        dre2022.setLucroAntesImpostos(7873.82);
        dre2022.setProvisaoImpostoRenda(2270.53);
        dre2022.setLucroLiquidoDepoisDespesasComImposto(5603.29);
        dre2022.setParticipacaoAcionistasMinoritarios(4486.74);
        dre2022.setPatrimonioLiquidoControladoras(0.0);
        dre2022.setAjusteDeUS(0.0);

        dre2022.setLucroLiquidoAntesItensExtraordinarios(5003.69);
        dre2022.setItensExtraordinarios(0.0);

        // Lucro Líquido
        dre2022.setLucroLiquido(5003.69);

        return dre2022;
    }

    private static DadosDre generateDRE2021() {
        //// TODO: 6/28/2023 ALEX
        var dre2021 = new DadosDre();

        return dre2021;
    }

    private static DadosBalancoPatrimonial generateBP2022() {
        var bp2022 = new DadosBalancoPatrimonial();

        // Ativo circulante
        bp2022.setCaixaInvestimentoCurtoPrazoTotal(47962.73);
        bp2022.setCaixa(null);
        bp2022.setCaixaEquivalentesCaixa(46842.9);
        bp2022.setInvestimentosCurtoPrazoAC(345.88);

        bp2022.setContasReceberLiquidoTotal(55020.8);

        bp2022.setContasReceberComercioLiquido(51887.74);

        bp2022.setInventario(42344.95);

        bp2022.setDespesasAntecipadas(634.36);

        bp2022.setOutrosAtivosCirculantesTotal(694.17);

        bp2022.setTotalAtivoCirculante(146657.02);

        // Ativo não circulante
        bp2022.setImobilizadoLiquidoTotal(6268.25);
        bp2022.setImobilizadoBruto(14494.3);
        bp2022.setDepreciacaoAcumulada(-8226.05);

        bp2022.setAgioLiquido(17488.56);

        bp2022.setIntangiveisLiquido(18530.59);

        bp2022.setInvestimentosLongoPrazo(10658.94);

        bp2022.setRealizavelLongoPrazo(3133.06);

        bp2022.setOutrosAtivosLongoPrazoTotal(3219.52);

        bp2022.setOutrosAtivos(-24645.02);

        bp2022.setTotalAtivoNaoCirculante(42382.7);

        // Total Ativo
        bp2022.setTotalAtivo(189039.72);

        // Passivo Circulante
        bp2022.setAPagarAcumulado(31549.7);

        bp2022.setARecolherAuferidos(null);

        bp2022.setInvestimentosCurtoPrazoPC(232.61);

        bp2022.setNotasAReceberEmprestimosCurtoPrazo(1652.09);

        bp2022.setParcelaCirculanteObrigacoesArrecadamentoMercantil(671.28);

        bp2022.setOutrosPassivosCirculantes(65418.06);

        bp2022.setTotalPassivoCirculante(99523.73);

        // Passivo Não Circulante
        bp2022.setEndividamentoLongoPrazoTotal(11600.26);
        bp2022.setEndividamentoLongoPrazo(10104.48);
        bp2022.setObrigacoesArrecadamentoMercantil(1495.79);
        bp2022.setImpostoRendaDiferido(5025.26);
        bp2022.setParticipacaoAcionistaNaoControladores(4486.74);
        bp2022.setOutrosPassivosTotal(-5494.54);

        bp2022.setTotalPassivoNaoCirculante(19081.79);

        // Total Passivo
        bp2022.setTotalPassivo(118605.52);

        // Patrimônio Líquido
        bp2022.setAcoesPreferenciaisResgataveis(null);

        bp2022.setAgioLiquidoPL(null);

        bp2022.setAgioLiquidoPL(null);

        bp2022.setAcoesOrdinariasTotal(30478.54);

        bp2022.setCapitalSocialIntegralizadoAdicional(27795.88);

        bp2022.setLucrosRetidosPrejuizosAcumulados(14897.14);

        bp2022.setAcoesTesourariaOrdinarias(-2914.86);

        bp2022.setGarantiaDividaCompraAcoes(null);

        bp2022.setGanhoPerdaNaoRealizado(null);

        bp2022.setOutrosPatrimoniosLiquidosTotal(177.48);

        // Total Patrimônio Líquido
        bp2022.setTotalPatrimonioLiquido(70434.2);

        return bp2022;
    }

    private static DadosBalancoPatrimonial generateBP2021() {
        var bp2021 = new DadosBalancoPatrimonial();

        // TODO: 6/25/2023 ALEX

        return bp2021;
    }
}
