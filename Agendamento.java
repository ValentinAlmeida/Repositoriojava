package br.ucsal;

import java.util.Scanner;

public static void main(String[] args) {
	Scanner ed= ed();
	String [][][] x= definirMatriz();
	int qnt= qntAgendamento(ed);
	pegarDia(ed, x, qnt);
	agenda(ed, x);


}

private static int qntAgendamento(Scanner ed) {
	int qnt;
	System.out.println("Informe a quantidade de agendamentos que irá fazer");
	qnt=ed.nextInt();	
	return qnt;
}

private static String[][][] definirMatriz() {
	String [][][] matrizM= new String [31][8][12];
	return matrizM;
}

private static void agenda(Scanner ed, String [][][] x) {
	
	String resposta="";
	boolean mValidade=false;
	Loop:
	do { 
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<x[i].length; j++) {
				for(int k=0; k<x[i][j].length; k++) {
					System.out.println("Deseja saber um agendamento no calendario? S/N");
					resposta=ed.next().toUpperCase();
					if(resposta.equals("S")){
						System.out.println("Informe o dia do mês: (de 1 a 31)");
						i=ed.nextInt();
						System.out.println("Informe a hora do dia: (de 1 a 24");
						j=ed.nextInt();
						System.out.println("Informe o mês do ano: (de 1 a 12");
						k=ed.nextInt();


						if(x[i][j][k]==null) {
							System.out.println("Nada foi agendado nesse dia hora informado");
						}else {
							System.out.println(x[i][j][k]+"");
						}
					}else if(resposta.equals("N")) {
						mValidade=true;
						break Loop;						
					}
				}
			}
		}
	}while(mValidade==true);
		System.out.println("Finalizando agenda");
}

private static Scanner ed() {
	Scanner ed=new Scanner(System.in);
	return ed;
	
}

private static void pegarDia(Scanner ed, String[][][] x, int qnt) {
	int dia;
	int horario;
	int mes;
			
	
	for(int i=0; i<qnt; i++) {
		for(int j=0; j<qnt; j++) {
			System.out.println("Informe o dia do mês: (de 1 a 31)");
			dia=ed.nextInt();
			System.out.println("Informe a hora do dia: (de 1 a 24)");
			horario=ed.nextInt();
			System.out.println("Informe o mês: (de 1 a 12)");
			mes=ed.nextInt();ed.nextLine();
			System.out.println("Informe o compromisso");
			x[dia][horario][mes]=ed.nextLine();
		
		}
	}
	
}

}
