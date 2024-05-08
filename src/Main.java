import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        String menu = """
                *********************************************************
                              Conversor de Moedas
                *********************************************************
                Selecione uma opção:

                1 - Dolar Americano USD para >>> Real BRL
                2 - Real BRL para >>> Dolar Americano USD
                3 - Dolar Americano USD para  >>> Peso Argentino ARS
                4 - Peso Argentino ARS para >>> Dolar Americano USD
                5 - Real BRL para >>> Peso Argentino USR
                6 - Peso Argentino para >>> Real BRL
                7 - Sair

                *********************************************************
                """;
        while (opcao != 7) {
            try {
                System.out.println(menu);
                opcao = sc.nextInt();
                double valor;

                if (opcao == 1) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("USD", "BRL", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: $%.2f USD convertido para Real é: R$%.2f\n\n", valor, valor_final);
                } else if (opcao == 2) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("BRL", "USD", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: R$%.2f convertido para Dólar é: $%.2f\n\n", valor, valor_final);
                } else if (opcao == 3) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("USD", "ARS", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: $%.2f USD convertido para Peso Argentino é: $%.2f\n\n", valor, valor_final);
                } else if (opcao == 4) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("ARS", "USD", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: $%.2f ARS convertido para Dólar é: $%.2f\n\n", valor, valor_final);
                } else if (opcao == 5) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("BRL", "ARS", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: R$%.2f BRL convertido para Peso Argentino é: $%.2f\n\n", valor, valor_final);
                } else if (opcao == 6) {
                    System.out.println("Digite o valor:");
                    valor = sc.nextDouble();
                    APIConnection conversao = new APIConnection("ARS", "BRL", valor);
                    double valor_final = conversao.conversor();
                    System.out.printf("O valor de: $%.2f ARS convertido para Real é: R$%.2f\n\n", valor, valor_final);
                } else if (opcao != 7) {
                    System.out.println("Opção invalida!");
                } else {
                    System.out.println("Finalizando a Aplicação...");
                }
            } catch (Exception e) {
                System.out.println("Não convertido, verifique se foi digitado o valor certo");
                System.out.println("Finalizando a Aplicação...");
                break;
            }
        }
        sc.close();
    }
}