package br.com.unifeicontabilidade.models;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class BalancoPatrimonial {

    @CsvBindByName(column = "ano_dois")
    private BigDecimal totalAtivoCirculante2022;

    @CsvBindByName(column = "ano_um")
    private BigDecimal totalAtivoCirculante2021;

    public BalancoPatrimonial() {
    }

    public BigDecimal getTotalAtivoCirculante2022() {
        return totalAtivoCirculante2022;
    }

    public void setTotalAtivoCirculante2022(BigDecimal totalAtivoCirculante2022) {
        this.totalAtivoCirculante2022 = totalAtivoCirculante2022;
    }

    public BigDecimal getTotalAtivoCirculante2021() {
        return totalAtivoCirculante2021;
    }

    public void setTotalAtivoCirculante2021(BigDecimal totalAtivoCirculante2021) {
        this.totalAtivoCirculante2021 = totalAtivoCirculante2021;
    }
}
