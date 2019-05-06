package br.com.sergiogoncalves.drools.model;

import lombok.Data;

@Data
public class ModuloBaseIRPF {

    private Double valorCalculo;
    private Float aliquota;
    private Double deducao;

    public Double getValorCalculo() {
        return valorCalculo;
    }

    public void setValorCalculo(Double valorCalculo) {
        this.valorCalculo = valorCalculo;
    }

    public Float getAliquota() {
        return aliquota;
    }

    public void setAliquota(Float aliquota) {
        this.aliquota = aliquota;
    }

    public Double getDeducao() {
        return deducao;
    }

    public void setDeducao(Double deducao) {
        this.deducao = deducao;
    }
}