package services;

import java.util.List;

import entities.CPF;

public class verificadorCPF implements IvalidadorDeCPF{

    @Override
    public Boolean verificadorDeTamanho(String codigo){
        if(codigo.length() == 11){
            return true;
        }
        else
            return false;
        
    }

    @Override
    public String removedorDeCaracteresEspeciais(String codigo) {
        codigo.replaceAll("[^a-zA-Z0-9]", "");

        return codigo;
    }

    @Override
    public Boolean verificadorDeLetras(String codigo) {
        Boolean letrasNoCpf = false;
        for(int i = 0; i < codigo.length(); i++){
            if(codigo.charAt(i) > '9'){
                letrasNoCpf = false;
                break;
            }
            else{
                letrasNoCpf = true;
            }
        }
        return letrasNoCpf;
    }

    @Override
    public void imprimirCPFValidos(List<CPF> listaCPFs) {
        System.out.println("CPFs validos: ");
        for (CPF cpf : listaCPFs) {
            System.out.println(cpf.toString());
        }
    }

    @Override
    public void imprimirCPFInvalidos(List<CPF> listaCPFs) {
        System.out.println("CPFs invalidos: ");

        for (CPF cpf : listaCPFs) {
            System.out.println(cpf.toString());
        }
    }
    
}

