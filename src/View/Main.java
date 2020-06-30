package View;

import Model.Pagamento;
import java.util.Scanner;
import java.text.DecimalFormat; //importação para fazer a formatação dos numero 

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Pagamento p1 = new Pagamento();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        boolean confirm = false;
        byte voltar = 1; //variavel para fazer o loop do menu 
        int contErros = 0; // variavel para fazer o limitador de erros de opção inválida
        do {

            byte menu; //Variavel para ler o MENU
            System.out.println("-----------------------------------");
            System.out.println(">>>          ESCOLHA            <<<");
            System.out.println(">   1- Cadastrar Dados            <");
            System.out.println(">   2- Ver Dados Cadastrados      <");
            System.out.println(">   3- Ver salário bruto          <");
            System.out.println(">   4- Ver salário Família        <");
            System.out.println(">   5- Ver Valor Vale Transporte  <");
            System.out.println(">   6- Ver Insalubridade          <");
            System.out.println(">   7- Ver INSS                   <");
            System.out.println(">   8- Ver Valor Refeição         <");
            System.out.println(">   9- Ver total Horas Extras     <");
            System.out.println(">   10- Ver Salário Final         <");
            System.out.println(">   0- Sair                       <");
            System.out.println("-----------------------------------");
            menu = ler.nextByte();

            switch (menu) {
                case 1:
                    confirm = true;
                    do {
                        System.out.println("--> CADASTRANDO DADOS <--");
                        System.out.print("\nDigite seu nome: ");
                        p1.setNome(ler.next());

                        do {
                            System.out.print("\nDigite seu CPF: ");
                            p1.setCpf(ler.next());
                            if (p1.getCpf().length() != 11) {//Validação para o CPF
                                System.out.println("\nErro, número de caracteres não corresponde.");
                            }
                        } while (p1.getCpf().length() != 11);

                        System.out.print("\nDigite seu cargo: ");
                        p1.setCargo(ler.next());

                        do {
                            System.out.print("\nDigite seu salário por hora: ");
                            p1.setValorHora(ler.nextDouble());
                            if (p1.getValorHora() < 0) {//Validação 
                                System.out.println("\nERRO, número menor que 0");
                            }
                        } while (p1.getValorHora() < 0);

                        do {
                            System.out.print("\nDigite a quantidade de horas trabalhadas: ");
                            p1.setQuantidadeHoras(ler.nextInt());
                            if (p1.getQuantidadeHoras() < 0) {//Validação 
                                System.out.println("\nERRO, número menor que 0");
                            }
                        } while (p1.getQuantidadeHoras() < 0);

                        do {
                            System.out.print("\nDigite quantas horas extra você fez durante a semana: ");
                            p1.setHorasExtras50(ler.nextInt());
                            if (p1.getHorasExtras50() < 0) {//Validação
                                System.out.println("\nERRO, número menor que 0");
                            }
                        } while (p1.getHorasExtras50() < 0);
                        do {
                            System.out.print("\nDigite quantas horas extra você fez em finais de semana ou feriados: ");
                            p1.setHorasExtras100(ler.nextInt());
                            if (p1.getHorasExtras100() < 0) {//Validação
                                System.out.println("\nERRO, número menor que 0");
                            }
                        } while (p1.getHorasExtras100() < 0);

                        do {
                            System.out.print("\nDigite o número de dependentes: ");
                            p1.setDependentes(ler.nextInt());
                            if (p1.getDependentes() < 0) {//Validação
                                System.out.println("\nERRO, número menor que 0");
                            }
                        } while (p1.getDependentes() < 0);

                        do {
                            System.out.print("\nEscolha o tipo de insalubridade: "
                                    + "\n1 - Sem insalubridade"
                                    + "\n2 - Mínimo (10% de insalubridade)"
                                    + "\n3 - Médio (20% de insalubridade)"
                                    + "\n4 - Máximo (40% de insalubridade)");
                            p1.setTipoInsalubridade(ler.nextDouble());
                            if (p1.getTipoInsalubridade() < 1 || p1.getTipoInsalubridade() > 4) {
                                System.out.println("ERRO, valor inválido. Tente novamente.");
                            }
                        } while (p1.getTipoInsalubridade() < 1 && p1.getTipoInsalubridade() > 4);

                    } while (confirm == false);

                    break;

                case 2:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("-->DADOS CADASTRADOS<--");
                        System.out.println(p1);
                    }
                    break;
                case 3:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->SALÁRIO BRUTO<--");
                        System.out.println("\n R$ " + df.format(p1.calcularSalarioBruto()));
                    }
                    break;
                case 4:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->SALÁRIO FAMÍLIA<--");
                        System.out.println("\n R$ " + df.format(p1.calcularSalarioFamilia()));
                    }
                    break;
                case 5:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->VALE TRANSPORTE<--");
                        System.out.println("\n R$ " + df.format(p1.calcularVale()));
                    }
                    break;
                case 6:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->INSALUBRIDADE<--");
                        System.out.println(df.format(p1.calcularInsalubridade()));
                    }
                    break;
                case 7:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->INSS<--");
                        System.out.println("\n R$ " + df.format(p1.calcularInss()));
                    }
                    break;
                case 8:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->VALE REFEIÇÃO<--");
                        System.out.println("Digite o valor do vale: " );
                        double valorVale = ler.nextDouble();
                        System.out.println(df.format(p1.calcularValeRefeicao(valorVale)));
                    }
                    break;
                case 9:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->TOTA DE HORAS EXTRA<--");
                        System.out.println(df.format(p1.calcularTotalHorasExtras()));
                    }
                    break;
                case 10:
                    if (confirm == false) {
                        System.out.println("ERRO, Prencha os dados.");
                    } else {
                        System.out.println("\n\n-->SALÁRIO LÍQUIDO<--");
                        System.out.println(df.format(p1.calcularSalarioLiquido()));
                    }
                    break;
                case 0:
                    System.out.println("Obrigado, volte sempre :D");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    contErros++;
            }//switch(menu)

        } while (voltar != 0 && contErros <= 3);

    }//PSVM
}//MAIN
