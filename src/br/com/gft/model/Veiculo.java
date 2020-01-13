package br.com.gft.model;


public class Veiculo implements java.io.Serializable{
	private String marca,modelo,placa,cor;
	private boolean ligado;
	private int litrosCombustivel,velocidade;
	private double preco;
	private float km;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}
	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		this.km = km;
	}
public Veiculo(String marcaCriacao, String modelo, String corCriacao, String placa, Double preco) {
		// TODO Auto-generated constructor stub
		setMarca(marcaCriacao);
		setModelo(modelo);
		setCor(corCriacao);
		setPlaca(placa);
		setPreco(preco);
	}
	public void acelerar() {
		if(isLigado()==false) {
			System.out.println("\nO seu carro precissa estar ligado para acelerar");
		}
		else if(getLitrosCombustivel()<1) {
			System.out.println("\nO seu carro não possui combustivel o suficiente para acelerar");
		}
		else if(getLitrosCombustivel()>=1) {
			setVelocidade(20);
			setLitrosCombustivel(-1);
			System.out.printf("A sua velocidade atual é de: "+getVelocidade()+" Km/h\n");
		}
	}
	public void abastecer(int qtdLitros) {
		if(isLigado()) {
			System.out.println("Desligue o carro antes de abastecer \n");
		}
		else if(isLigado()==false) {
			if(qtdLitros>100) {
				System.out.println("Voce não pode abastecer mais do que 100 litros \n");
			}
			else if(qtdLitros<=100) {
				setLitrosCombustivel(qtdLitros);
				System.out.printf("\nO seu carro possui "+getLitrosCombustivel()+" litros de combustivel\n");
			}
		}
	}
	public void frear() {
		if(isLigado()==false) {
			System.out.println("\nLigue o carro!");
		}
		else if(isLigado()==true&&getVelocidade()<0) {
			System.out.printf("A sua velocidade atual é de: "+getVelocidade()+" Km/h\n");
			setVelocidade(-10);
		}
		else {
			System.out.println("\nO seu carro ja esta parado!");
		}
	}
	public void pintar(String cor) {
		if(isLigado()) {
			System.out.println("\nDesligue o carro antes de pintar!");
		}
		else if(isLigado()==false) {
			if(cor==getCor()){
				System.out.printf("\nO seu carro ja possui a cor "+getCor());
			}
			else if(cor!=getCor()) {
				setCor(cor);
				System.out.printf("\nA cor do seu carro agora é "+getCor());
			}
		}
	}
	public void ligar() {
		if(isLigado()==false) {
			setLigado(true);
			System.out.println("\nO seu carro ja esta ligado! ");
		}
		else {
			System.out.println("\nVoce já ligou o carro");
		}
		
	}
	public void desligar() {
		if(isLigado()) {
			System.out.println("\nO carro está desligado");
			setLigado(false);
		}
		else {
			System.out.println("\nVoce já desligou o carro");
		}
	}
	@Override
	public String toString() {
		String retorno ="";
		retorno="\nMarca: "+getMarca()+"\nModelo: "+getModelo()+"\nCor: "+getCor()+"\nPlaca: "+getPlaca()+"\nPreço: "+getPreco();
		return retorno;
		
	}
}
