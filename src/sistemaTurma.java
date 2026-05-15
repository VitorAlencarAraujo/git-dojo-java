import java.util.Scanner;

public class sistemaTurma {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double soma = 0;
        double[] nota1 = new double[10];
        double[] nota2 = new double[10];
        double[] nota3 = new double[10];
        String[] aluno = new String[10];
        int total_cadastro = 0;
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    -----------------------------------------
                    === Sistema de Turma ===
                    1 - Cadastrar aluno
                    2 - Listar todos os alunos
                    3 - Buscar aluno por nome
                    4 - Exibir média geral da turma
                    0 - Sair""");

            System.out.println("Opção:");
            System.out.println("-----------------------------------------");

            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1) {

                if (total_cadastro == 10) {
                    System.out.println("Turma cheia");
                    continue;
                } else {
                    System.out.println("Nome:  ");
                    aluno[total_cadastro] = sc.nextLine();
                    System.out.println("Nota 1: ");
                    nota1[total_cadastro] = sc.nextDouble();
                    System.out.println("Nota 2: ");
                    nota2[total_cadastro] = sc.nextDouble();
                    System.out.println("Nota 3: ");
                    nota3[total_cadastro] = sc.nextDouble();

                    sc.nextLine();
                    total_cadastro++;
                    System.out.println("Aluno Cadastrado");
                    System.out.println("-----------------------------------------");
                }

            }
            if (opcao == 2) {
                if (total_cadastro == 0) {
                    System.out.println("Nenhum aluno cadastrado!");
                    System.out.println("-----------------------------------------");
                } else {
                    for (int i = 0; i < total_cadastro; i++) {
                        double media = (nota1[i] + nota2[i] + nota3[i]) / 3;
                        String situacao;
                        if (media >= 6) {
                            situacao = "Aprovado";

                        } else {
                            situacao = "Reprovado";

                        }
                        System.out.println("Nome: " + aluno[i] + " | Média:   " + media + " | Situação:  " + situacao);

                    }
                }
            }
            if (opcao == 3) {
                System.out.println("Insira seu nome para buscar: ");
                String busca = sc.nextLine();

                for (int i = 0; i < total_cadastro; i++) {
                    if (aluno[i].equalsIgnoreCase(busca)) {


                        double media = (nota1[i] + nota2[i] + nota3[i]) / 3;
                        String situacao;

                        if (media >= 6) {
                            situacao = "Aprovado";

                        } else {
                            situacao = "Reprovado";

                        }
                        System.out.println("-----------------------------------------");
                        System.out.println("Nome: " + aluno[i] + " | Média:   " + media + " | Situação:  " + situacao);

                    } else {
                        System.out.println(" ");
                        System.out.println("-----------------------------------------");
                    }

                }
            }

            if (opcao == 4) {
                for (int i = 0; i < total_cadastro; i++) {
                    double media = (nota1[i] + nota2[i] + nota3[i]) / 3;
                    soma += media;
                }
                System.out.println("media: " + soma / total_cadastro);
            }
            if (opcao == 0) {
                System.out.println("Encerrando o sistema");
                System.out.println("-----------------------------------------");
                return;
            } else if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 0) {
                System.out.println("Opção Invalída.");
                System.out.println("-----------------------------------------");
                continue;
            }
        }
    }
}

