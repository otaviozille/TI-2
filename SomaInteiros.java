import java.util.Scanner;

public class SomaInteiros {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        int soma;

        System.out.println("Digite o primeiro número inteiro:");
        num1 = scanner.nextInt();

        System.out.println("Digite o segundo número inteiro:");
        num2 = scanner.nextInt();

        soma = num1 + num2;

        System.out.println("A soma dos números é: " + soma);

        scanner.close();
    }
}