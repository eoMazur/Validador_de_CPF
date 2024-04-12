package services;

import java.util.List;

import entities.CPF;

public interface IvalidadorDeCPF {
    public Boolean verificadorDeTamanho(String codigo);
    public String removedorDeCaracteresEspeciais(String codigo);
    public Boolean verificadorDeLetras(String codigo);
    public void imprimirCPFValidos(List<CPF> listaCPFs);
    public void imprimirCPFInvalidos(List<CPF> listaCPFs);
    public Boolean verificadorMatematico(String codigo);
    public Boolean verificadorBlacklist(String codigo);
    public Boolean verificaPontos(String codigo);
}
