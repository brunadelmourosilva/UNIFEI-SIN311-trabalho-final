package br.com.unifeicontabilidade.models;

import lombok.Data;

@Data
public class DadosBalancoPatrimonial {

    // Ativo circulante
    private Double caixaInvestimentoCurtoPrazoTotal;
    private Double caixa;
    private Double caixaEquivalentesCaixa;
    private Double investimentosCurtoPrazoAC;

    private Double contasReceberLiquidoTotal;
    private Double contasReceberComercioLiquido;

    private Double inventario;

    private Double despesasAntecipadas;

    private Double outrosAtivosCirculantesTotal;

    private Double totalAtivoCirculante;

    // Ativo não circulante
    private Double imobilizadoLiquidoTotal;
    private Double imobilizadoBruto;
    private Double depreciacaoAcumulada;

    private Double agioLiquido;

    private Double intangiveisLiquido;

    private Double investimentosLongoPrazo;

    private Double realizavelLongoPrazo;

    private Double outrosAtivosLongoPrazoTotal;

    private Double outrosAtivos;

    private Double totalAtivoNaoCirculante;

    // Total Ativo
    private Double totalAtivo;

    // Passivo Circulante
    private Double aPagarAcumulado;

    private Double aRecolherAuferidos;

    private Double investimentosCurtoPrazoPC;

    private Double notasAReceberEmprestimosCurtoPrazo;

    private Double parcelaCirculanteObrigacoesArrecadamentoMercantil;

    private Double outrosPassivosCirculantes;

    private Double totalPassivoCirculante;

    // Passivo Não Circulante
    private Double endividamentoLongoPrazoTotal;
    private Double endividamentoLongoPrazo;
    private Double obrigacoesArrecadamentoMercantil;

    private Double impostoRendaDiferido;

    private Double participacaoAcionistaNaoControladores;

    private Double outrosPassivosTotal;

    private Double totalPassivoNaoCirculante;

    // Total Ativo
    private Double totalPassivo;

    // Patrimônio Líquido
    private Double acoesPreferenciaisResgataveis;

    private Double agioLiquidoPL;

    private Double acoesOrdinariasTotal;

    private Double capitalSocialIntegralizadoAdicional;

    private Double lucrosRetidosPrejuizosAcumulados;

    private Double acoesTesourariaOrdinarias;

    private Double garantiaDividaCompraAcoes;

    private Double ganhoPerdaNaoRealizado;

    private Double outrosPatrimoniosLiquidosTotal;

    // Total Patrimônio Líquido
    private Double totalPatrimonioLiquido;

    public DadosBalancoPatrimonial() {
    }
}
