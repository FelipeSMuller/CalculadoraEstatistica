package ProjetoCalculadora;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class MiniProjeto {

	public static void main(String[] args) {

		/*
		 * Descrição: Este projeto tem o objetivo de calcular várias estatísticas em um
		 * conjunto de números fornecidos pelo usuário, incluindo a média, mediana, moda
		 * e desvio padrão.
		 */

		int[] inteiros = new int[10];

		int soma = 0, resultado = 0;

		int userInput = 0;

		int contagem = inteiros.length;

		do {

			try {
				userInput = Integer.parseInt(JOptionPane.showInputDialog(null,

						"Digite um número \n1-Média \n2-Mediana \n3-Moda \n4-Desvio Padrão"));

				if (userInput <= 0) {

					JOptionPane.showMessageDialog(null, "ERRO!");

					break;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERRO!");
				break;
			}

			switch (userInput) {

			case 1:

				for (int i = 0; i < inteiros.length; i++) {

					try {

						inteiros[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Preencha o array com alguns números \nArrays restantes : " + contagem--));

						if (inteiros[i] <= 0) {
							JOptionPane.showMessageDialog(null,
									" A entrada de números negativos ou igual a 0 não é valido");
							break;
						}

						soma += inteiros[i];

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ERRO!");

					}
				}

				resultado = soma / inteiros.length;

				JOptionPane.showMessageDialog(null, " Média final dos números inteiros do array = " + resultado);
				break;

			case 2:

				for (int i = 0; i < inteiros.length; i++) {

					try {

						inteiros[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Preencha o array com alguns números \nQuantidade do array restante : " + contagem--));

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ERRO!");

					}

				}

				Arrays.sort(inteiros);

				int medianaImpar = 0;

				int medianaPar;

				for (int i = 0; i < inteiros.length;) {

					if (inteiros.length % 2 == 0) {

						int valorCentral = inteiros[inteiros.length / 2];

						int valorCentral2 = inteiros[(inteiros.length - 1) / 2];

						medianaPar = (valorCentral + valorCentral2) / 2;

						JOptionPane.showMessageDialog(null, " Mediana dos valores pares = " + medianaPar);

						break;

					}

					else {

						System.out.print(inteiros[i] + " ");

						medianaImpar = inteiros[inteiros.length / 2];

						JOptionPane.showMessageDialog(null,

								" A Mediana dos valores ímpares é igual a = " + medianaImpar);
						break;
					}
				}

			case 3:

				for (int i = 0; i < inteiros.length; i++) {

					try {

						inteiros[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Preencha o array com alguns números \nNúmeros restantes " + contagem--));

						if (inteiros[i] <= 0) {

							JOptionPane.showMessageDialog(null,
									"Não é possível inserir números negativos ou igual a 0");

						}

					} catch (NumberFormatException e) {

						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
					}

				}

				Arrays.sort(inteiros);

				int contador = 1;

				int moda = inteiros[0];

				int maxContagem = 1;

				for (int i = 1; i < inteiros.length; i++) {

					if (inteiros[i] == inteiros[i - 1]) {

						contagem++;

					} else {

						if (contagem > maxContagem) {

							maxContagem = contador;

							moda = inteiros[i - 1];
						}
						contador = 1;
					}
				}

				if (contador > maxContagem) {

					moda = inteiros[inteiros.length - 1];
				}

				JOptionPane.showMessageDialog(null, "Moda = " + moda);

				break;

			case 4:

				for (int i = 0; i < inteiros.length; i++) {

					try {

						inteiros[i] = Integer.parseInt(JOptionPane.showInputDialog(null,

								"Digite alguns números para preencher o array \nNúmeros restantes " + contagem--));

						if (inteiros[i] <= 0) {

							JOptionPane.showMessageDialog(null, "Você digitou um número menor ou igual a 0  \n ERRO");
							break;
						}

					} catch (NumberFormatException e) {

						JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número  \n ERRO");
						break;
					}

					soma += inteiros[i];

					resultado = soma / inteiros.length;

				}

				// Calculo de media para o desvio padrão

				JOptionPane.showMessageDialog(null, "Cálculo para o desvio padrão \nMédia = " + resultado);

				int[] diferenca = new int[10];

				// Cálculo da diferença entre a média e os números armazenados.
				for (int i = 0; i < inteiros.length; i++) {

					diferenca[i] = resultado - inteiros[i];
				}

				// Elevando as diferenças ao quadrado.

				int[] quadrado = new int[10];

				for (int i = 0; i < diferenca.length; i++) {

					System.out.print(diferenca[i] + " ");

					quadrado[i] = diferenca[i] * 2;

				}

				System.out.println("");

				int[] mediaEntreOsQuadrados = new int[10];

				// Imprimindo o novo array, que armazena agora os números elevados ao quadrado
				// anteriormente.

				for (int i = 0; i < quadrado.length; i++) {

					System.out.print(quadrado[i] + " ");

					mediaEntreOsQuadrados[i] = quadrado[i] / inteiros.length;

				}

				System.out.println("");

				// imprimindo outro array. A media entre os quadrados;

				int[] RaizQuadrada = new int[10];

				for (int i = 0; i < mediaEntreOsQuadrados.length; i++) {

					System.out.print(mediaEntreOsQuadrados[i] + " ");

					RaizQuadrada[i] = (int) Math.sqrt(mediaEntreOsQuadrados[i]);
				}

				// Imprimindo a Raiz Quadrada da Variancia

				for (int i = 0; i < mediaEntreOsQuadrados.length; i++) {

					System.out.print(RaizQuadrada[i] + " ");
				}

				break;

			default:

				JOptionPane.showMessageDialog(null,
						" Você não selecionou nenhum cálculo, portanto a apliação foi finalizada");
				break;
			}

		} while (contagem > 0 && userInput > 0);

	}

}
