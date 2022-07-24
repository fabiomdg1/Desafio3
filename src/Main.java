import java.util.Scanner;

//Criar um programa que receba 3 valores de salário e devolva a média.
//O programa deverá ser capaz de receber tanto ponto como virgula.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double[] salarios = new double[3];
    static double mediaSalarial = 0;
    static String opcao = "S";

    static boolean validarDados = true;

    public static void main(String[] args) {
        do {
            if (salarios[0] > 0) {
                recalcular();
            }
            receberDados();
            calcularMedia();

        } while (!opcao.equals("N"));
    }

    public static void receberDados() {
        double aux = 0.0;
        for (int i = 0; i < salarios.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º salário: ");
            aux = validacaoDeEntrada(scanner.next());
            //aux = scanner.nextDouble();
            salarios[i] = aux;
        }
    }

    public static double validacaoDeEntrada(String valor) {
        String aux = "";
        double resultado = 0.0;
        for(int i=0; i<valor.length();i++){
            if(valor.charAt(i) == ','){
                aux = aux + '.';
            }else{
                aux = aux + valor.charAt(i);
            }
        }
        resultado = Double.parseDouble(aux);
        return resultado;
    }


    public static void calcularMedia() {
        mediaSalarial = (salarios[0] + salarios[1] + salarios[2]) / 3;
        System.out.printf("A média salárial é de R$%.2f\n\n", mediaSalarial);
    }

    public static void recalcular() {
        System.out.println("Deseja recalcular ? \nDigite a opção desejada: ");
        System.out.println("S - Sim     N - Não");
        opcao = scanner.next();

        if (opcao.equals("N") || opcao.equals("n")) {
            System.exit(0);
        }
    }
}