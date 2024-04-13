package services;


public interface IvalidadorDeCPF {
    public Boolean verificadorDeTamanho(String codigo);
    public String removedorDeCaracteresEspeciais(String codigo);
    public Boolean verificadorDeLetras(String codigo);
    public Boolean verificadorMatematico(String codigo);
    public Boolean verificadorBlacklist(String codigo);
    public Boolean verificaPontos(String codigo);
}
