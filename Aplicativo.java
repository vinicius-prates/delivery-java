package base;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicativo  {
    Scanner scan = new Scanner(System.in);
    ArrayList<Restaurante> restaurantes = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Aplicativo() {
        boolean x = true;
        while (x) {
            System.out.println("Aplicativo Delivery!");
            System.out.println("""
                    1 - Fazer Pedido
                    2 - Cadastrar usuário
                    3 - Cadastrar Restaurante
                    4 - Cadastrar Lanche
                    5 - Remover Lanche
                    6 - Sair""");
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Qual usuário vai fazer o pedido? ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + " - "+ usuarios.get(i).nome);

                    }
                    int opcao_usuario = scan.nextInt();

                    System.out.println(usuarios.get(opcao_usuario).nome+ ", qual restaurante você deseja realizar o pedido?");
                    for (int j = 0; j < restaurantes.size(); j++) {
                        System.out.println(j + " - " + restaurantes.get(j).nome);
                    }
                    int opcao_restaurante = scan.nextInt();
                    Pedido pedido = new Pedido();
                    while (true){
                        pedido.fazerPedido(usuarios.get(opcao_usuario), restaurantes.get(opcao_restaurante));
                        System.out.println("Você deseja continuar?\n (1 - SIM / 2 - NÃO)");
                        int yorno4 = scan.nextInt();
                        if (yorno4 == 1){
                            System.out.println("Seguindo com o pedido.");
                        }
                        else{
                            pedido.imprimirPedido();
                            pedidos.add(pedido);
                            break;
                        }
                    }
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    cadastrarRestaurante();
                case 4:
                    System.out.println("Restaurantes Resgistrados:");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        System.out.println(i + " -> " + restaurantes.get(i).nome);

                    }
                    System.out.println("Selecione um restaurante para adicionar o lanche.");
                    int opcao_lanche = scan.nextInt();
                    System.out.println("o restaurante escolhido foi: " + restaurantes.get(opcao_lanche).nome);

                    restaurantes.get(opcao_lanche).adicionarLanche();
                    break;
                case 5:
                    System.out.println("Restaurantes Resgistrados:");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        System.out.println(i + " -> " + restaurantes.get(i).nome);

                    }
                    System.out.println("Selecione um restaurante para remover o lanche.");
                    int opcao_lanche_remover = scan.nextInt();
                    System.out.println("o restaurante escolhido foi: " + restaurantes.get(opcao_lanche_remover).nome);

                    restaurantes.get(opcao_lanche_remover).removerLanche();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    x = false;
                    break;


                default:
                    System.out.println("Opção inválida...");
                    break;

            }

        }
    }

        public void cadastrarRestaurante () {
            System.out.println("Iniciando cadastro do restaurante!");

            System.out.println("Qual é o nome do restaurente?");
            String nome_restaurante = scan.next();

            System.out.println("Qual é a classificação monetária do restaurante? ($ to $$$$$) ");
            String classificacao_restaurante = scan.next();

            restaurantes.add(new Restaurante(nome_restaurante, classificacao_restaurante));
            System.out.println("SUCESSO! O restaurante foi cadastrado!");


        }

        public void cadastrarUsuario () {
            while (true) {
                System.out.println("Iniciando cadastro do usuário!");

                System.out.println("Qual o nome do usuário? ");
                String nome_usuario = scan.next();

                System.out.println("Qual é o endereço de entrega? ");
                String endereco_usuario = scan.next();

                System.out.println("Qual é o CPF? ");
                String cpf_usuario = scan.next();

                System.out.println("Qual é o telefone do usuário? ");
                String telefone_usuario = scan.next();

                usuarios.add(new Usuario(nome_usuario, endereco_usuario, cpf_usuario, telefone_usuario));
                System.out.println("Sucesso! O usuário foi cadastrado!");

                System.out.println("Deseja criar mais um usuário? (1 - Sim/ 2 - Não)");
                String yorno = scan.next();
                if (Objects.equals(yorno, "2")) {

                    break;
                } else {
                    System.out.println("OK!");

                }
            }

        }



}
