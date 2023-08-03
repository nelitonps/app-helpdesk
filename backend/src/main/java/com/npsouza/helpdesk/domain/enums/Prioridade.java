package com.npsouza.helpdesk.domain.enums;

public enum Prioridade {
    //Indicado colocar a posição e descrição para evitar problemas se adcionar novos perfis futuros
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descrição;

    //Por ter atribuido os valores tem que criar um construtor
    Prioridade(Integer codigo, String descrição) {
        this.codigo = codigo;
        this.descrição = descrição;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public static Prioridade toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (Prioridade x : Prioridade.values()){
            if(cod == x.getCodigo()){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválido!");
    }
}
