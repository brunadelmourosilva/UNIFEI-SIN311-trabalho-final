package br.com.unifeicontabilidade.factory;

import br.com.unifeicontabilidade.models.DadosDre;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;

/** References
 * https://br.investing.com/equities/acer-balance-sheet
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
        var dre2021 = new DadosDre();

        // Receita
        dre2021.setReceita(319005.46);
        dre2021.setOutrasReceitastTotal(0.0);
        dre2021.setCustoReceitasTotal(281814.4);

        dre2021.setLucroBruto(37191.069);

        // Receita Total
        dre2021.setReceitaTotal(319005.46);

        // Receitas Operacionais
        dre2021.setDespesasComVendasGeraisAdm(20494.3);
        dre2021.setPesquisaDesenvolvimento(2646.1);
        dre2021.setDepreciacaoAmortizacao(0.0);
        dre2021.setDespesasJuros(-336.68);
        dre2021.setDespesasExtraordinarias(-3.07);
        dre2021.setOutrasDespesasOperacionaisLiquidas(224.4);

        // Total Despesas Operacionais
        dre2021.setDespesasOperacionaisTotal(304842.6);

        // Receitas Operacionais
        dre2021.setReceitasOperacionaisTotal(14162.86);

        dre2021.setReceitaJuros(1198.46);
        dre2021.setGanhoVendaAtivos(43.77);
        dre2021.setOutrosLiquidos(-1316.56);
        dre2021.setLucroAntesImpostos(15435.64);
        dre2021.setProvisaoImpostoRenda(4148.33);
        dre2021.setLucroLiquidoDepoisDespesasComImposto(11287.31);
        dre2021.setParticipacaoAcionistasMinoritarios(2346.23);
        dre2021.setPatrimonioLiquidoControladoras(0.0);
        dre2021.setAjusteDeUS(0.0);

        dre2021.setLucroLiquidoAntesItensExtraordinarios(10897.43);
        dre2021.setItensExtraordinarios(0.0);

        // Lucro Líquido
        dre2021.setLucroLiquido(10897.43);

        return dre2021;
    }

    private static DadosBalancoPatrimonial generateBP2022() {
        var bp2022 = new DadosBalancoPatrimonial();

        // Ativo circulante
        bp2022.setCaixaInvestimentoCurtoPrazoTotal(47962.73);
        bp2022.setCaixa(0.0);
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

        bp2022.setARecolherAuferidos(0.0);

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
        bp2022.setAcoesPreferenciaisResgataveis(0.0);

        bp2022.setAgioLiquidoPL(0.0);

        bp2022.setAcoesOrdinariasTotal(30478.54);

        bp2022.setCapitalSocialIntegralizadoAdicional(27795.88);

        bp2022.setLucrosRetidosPrejuizosAcumulados(14897.14);

        bp2022.setAcoesTesourariaOrdinarias(-2914.86);

        bp2022.setGarantiaDividaCompraAcoes(0.0);

        bp2022.setGanhoPerdaNaoRealizado(0.0);

        bp2022.setOutrosPatrimoniosLiquidosTotal(177.48);

        // Total Patrimônio Líquido
        bp2022.setTotalPatrimonioLiquido(70434.2);

        return bp2022;
    }

    private static DadosBalancoPatrimonial generateBP2021() {
        var bp2021 = new DadosBalancoPatrimonial();

        // Ativo circulante
        bp2021.setCaixaInvestimentoCurtoPrazoTotal(47242.28);
        bp2021.setCaixa(36355.86);
        bp2021.setCaixaEquivalentesCaixa(44619.54);
        bp2021.setInvestimentosCurtoPrazoAC(80.0);

        bp2021.setContasReceberLiquidoTotal(67346.32);

        bp2021.setContasReceberComercioLiquido(64492.12);

        bp2021.setInventario(58967.84);

        bp2021.setDespesasAntecipadas(494.0);

        bp2021.setOutrosAtivosCirculantesTotal(1044.79);

        bp2021.setTotalAtivoCirculante(175095.24);

        // Ativo não circulante
        bp2021.setImobilizadoLiquidoTotal(5792.51);
        bp2021.setImobilizadoBruto(13429.54);
        bp2021.setDepreciacaoAcumulada(-7637.03);

        bp2021.setAgioLiquido(15816.97);

        bp2021.setIntangiveisLiquido(16527.28);

        bp2021.setInvestimentosLongoPrazo(9938.99);

        bp2021.setRealizavelLongoPrazo(2854.2);

        bp2021.setOutrosAtivosLongoPrazoTotal(3762.66);

        bp2021.setOutrosAtivos(-16856.28);

        bp2021.setTotalAtivoNaoCirculante(39693.07);

        // Total Ativo
        bp2021.setTotalAtivo(214788.31);

        // Passivo Circulante
        bp2021.setAPagarAcumulado(57897.7);

        bp2021.setARecolherAuferidos(0.0);

        bp2021.setInvestimentosCurtoPrazoPC(237.57);

        bp2021.setNotasAReceberEmprestimosCurtoPrazo(237.57);

        bp2021.setParcelaCirculanteObrigacoesArrecadamentoMercantil(550.67);

        bp2021.setOutrosPassivosCirculantes(69483.52);

        bp2021.setTotalPassivoCirculante(129423.06);

        // Passivo Não Circulante
        bp2021.setEndividamentoLongoPrazoTotal(11420.53);
        bp2021.setEndividamentoLongoPrazo(10099.82);
        bp2021.setObrigacoesArrecadamentoMercantil(1320.71);
        bp2021.setImpostoRendaDiferido(4643.83);
        bp2021.setParticipacaoAcionistaNaoControladores(2346.23);
        bp2021.setOutrosPassivosTotal(-1595.39);

        bp2021.setTotalPassivoNaoCirculante(19333.31);

        // Total Passivo
        bp2021.setTotalPassivo(148765.37);

        // Patrimônio Líquido
        bp2021.setAcoesPreferenciaisResgataveis(0.0);

        bp2021.setAgioLiquidoPL(0.0);

        bp2021.setAcoesOrdinariasTotal(30478.54);

        bp2021.setCapitalSocialIntegralizadoAdicional(30478.54);

        bp2021.setLucrosRetidosPrejuizosAcumulados(16886.39);

        bp2021.setAcoesTesourariaOrdinarias(-2914.86);

        bp2021.setGarantiaDividaCompraAcoes(0.0);

        bp2021.setGanhoPerdaNaoRealizado(746.18);

        bp2021.setOutrosPatrimoniosLiquidosTotal(-5941.4);

        // Total Patrimônio Líquido
        bp2021.setTotalPatrimonioLiquido(66022.94);

        return bp2021;
    }
}
