package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entities.CPF;

public class filtragemCompleta {
    private Set<String> codigosSemVerificacao;
    private List<CPF> listaCPFValidos;
    private List<CPF> listaCPFInvalidos;
    private IvalidadorDeCPF metodoDeValidacao;


    public filtragemCompleta(IvalidadorDeCPF metodoDeValidacao, Set<String> set) {

        this.metodoDeValidacao = metodoDeValidacao;
        this.codigosSemVerificacao = set;

        listaCPFInvalidos = new ArrayList<>();
        listaCPFValidos = new ArrayList<>();

        
        rodarMetodos();
    }

    public void rodarMetodos(){

        for (String codigos : codigosSemVerificacao) {
            codigos = codigos.trim();

            String codigosSemCaracteres = metodoDeValidacao.removedorDeCaracteresEspeciais(codigos);
            
            if(metodoDeValidacao.verificadorDeTamanho(codigosSemCaracteres) && metodoDeValidacao.verificadorDeLetras(codigosSemCaracteres) && metodoDeValidacao.verificaPontos(codigos)){
                if(metodoDeValidacao.verificadorMatematico(codigosSemCaracteres) && metodoDeValidacao.verificadorBlacklist(codigosSemCaracteres)){
                    listaCPFValidos.add(new CPF(codigos));
                }

                else{
                    listaCPFInvalidos.add(new CPF(codigos));
                }
                
            }

            else{
                listaCPFInvalidos.add(new CPF(codigos));
            }
        }
        codigosSemVerificacao.clear();
        
    }

    public void imprimirListas(){
        imprimirCPFValidos();
        imprimirCPFInvalidos();
    }

    public void imprimirCPFValidos() {
        System.out.println("CPFs validos: ");
        for (CPF cpf : listaCPFValidos) {
            System.out.println(cpf.toString() + " " + encontraRegiao(cpf));

        }
    }

    public void imprimirCPFInvalidos() {
        System.out.println("CPFs invalidos: ");

        for (CPF cpf : listaCPFInvalidos) {
            System.out.println(cpf.toString());
        }
    }

    public String encontraRegiao(CPF cpf){
        Integer indexPadrao = 8;
        if(cpf.getCpf().charAt(3) == '.' && cpf.getCpf().charAt(7) == '.' && cpf.getCpf().charAt(11) == '-'){
            indexPadrao = 10;
        }
        
            if(cpf.getCpf().charAt(indexPadrao) == '1'){
                return "DF, GO, MS, MT e TO";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '2'){
                return "AC, AM, AP, PA, RO e RR";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '3'){
                return "CE, MA e PI";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '4'){
                return "AL, PB, PE, RN";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '5'){
                return "BA e SE";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '6'){
                return "MG";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '7'){
                return "ES e RJ";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '8'){
                return "SP";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '9'){
                return "PR e SC";
            }
    
            else if(cpf.getCpf().charAt(indexPadrao) == '0'){
                return "RS";
            }
        

        return "Região não encontrada.";

    }



}
