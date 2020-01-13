package br.com.gft.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concessionaria {
	private static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

	public static ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	//construtor
	public Concessionaria(List<Veiculo> veiculos) {
		setVeiculos((ArrayList<Veiculo>) veiculos);
	}
	public static void listarVeiculos() {
		int listaVeiculos = veiculos.size();
		if(listaVeiculos!=0) {
			for(Veiculo carro: getVeiculos()){
				System.out.println(carro.toString());	
			}
		}
		else {
			System.out.println("Não existem veiculos ainda!\n");
		}
	}

	public static void menu() {
		Scanner ler = new Scanner(System.in);
		int gas=0,escolha,opcMovimento;
		String  cor ="",corCriacao, marcaCriacao,modelo,placa;
		double preco;
		while(true){
			System.out.printf("Digite 1 para criar um carro "+"\nDigite 2 para ver a lista de veiculos"+"\nDigite 0 para sair\n");
			escolha = ler.nextInt();	
				if(escolha ==1) {
						System.out.println("--------------------------");
						marcaCriacao = ler.nextLine();
						System.out.printf("Digite a marca:");
						marcaCriacao = ler.nextLine();
						System.out.println("\n--------------------------");
						System.out.printf("Digite o modelo:");
						modelo=ler.nextLine();
						System.out.println("--------------------------");
						System.out.printf("Digite a cor do carro:");
						corCriacao=ler.nextLine();
						System.out.printf("--------------------------");
						System.out.printf("\nDigite a placa:");
						placa=ler.nextLine();
						System.out.printf("--------------------------");
						System.out.printf("\nDigite o preço do carro:");
						preco=ler.nextDouble();
						System.out.printf("--------------------------");
						Veiculo carro = new Veiculo(marcaCriacao, modelo, corCriacao, placa, preco);
						ArrayList<Veiculo> car = new ArrayList<>();
						car.add(carro);
						Concessionaria venda = new Concessionaria(car);
						listarVeiculos();
						System.out.println("--------------------------");
						do {
						System.out.printf("Digite 1 para ligar\n"
								+ "Digite 2 para desligar o carro\n"
								+ "Digite 3 para frear o carro\n"
								+ "Digite 4 para abastecer\n"
								+ "Digite 5 para acelerar\n"
								+ "Digite 6 para definir ou trocar a cor do carro\n"
								+ "Digite 7 para voltar ao menu\n");
						opcMovimento = ler.nextInt();
						if(opcMovimento==1) {
							carro.ligar();
							continue;
						}
						else if(opcMovimento==2){
							carro.desligar();
						}
						else if(opcMovimento==3){
							carro.frear();
						}
						else if(opcMovimento==4){
							System.out.println("\nDigite a quantidade de gasolina que voce deseja colocar");
							gas=ler.nextInt();
							carro.abastecer(gas);
						}
						else if(opcMovimento==5){
							carro.acelerar();
						}
						else if(opcMovimento==6){
							System.out.println("\nEscreva uma cor: ");
							carro.pintar(cor);
						}
						}while(opcMovimento!=7);
				}
				
				else if(escolha==2) {
					if(getVeiculos().isEmpty()) {
						System.out.println("Nao existem carros ainda, presione qualquer tecla para continuar!");
						ler.nextLine();
					}
					else {
						listarVeiculos();
					}
				}
				else if(escolha==0) {
					ler.close();
					break;
				}
				else {
					System.out.println("Pressione um tecla para continuar!");
					ler.nextLine();
				}
		}
	}
}
