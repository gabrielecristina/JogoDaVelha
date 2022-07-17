package jogo.da.velha;

import java.util.Scanner;

//import javax.swing.JOptionPane;

public class JogoDaVelha {
	public static void main(String[] args) {

		Campo[][] jogoVelha = new Campo[3][3];

		char simboloAtual = 'X';
		Boolean game = true;
		String vitoria = "";

		Scanner leia = new Scanner(System.in);
		
		iniciarJogo(jogoVelha);

		while (game) {
			desenhaJogo(jogoVelha);
			vitoria = verificaVitoria(jogoVelha);
			if (!vitoria.equals("")) {
				System.out.printf("Jogador %s veceu%n", vitoria);
				break;

			}
			try {
				if (verificarJogada(jogoVelha, jogar(leia, simboloAtual), simboloAtual)) {
					if (simboloAtual == 'X') {
						simboloAtual = 'O';
					} else {
						simboloAtual = 'X';
					}

				}

			} catch (Exception ex) {
				System.out.println("Erro");
				//JOptionPane.showMessageDialog(null, "Erro");
			}
			System.out.println("Fim de jogo");
			//JOptionPane.showMessageDialog(null, " Fim do Jogo! ");

		}

	}

	public static void desenhaJogo(Campo[][] jogoVelha) {
		// TODO Limpar a tela
		limparTela();

		System.out.println("    0   1    2");

		System.out.printf("0   %c | %c | %c %n ", jogoVelha[0][0].getSimbolo(), jogoVelha[0][1].getSimbolo(),
				jogoVelha[0][2].getSimbolo());
		System.out.println(" ----------------");
		System.out.printf("1 %c | %c | %c %n ", jogoVelha[1][0].getSimbolo(), jogoVelha[1][1].getSimbolo(),
				jogoVelha[1][2].getSimbolo());
		System.out.println(" ----------------");
		System.out.printf("2 %c | %c | %c %n ", jogoVelha[2][0].getSimbolo(), jogoVelha[2][1].getSimbolo(),
				jogoVelha[2][2].getSimbolo());

	}

	// Simula a tela limpa
	public static void limparTela() {
		for (int cont = 0; cont < 200; cont++) {
			System.out.println("");
		}
	}

	public static int[] jogar(Scanner leia, char simboloAtual) {
		int p[] = new int[2];
		System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
		System.out.print("Informa a linha: ");
		p[0] = leia.nextInt();
		System.out.println("Informe a coluna: ");
		p[1] = leia.nextInt();
		return p;

	}

	public static Boolean verificarJogada(Campo[][] jogoVelha, int p[], char simboloAtual) {

		if (jogoVelha[p[0]][p[1]].getSimbolo() == ' ') {
			jogoVelha[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;

		} else {
			return false;

		}
	}

	public static void iniciarJogo(Campo[][] jogoVelha) {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

			}
		}

	}

	public static String verificaVitoria(Campo[][] jogoVelha) {
		return "";

	}

}
