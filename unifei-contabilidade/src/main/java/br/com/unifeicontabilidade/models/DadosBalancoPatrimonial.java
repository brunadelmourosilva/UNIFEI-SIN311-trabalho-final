package br.com.unifeicontabilidade.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosBalancoPatrimonial {

    // Ativo circulante
    private BigDecimal caixaInvestimentoCurtoPrazoTotal;
    private BigDecimal caixa;
    private BigDecimal caixaEquivalentesCaixa;
    private BigDecimal investimentosCurtoPrazoAC;

    private BigDecimal contasReceberLiquidoTotal;
    private BigDecimal contasReceberComercioLiquido;

    private BigDecimal inventario;

    private BigDecimal despesasAntecipadas;

    private BigDecimal outrosAtivosCirculantesTotal;

    private BigDecimal totalAtivoCirculante;

    // Ativo não circulante
    private BigDecimal imobilizadoLiquidoTotal;
    private BigDecimal imobilizadoBruto;
    private BigDecimal depreciacaoAcumulada;

    private BigDecimal agioLiquido;

    private BigDecimal intangiveisLiquido;

    private BigDecimal investimentosLongoPrazo;

    private BigDecimal realizavelLongoPrazo;

    private BigDecimal outrosAtivosLongoPrazoTotal;

    private BigDecimal outrosAtivos;

    private BigDecimal totalAtivoNaoCirculante;

    // Total Ativo
    private BigDecimal totalAtivo;

    // Passivo Circulante
    private BigDecimal aPagarAcumulado;

    private BigDecimal aRecolherAuferidos;

    private BigDecimal investimentosCurtoPrazoPC;

    private BigDecimal notasAReceberEmprestimosCurtoPrazo;

    private BigDecimal parcelaCirculanteObrigacoesArrecadamentoMercantil;

    private BigDecimal outrosPassivosCirculantes;

    private BigDecimal totalPassivoCirculante;

    // Passivo Não Circulante
    private BigDecimal endividamentoLongoPrazoTotal;
    private BigDecimal endividamentoLongoPrazo;
    private BigDecimal obrigacoesArrecadamentoMercantil;

    private BigDecimal impostoRendaDiferido;

    private BigDecimal participacaoAcionistaNaoControladores;

    private BigDecimal outrosPassivosTotal;

    private BigDecimal totalPassivoNaoCirculante;

    // Total Ativo
    private BigDecimal totalPassivo;

    // Patrimônio Líquido
    private BigDecimal acoesPreferenciaisResgataveis;

    private BigDecimal agioLiquidoPL;

    private BigDecimal acoesOrdinariasTotal;

    private BigDecimal capitalSocialIntegralizadoAdicional;

    private BigDecimal lucrosRetidosPrejuizosAcumulados;

    private BigDecimal acoesTesourariaOrdinarias;

    private BigDecimal garantiaDividaCompraAcoes;

    private BigDecimal ganhoPerdaNaoRealizado;

    private BigDecimal outrosPatrimoniosLiquidosTotal;

    // Total Patrimônio Líquido
    private BigDecimal totalPatrimonioLiquido;

    public DadosBalancoPatrimonial() {
    }
}
