package services;



public class verificadorCPF implements IvalidadorDeCPF{

    @Override
    public Boolean verificadorDeTamanho(String codigo){
        if(codigo.length() == 11){
            System.out.println("Tamanho correto!");
            return true;
        }
        else
            return false;
        
    }
    
}

