package base;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    Scanner scan = new Scanner(System.in);
    //Variaveis
    ArrayList<Lanche> lanches = new ArrayList<>();
    String nome;
    String categoria_preco;
    //Construtor
    Restaurante(String nome, String categoria_preco){
        this.nome = nome;
        this.categoria_preco = categoria_preco;
    }

    //Métodos
    public void imprimirCardapio(){
        for (int i = 0; i < this.lanches.size(); i++) {
            System.out.println(i + " - " + this.lanches.get(i).nome + "\nR$ " + this.lanches.get(i).preco);
        }

    }

    public void adicionarLanche(){
        while (true){
            System.out.println("Qual o nome do lanche?");
            String nome_lanche = scan.next();

            System.out.println("Qual é o preço do lanche? ");
            double preco_lanche = Double.parseDouble(scan.next());

            lanches.add(new Lanche(nome_lanche, preco_lanche));
            System.out.println();

            System.out.println("Você deseja adicionar mais um lanche? (1 - Sim/ 2 - Não)");
            int yorno = scan.nextInt();
            if (yorno == 1){
                System.out.println("Iniciando cadastro do próximo lanche...");

            }
            else{
                break;
            }
        }
    }

    public void removerLanche(){
        System.out.println("Lanches do restaurante "+ this.nome +": ");
        this.imprimirCardapio();
        System.out.println("Selecione o lanche que deseja remover:");
        int opcao_remover = scan.nextInt();
        System.out.println("Você removeu o lanche:\n "+lanches.get(opcao_remover).nome+ "\nR$ " +lanches.get(opcao_remover).preco);
        lanches.remove(opcao_remover);


    }

}
