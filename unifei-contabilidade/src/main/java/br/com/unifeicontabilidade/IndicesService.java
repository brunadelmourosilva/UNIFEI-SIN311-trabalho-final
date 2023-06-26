package br.com.unifeicontabilidade;

import br.com.unifeicontabilidade.dto.IndicesDto;
import br.com.unifeicontabilidade.factory.DadosPopuladosFactory;
import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;
import org.springframework.stereotype.Service;

@Service
public class IndicesService {


    public IndicesDto calculateAllIndices(String year) {
        var dadosPopulados = DadosPopuladosFactory.generateBPValuesByYear(year);

        var indicesDto = new IndicesDto();

        // Indices de estrutura de capital
        indicesDto.getIndicesEstruturaCapital().setParticipacaoDeCapitalDeTerceiros(calculatePTC(dadosPopulados));
        indicesDto.getIndicesEstruturaCapital().setComposicaoDoEndividamento(calculateEND(dadosPopulados));
        indicesDto.getIndicesEstruturaCapital().setImobilizacaoDoPatrimonioLiquido(calculateIPL(dadosPopulados));

        // Indices de liquidez
        indicesDto.getIndicesLiquidez().setLiquidezGeral(calculateLG(dadosPopulados));
        indicesDto.getIndicesLiquidez().setLiquidezCorrente(calculateLC(dadosPopulados));
        indicesDto.getIndicesLiquidez().setLiquidezSeca(calculateLS(dadosPopulados));

        // TODO RENTABILIDADE

        //TODO + 3 INDICES


        return indicesDto;
    }

    // Indices de estrutura de capital
    private Double calculatePTC(DadosBalancoPatrimonial bp) {

        return
                (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante()) / bp.getTotalPatrimonioLiquido();
    }

    private Double calculateEND(DadosBalancoPatrimonial bp) {

        return
                bp.getTotalPassivoCirculante() / (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante());
    }

    private Double calculateIPL(DadosBalancoPatrimonial bp) {

        return
                bp.getImobilizadoLiquidoTotal() / bp.getTotalPatrimonioLiquido();
    }

    private Double calculateLG(DadosBalancoPatrimonial bp) {

        return (bp.getTotalAtivoCirculante() + bp.getRealizavelLongoPrazo()) / (bp.getTotalPassivoCirculante() + bp.getTotalPassivoNaoCirculante());
    }

    private Double calculateLC(DadosBalancoPatrimonial bp) {

        return (bp.getTotalAtivoCirculante()) / (bp.getTotalPassivoCirculante());
    }

    private Double calculateLS(DadosBalancoPatrimonial bp) {
        //TODO
        return null;
    }
}
