package br.ucsal;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class LetrasForcaComMetodo {

	public static void main(String[] args) {
		Scanner ed = scanner();
		Scanner confir = scanner2();
		confirmacao(confir);

		String palavraAleatoria = aleatorio();

		int chances = 6, erro = 0,count = 0;
		char[] letras = palavraAleatoria.toCharArray(); 
		char[] chuteCerto = new char[palavraAleatoria.length()];
		char[] chutes = new char[20];
		boolean validarLetra = false;
		Boolean validarErro= false;

		String[][] desenhoForca = desenhoBoneco();


		draw(desenhoForca);

		chuteCerto(chuteCerto);


		validação(ed, chances, erro, count, letras, chuteCerto, chutes, validarLetra, validarErro, desenhoForca);
	}

	public static void validação(Scanner ed, int chances, int erro, int count, char[] letras, char[] chuteCerto,
		char[] chutes, boolean validarLetra, Boolean validarErro, String[][] desenhoForca) {
		char[] palavraChute;
		while(!validarErro) {
			System.out.print("   ");
			print(chuteCerto);
			System.out.println("\n");
			System.out.print("      Letras chutadas\n     ");
			print(chutes);
			System.out.println(); 

			System.out.println();
			System.out.print("Informe uma letra: ");

			String input = ed.next();

			palavraChute = input.toCharArray();

			if(Arrays.equals(palavraChute,letras)) {
				System.out.println("Vitoria!");
				break;
			}

			for (int i = 0; i < chutes.length; i++) {
				if(input.charAt(0) == chutes[i] ) {
					System.out.println("Letra já tentada");
					break;
					

				}else if (input.charAt(0) != chutes[i] && i == chances) {
					chutes[count] = input.charAt(0);
					count++;
					
				}
			}


			for (int j = 0; j < letras.length; j++) { 
				if(letras[j] == input.charAt(0)) {	
					chuteCerto[j] = letras[j];
					validarLetra = true;
				}
			}

			if(Arrays.equals(chuteCerto,letras)) {
				System.out.println("Vitoria!");
				break;
			}


			if(validarLetra == true) {
				System.out.println();
				System.out.println("Letra certa"); 
				validarLetra = false;

			}else if(validarLetra == false){			
				System.out.println();
				System.out.println("Letra errada");
				erro++;

			}	

			desenhoErro(erro, desenhoForca);

			if(erro == chances){
				desenhoForca[4][5]="\\";

				System.out.println("  Game-Over");
				validarErro=true;
			}
			draw(desenhoForca);

		}
	}

	public static void confirmacao(Scanner confir) {
		System.out.println("Você deseja jogar Forca? "
				+ "(1) Sim "
				+ "(2) Não");		
		int confirmacao = confir.nextInt();

		switch(confirmacao) {
		case 1: break;
		case 2: System.out.println("Até a próxima!!"); System.exit(0);
		default:
			System.out.println("Escolha invalida");
			break;
		}
	}

	public static Scanner scanner2() {
		Scanner confir = new Scanner(System.in);
		return confir;
	}

	public static Scanner scanner() {
		Scanner ed = new Scanner(System.in);
		return ed;
	}

	public static void chuteCerto(char[] chuteCerto) {
		for (int i = 0; i < chuteCerto.length; i++) {
			chuteCerto[i] = '-' ;
		}
	}

	public static void gameOver(int chances, int erro, String[][] desenhoForca, Boolean validarErro) { 
		if(erro == chances){
			desenhoForca[4][5]="\\";
			draw(desenhoForca);

			System.out.println("  Game-Over");
			validarErro=true;
		}
	}

	public static void desenhoErro(int erro, String[][] desenhoForca) {
		if(erro==1) {desenhoForca[2][4]="O";}
		if(erro==2) {desenhoForca[3][4]="|";}
		if(erro==3) {desenhoForca[3][3]="/";}
		if(erro==4) {desenhoForca[3][5]="\\";}
		if(erro==5) {desenhoForca[4][3]="/";}
	}

	public static String[][] desenhoBoneco() {
		String [][] desenhoForca = new String[5][6];

		desenhoForca[0][0]=" ";desenhoForca[0][1]="_";desenhoForca[0][2]="_";desenhoForca[0][3]="_";
		desenhoForca[1][0]="|";						 						desenhoForca[1][3]=" |";
		desenhoForca[2][0]="|";
		desenhoForca[3][0]="|";
		desenhoForca[4][0]="|";
		return desenhoForca;
	}

	public static String aleatorio() {
		String[] palavras = {"carro", "capacete", "bola", "surf", "bicicleta", "netflix", "caderno", "moto", "google", "fone"};
		Random aleatorio = new Random();
		int indiceAleatorio = aleatorio.nextInt(palavras.length);
		String palavraAleatoria = palavras[indiceAleatorio];
		return palavraAleatoria;
	}

	public static void draw(String[][] desenhoForca) {
		for(int i = 0; i < desenhoForca.length; i++) {
			for(int j = 0; j < desenhoForca[i].length; j++) {
				if(desenhoForca[i][j] == null) {
					desenhoForca[i][j]=" ";
				}
			}
		}

		for(int i = 0; i < desenhoForca.length; i++) {
			System.out.println();
			for(int j = 0; j < desenhoForca[i].length; j++) {
				System.out.print(desenhoForca[i][j]+"");
			}
		}
	}

	public static void print(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}

}