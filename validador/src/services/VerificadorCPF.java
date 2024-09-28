package services;


public final class VerificadorCPF implements IvalidadorDeCPF{

    @Override
    public Boolean verificadorDeTamanho(String codigo){
        return codigo.length() == 11;
    }

    @Override
    public String removedorDeCaracteresEspeciais(String codigo) {
        return codigo.replaceAll("[^a-zA-Z0-9]", "");
    }

    @Override
    public Boolean verificadorDeLetras(String codigo) {
        for(int i = 0; i < codigo.length(); i++){
            if(codigo.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean verificadorMatematico(String codigo) {
        double somaDigito1 = 0.0;
        double somaDigito2 = 0.0;

        boolean verificador = false;

        for (int i = 0; i < 10; i++) {
            if(i < 9){
                int numeralDoCodigo = codigo.charAt(i) - '0';
                somaDigito1 += numeralDoCodigo * (10 - i);
            }

            int numeralDoCodigo = codigo.charAt(i) - '0';
            somaDigito2 += numeralDoCodigo * (11 - i);
        }

        somaDigito1 = (somaDigito1 * 10) % 11;
        somaDigito2 = (somaDigito2 * 10) % 11;


        if(somaDigito1 == 10.0 ){
            somaDigito1 = 0.0;
        }

        if(somaDigito2 == 10.0 ){
            somaDigito2 = 0.0;
        }

        if(somaDigito1 == codigo.charAt(9) - '0' && somaDigito2 == codigo.charAt(10) - '0'){
            verificador = true;
        }

        return verificador;
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


            for (String s : blacklist) {
                if (s.equals(codigo)) {
                    return false;
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
        return (codigo.charAt(3) >= '0' && codigo.charAt(3) <= '9') &&
                (codigo.charAt(6) >= '0' && codigo.charAt(7) <= '9') &&
                (codigo.charAt(9) >= '0' && codigo.charAt(9) <= '9');
    }
}