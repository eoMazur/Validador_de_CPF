package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.CPF;
import services.verificadorCPF;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        verificadorCPF verificador = new verificadorCPF();


       try {

        List<String> listaCodigos = new ArrayList<>();
        String codigoString;
        Integer repetir;
        do {
            sc.nextLine();
            System.out.print("Informe o cpf: ");
            codigoString = sc.nextLine();
            listaCodigos.add(codigoString);

            sc.nextLine();

            System.out.print("Informar outro valor? (1/0)");
            repetir = sc.nextInt();

           
        } while (repetir == 1);


        List<CPF> listaCPFValidos = new ArrayList<>();
        List<CPF> listaCPFInvalidos = new ArrayList<>();
        
        for (String codigos : listaCodigos) {

            if(verificador.verificadorDeTamanho(codigos)){
                listaCPFValidos.add(new CPF(codigos));
            }

            else{
                listaCPFInvalidos.add(new CPF(codigos));
            }
            
        }

        System.out.println("CPFs Validos: ");

        for (CPF cpf : listaCPFValidos) {
            System.out.println(cpf);
        }

        System.err.println("CPFs Invalidos: ");

        for (CPF cpf : listaCPFInvalidos) {
            System.out.println(cpf);
        }
        
       } catch (Exception e) {
        // TODO: handle exception
       }
       finally{
        sc.close();
       }


    }
}
