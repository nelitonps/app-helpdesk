package com.npsouza.helpdesk.domain.enums;

public enum Perfil {
    //Indicado colocar a posição e descrição para evitar problemas se adcionar novos perfis futuros
    ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");

    private Integer codigo;
    private String descrição;

    //Por ter atribuido os valores tem que criar um construtor
    Perfil(Integer codigo, String descrição) {
        this.codigo = codigo;
        this.descrição = descrição;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (Perfil x : Perfil.values()){
            if(cod == x.getCodigo()){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido!");
    }
}
