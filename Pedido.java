package base;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    ArrayList<Lanche> cesta = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public Pedido(){
    }

    public void fazerPedido(Usuario usuario, Restaurante restaurante){

        System.out.println(usuario.nome +", qual lanche você deseja escolher?");

        for (int i = 0; i < restaurante.lanches.size(); i++) {
            System.out.println(i + " - " + restaurante.lanches.get(i).nome + "\nR$ " + restaurante.lanches.get(i).preco);
        }
        int opcao_lanche = scan.nextInt();


        this.cesta.add(restaurante.lanches.get(opcao_lanche));
    }

    public void imprimirPedido(){
        for (int j = 0; j < this.cesta.size(); j++) {
            System.out.println(j + " - " + this.cesta.get(j).nome + "\nR$ " + this.cesta.get(j).preco);

        }

        }




}
