package com.example.jv_an.filmes;

public class Filme {

    private String lancamento;
    private String name;
    private String diretor;
    private String genero;
    private String distribuicao;


    public Filme(String lancamento, String name, String diretor, String genero, String distribuicao) {
        this.lancamento = lancamento;
        this.name = name;
        this.diretor = diretor;
        this.genero = genero;
        this.distribuicao = distribuicao;
    }


    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(String distribuicao) {
        this.distribuicao = distribuicao;
    }


}
