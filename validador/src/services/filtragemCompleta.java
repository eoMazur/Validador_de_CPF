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

       // metodoDeValidacao.verificadorDeTamanho();
        //metodoDeValidacao.verificadorDeCaracteresEspeciais();
        //metodoDeValidacao.verificadorDeLetras();


        for (String codigos : codigosSemVerificacao) {
            codigos = codigos.trim();

            //String codigosSemCaracteres = metodoDeValidacao.removedorDeCaracteresEspeciais(codigos);
            String codigosSemCaracteres = codigos.replaceAll("[^a-zA-Z0-9]", "");
            //letrasNoCpf = metodoDeValidacao.verificadorDeLetras(codigosSemCaracteres);
            
            if(metodoDeValidacao.verificadorDeTamanho(codigosSemCaracteres) && metodoDeValidacao.verificadorDeLetras(codigosSemCaracteres)){
                listaCPFValidos.add(new CPF(codigos));
            }

            else{
                listaCPFInvalidos.add(new CPF(codigos));
            }
            
        }
    }

    public void imprimirListas(){
        metodoDeValidacao.imprimirCPFValidos(listaCPFValidos);
        metodoDeValidacao.imprimirCPFInvalidos(listaCPFInvalidos);
    }



}
