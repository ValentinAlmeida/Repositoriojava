package br.ucsal;

import java.util.Scanner;

public class Atividade0606JogoDavelha {

	public static void main(String[] args) {
		confirmar();
		String[][] desenho=new String[5][11];
		String[] posicoes=new String[10];

		exibirdesenho(desenho);
		receberposicao(desenho, posicoes);

		posicoes(desenho, posicoes);

	}
	private static void posicoes(String[][] desenho, String [] posicoes) {

		desenho[0][1]=posicoes[1];
		desenho[0][5]=posicoes[2];
		desenho[0][9]=posicoes[3];
		desenho[2][1]=posicoes[4];
		desenho[2][5]=posicoes[5];
		desenho[2][9]=posicoes[6];
		desenho[4][1]=posicoes[7];
		desenho[4][5]=posicoes[8];
		desenho[4][9]=posicoes[9];

	}
	private static void jogador1(String[][] desenho, String[] posicoes) {
		Scanner ed= scanner();
		int posicao1;

		System.out.println("\n");
		System.out.println("Jogador 1, informe uma posição entre (1,9)");	
		posicao1=ed.nextInt();
		if(posicao1>9) {
			System.out.println("Posição além do limite, informe novamente");
		}else {

			posicoes[posicao1]="O";
			posicoes(desenho, posicoes);
			exibirdesenho(desenho);

		}
	}
	private static void jogador2(String[][] desenho, String[] posicoes) {
		Scanner ed= scanner();
		int posicao2;

		System.out.println("\n");	
		System.out.println("Jogador 2, informe uma posição entre (1,9)");
		posicao2=ed.nextInt();
		if(posicao2>9) {
			System.out.println("Posição além do limite, informe novamente");
		}else {
			posicoes[posicao2]="X";
			posicoes(desenho, posicoes);
			exibirdesenho(desenho);
		}
	}
	private static void confirmar() {
		String jogar="";
		Scanner scan=scanner();
		boolean validaConfir=true;
		while(validaConfir) {

			System.out.println("Você deseja jogar? (s/n)");
			jogar=scan.nextLine().toLowerCase().trim();

			switch(jogar) {
			case "s": validaConfir=false; break;
			case "n": System.out.println("Encerrando o jogo..."); while(true) {}
			default: System.out.println("Escolha invalida");
			}



		}
	}
	private static void receberposicao(String[][] desenho, String [] posicoes) {	
		while(vitoria(desenho, posicoes)) {
			vitoria(desenho, posicoes);
			jogador1(desenho, posicoes);
			vitoria(desenho, posicoes);
			jogador2(desenho, posicoes);	
		}
	}
	private static boolean vitoria(String[][] desenho, String [] posicoes) {
		posicoes(desenho, posicoes);
		String output="\n" + "Vitoria";
		
		if(posicoes[1] == "O" && posicoes[2] == "O" && posicoes[3] == "O") {System.out.println(output); return false;}
		if(posicoes[4] == "O" && posicoes[5] == "O" && posicoes[6] == "O") {System.out.println(output); return false;}
		if(posicoes[7] == "O" && posicoes[8] == "O" && posicoes[9] == "O") {System.out.println(output); return false;}
		if(posicoes[1] == "O" && posicoes[4] == "O" && posicoes[7] == "O") {System.out.println(output); return false;}
		if(posicoes[2] == "O" && posicoes[5] == "O" && posicoes[8] == "O") {System.out.println(output); return false;}
		if(posicoes[3] == "O" && posicoes[6] == "O" && posicoes[9] == "O") {System.out.println(output); return false;}
		if(posicoes[1] == "O" && posicoes[5] == "O" && posicoes[9] == "O") {System.out.println(output); return false;}
		if(posicoes[7] == "O" && posicoes[5] == "O" && posicoes[3] == "O") {System.out.println(output); return false;}
		
		if(posicoes[1] == "X" && posicoes[2] == "X" && posicoes[3] == "X") {System.out.println(output); return false;}
		if(posicoes[4] == "X" && posicoes[5] == "X" && posicoes[6] == "X") {System.out.println(output); return false;}
		if(posicoes[7] == "X" && posicoes[8] == "X" && posicoes[9] == "X") {System.out.println(output); return false;}
		if(posicoes[1] == "X" && posicoes[4] == "X" && posicoes[7] == "X") {System.out.println(output); return false;}
		if(posicoes[2] == "X" && posicoes[5] == "X" && posicoes[8] == "X") {System.out.println(output); return false;}
		if(posicoes[3] == "X" && posicoes[6] == "X" && posicoes[9] == "X") {System.out.println(output); return false;}
		if(posicoes[1] == "X" && posicoes[5] == "X" && posicoes[9] == "X") {System.out.println(output); return false;}
		if(posicoes[7] == "X" && posicoes[5] == "X" && posicoes[3] == "X") {System.out.println(output); return false;}
		
		return true;
	}
	private static Scanner scanner() {
		Scanner ed=new Scanner(System.in);
		return ed;

	}
	private static void tabuleiro(String[][] desenho) {
		desenho[1][0]="-";desenho[1][3]="-";desenho[1][6]="-";desenho[1][9]="-";
		desenho[1][1]="-";desenho[1][4]="-";desenho[1][7]="-";desenho[1][10]="-";
		desenho[1][2]="-";desenho[1][5]="-";desenho[1][8]="-";
		desenho[3][0]="-";desenho[3][3]="-";desenho[3][6]="-";desenho[3][9]="-";
		desenho[3][1]="-";desenho[3][4]="-";desenho[3][7]="-";desenho[3][10]="-";
		desenho[3][2]="-";desenho[3][5]="-";desenho[3][8]="-";
		desenho[0][3]="|";desenho[3][3]="|";
		desenho[1][3]="|";desenho[4][3]="|";
		desenho[2][3]="|";
		desenho[0][7]="|";desenho[3][7]="|";
		desenho[1][7]="|";desenho[4][7]="|";
		desenho[2][7]="|";
	}
	private static void desenhosem(String[][] desenho) {

		for(int i=0; i<desenho.length; i++) {
			for(int j=0; j<desenho[i].length; j++) {
				if(desenho[i][j]==null) { 
					desenho[i][j]=" ";
				}
			}
		}
	}
	private static void exibirdesenho(String[][] desenho) {
		desenhosem(desenho);
		tabuleiro(desenho);

		for(int i=0; i<desenho.length; i++) {
			System.out.println();
			for(int j=0; j<desenho[i].length; j++) {
				System.out.print(desenho[i][j]);
			}
		}
	}

}

