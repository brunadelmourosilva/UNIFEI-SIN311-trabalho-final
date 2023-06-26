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

    //// TODO: 6/26/2023 Receitas Operacionais
}
