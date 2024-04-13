package services;


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
        codigo = codigo.replaceAll("[^a-zA-Z0-9]", "");

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
    public Boolean verificadorMatematico(String codigo) {
        Double soma = 0.0;

        Boolean primeiroVerificador = false, segundoVerificador = false;

            for (int i = 0; i < 9; i++) {
                Integer numeralDoCodigo = codigo.charAt(i) - '0';
                soma += numeralDoCodigo * (10 - i);
            }


        Double restoDaDivisao = (soma * 10) % 11;

        if(restoDaDivisao == 10.0){
            restoDaDivisao = 0.0;
        }

        if(restoDaDivisao == codigo.charAt(9) - '0'){
            primeiroVerificador = true;
        }



        soma = 0.0;

        for (int i = 0; i < 10; i++) {
            Integer numeralDoCodigo = codigo.charAt(i) - '0';
            soma += numeralDoCodigo * (11 - i);
            
        }


        restoDaDivisao = 0.0;

        restoDaDivisao = (soma * 10) % 11;

        if(restoDaDivisao == 10.0){
            restoDaDivisao = 0.0;
        }

        if(restoDaDivisao == codigo.charAt(10) - '0'){
            segundoVerificador = true;
        }


        if(primeiroVerificador && segundoVerificador){
            return true;
        }
        
        else{
            return false;
        }

            
        
    }

    @Override
    public Boolean verificadorBlacklist(String codigo) {
        try {
            String linha;

            String[] blacklist =
             {"11111111111",
            "22222222222",
            "33333333333",
            "44444444444",
            "55555555555",
            "66666666666",
            "77777777777",
            "88888888888",
            "99999999999",
            "00000000000"};

                
                for (int i = 0; i < blacklist.length; i++) {
                    linha = blacklist[i];
                    if(linha != null){
                        if(linha.equals(codigo)){
                            return false;
                        }
                    }
                }

            return true;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

            throw new NullPointerException();
        }

        
    }

    @Override
    public Boolean verificaPontos(String codigo) {
        if(codigo.charAt(3) == '.' && codigo.charAt(7) == '.' && codigo.charAt(11) == '-'){
            return true;
        }

        if((codigo.charAt(3) > '0' && codigo.charAt(3) < '9') && 
        (codigo.charAt(6) > '0' && codigo.charAt(7) < '9') &&
        (codigo.charAt(9) > '0' && codigo.charAt(9) < '9')){
            return true;
        }

        return false;
    }
    
}

