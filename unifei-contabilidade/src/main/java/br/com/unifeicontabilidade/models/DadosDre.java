package br.com.unifeicontabilidade.models;

import lombok.Data;

@Data
public class DadosDre {

    // Receita
    private Double receita;
    private Double outrasReceitastTotal;
    private Double custoReceitasTotal;

    private Double lucroBruto;

    // Receita Total
    private Double receitaTotal;

    // Receitas Operacionais
    private Double despesasComVendasGeraisAdm;

    private Double pesquisaDesenvolvimento;

    private Double depreciacaoAmortizacao;

    private Double despesasJuros;

    private Double despesasExtraordinarias;

    private Double outrasDespesasOperacionaisLiquidas;

    // Total Despesas Operacionais
    private Double despesasOperacionaisTotal;

    // Receitas Operacionais
    private Double receitasOperacionaisTotal;

    private Double receitaJuros;

    private Double ganhoVendaAtivos;

    private Double outrosLiquidos;

    private Double lucroAntesImpostos;

    private Double provisaoImpostoRenda;

    private Double lucroLiquidoDepoisDespesasComImposto;

    private Double participacaoAcionistasMinoritarios;

    private Double patrimonioLiquidoControladoras;

    private Double ajusteDeUS;

    private Double lucroLiquidoAntesItensExtraordinarios;

    private Double itensExtraordinarios;

    // Lucro Líquido
    private Double lucroLiquido;
}
