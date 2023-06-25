package br.com.unifeicontabilidade.factory;

import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;

public class DadosPopuladosFactory {

    private DadosPopuladosFactory(){}


    public static DadosBalancoPatrimonial generateBPValuesByYear(String year) {

        if("2022".equals(year)) {
            return generateBP2022();
        }

        if("2021".equals(year)) {
            return generateBP2021();
        }

        return new DadosBalancoPatrimonial();
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
        // TODO: 6/25/2023 TERMINAR

        return bp2022;
    }

    private static DadosBalancoPatrimonial generateBP2021() {
        var bp2021 = new DadosBalancoPatrimonial();

        // TODO: 6/25/2023 TERMINAR

        return bp2021;
    }
}
