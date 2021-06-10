package br.ucsal;

import java.util.Scanner;

public class Atividade05052 {

	public static void main(String[] args) {
		Scanner ed=new Scanner(System.in);
		
		String [][][] matrizM= new String [31][24][12];
		
		String verifica;
		int qnt;
		int dia;
		int horario;
		int mes;
		int qnt2;
		boolean mValida=false;
		while(!mValida) {
			
			System.out.println("Digite 1 para informar um agendamento");
			System.out.println("Digite 2 para verificar um agendamento");
			System.out.println("Digite 0 para sair do programa");
			verifica=ed.next();
			
			if(verifica.equals("1")) {
				System.out.println("Informe a quantidade de agendamentos que irá fazer");
				qnt=ed.nextInt();
				for(int i=0; i<qnt; i++) {
					for(int j=0; j<qnt; j++) {
						for(int k=0; k<qnt; k++) {
						System.out.println("Informe o dia do mês: (de 1 a 31)");
						dia=ed.nextInt();
						System.out.println("Informe a hora do dia: (de 1 a 24)");
						horario=ed.nextInt();
						System.out.println("Informe o mês do ano: (de 1 a 12");
						mes=ed.nextInt();ed.nextLine();
						System.out.println("Informe o compromisso");
						matrizM[dia][horario][mes]=ed.nextLine();
					
					}
				}
			}
			}else if(verifica.equals("2")) {
				System.out.println("Informe a quantidade de agendamentos a serem analisados");
				qnt2=ed.nextInt();
				for(int i=0; i<qnt2; i++) {
					for(int j=0; j<qnt2; j++) {
						for(int k=0; k<qnt2; k++) {
								System.out.println("Informe o dia do mês: (de 1 a 31)");
								i=ed.nextInt();
								System.out.println("Informe a hora do dia: (de 1 a 24");
								j=ed.nextInt();
								System.out.println("Informe o mês do ano: (de 1 a 12");
								k=ed.nextInt();


								if(matrizM[i][j][k]==null) {
									System.out.println("Nada foi agendado nesse dia hora informado");
								}else {
									System.out.println(matrizM[i][j][k]+"");
								}
			}
					}
				}
			}else {
				mValida=true;
			}
			
			
		}
ed.close();
	}


}