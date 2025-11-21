package app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import aluguer.BESTAuto;
import aluguer.Categoria;
import aluguer.Estacao;
import aluguer.Extensao;
import aluguer.Modelo;
import aluguer.PrecoExtensao;
import aluguer.Viatura;
import app.LeitorFicheiros.Bloco;
import pds.tempo.HorarioDiario;
import pds.tempo.HorarioSemanal;
import pds.util.Validator;

/**
 * Clase que arranca com o sistema
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BESTAuto albi = new BESTAuto();
		// ler os dados
		readEstacoes(albi, "dados/estacoes.txt");
		readModelos(albi, "dados/modelos.txt");
		readViaturas(albi, "dados/carros.txt");

		// ver o tamanho do écran onde criar as janelas
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// criar as janelas
		JanelaEstacoes je = new JanelaEstacoes(albi);
		JanelaAluguer ja = new JanelaAluguer(albi);

		// posicioná-las ao centro
		int posx1 = (screenSize.width - je.getWidth() - ja.getWidth()) / 2;
		int posx2 = posx1 + je.getWidth() + 10;
		je.setLocation(posx1, 50);
		ja.setLocation(posx2, 50);

		// torná-las visiveis
		je.setVisible(true);
		ja.setVisible(true);
	}

	/**
	 * método para ler o ficheiro com a informação das estações
	 * 
	 * @param best         a companhia
	 * @param estacoesFile o nome do ficheiro com a informação
	 */
	private static void readEstacoes(BESTAuto best, String estacoesFile) {
		try {
			List<LeitorFicheiros.Bloco> blocos = LeitorFicheiros.lerFicheiro(estacoesFile);

			for (LeitorFicheiros.Bloco b : blocos) {
				// TODO FEITO completar este método
				String id = b.getValor("id");
				String nome = b.getValor("nome");
				HorarioSemanal h = processarHorario(b);
				String central = processarCentral(b); // adicionei central como string
				Extensao extensao = processarExtensao(b);
				PrecoExtensao precoExtensao = processarPagamentoExtensao(b);
				// TODO FEITO armazenar a informação lida no sistema
				Estacao novaEstacao = new Estacao(id, nome, h, central , extensao, precoExtensao);
				best.estacoes.add(novaEstacao);
			}

		} catch (IOException e) {
			System.out.println("Erro na leitura do ficheiro " + estacoesFile);
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Processa as informações sobre como calcular o extra por haver extensão de
	 * horário.
	 * * @param b O bloco com a informação a processar
	 * 
	 * @return Um objeto PrecoExtensao ou null se não houver extensão.
	 */
	private static PrecoExtensao processarPagamentoExtensao(Bloco b) {
		String tipoPrecario = b.getValor("preco_extensao");

		if (tipoPrecario == null) {
			return null;
		}

		if (tipoPrecario.equals("taxa")) {
			String[] opcoes = b.getOpcoes("preco_extensao");

			// Deve haver exatamente 1 opção (o valor da taxa)
			if (opcoes == null || opcoes.length != 1) {
				throw new IllegalArgumentException("Formato inválido para preco_extensao=taxa[valor]");
			}

			// O valor é em cêntimos, lido como String nas opções
			try {
				long valorTaxa = Long.parseLong(opcoes[0]);
				return new PrecoExtensao("taxa", valorTaxa);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Valor da taxa inválido: " + opcoes[0]);
			}

		}

		else if (tipoPrecario.equals("variavel")) {
			// Não há valor fixo associado, o cálculo é feito com base no preço diário da
			// viatura.
			// Usei 0L para o valorFixo pois  validado como positivo ou zero.
			return new PrecoExtensao("variavel", 0L);
		}

		// Nunca devia chegar aqui se o ficheiro estiver correto.
		throw new UnsupportedOperationException("Campo desconhecido para preco_extensao: " + tipoPrecario);
	}

	/**
	 * Processa as informações sobre como proceder à extensão de horário
	 * 
	 * @param b o bloco com a informação a processar
	 */
	private static Extensao processarExtensao(Bloco b) {
		// TODO FEITO completar este método (os return podem ter de ser eliminados)
		String tipoExtensao = b.getValor("extensao");

		if (tipoExtensao == null) {
			return null;
		}

		else if (tipoExtensao.equals("total")) {
			return new Extensao("total", 999);
		}
		else if (tipoExtensao.equals("horas")) {
			String[] opcoes = b.getOpcoes("extensao");

			

			try {
				// A opção é o número de horas (N)
				int maxHoras = Integer.parseInt(opcoes[0]);
				Validator.requirePositive(maxHoras);

				return new Extensao("horas", maxHoras);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Valor de horas na extensão inválido: " + opcoes[0]);
			}
		}
		// nunca devia chegar aqui
		throw new UnsupportedOperationException("Campo desconhecido: " + tipoExtensao);
	}

	/**
	 * Processa as informações sobre se tem central ou não
	 * 
	 * @param b o bloco com a informação a processar
	 */
	private static String processarCentral(Bloco b) {
		// TODO FEITO completar este método (os return podem ter de ser eliminados)
		if (b.getValor("central") != null) {
			String central = b.getValor("central");
			return central;
		} else {
			return null;
		} 
	}

	/**
	 * Processa as informações sobre o horário
	 * 
	 * @param b o bloco com a informação a processar
	 * @return o horário semanal
	 */
	private static HorarioSemanal processarHorario(LeitorFicheiros.Bloco info) {
		String tipoHorario = info.getValor("horario");
		if (tipoHorario.equals("total"))
			return HorarioSemanal.sempreAberto();
		String dias[] = info.getOpcoes("horario");
		HorarioDiario hds[] = new HorarioDiario[dias.length];
		for (int i = 0; i < dias.length; i++) {
			String horas[] = dias[i].split("-");
			LocalTime ini = LocalTime.parse(horas[0]);
			LocalTime fim = LocalTime.parse(horas[1]);
			hds[i] = HorarioDiario.deAte(ini, fim);
		}
		if (tipoHorario.equals("alargado"))
			return HorarioSemanal.of(hds);
		if (tipoHorario.equals("semanal"))
			return HorarioSemanal.semanaUtil(hds);

		// nunca devia chegar aqui
		throw new UnsupportedOperationException("Campo desconhecido: " + tipoHorario);
	}

	/**
	 * Lê o ficheiro com as informações sobre os modelos
	 * 
	 * @param best a companhia
	 * @param file o nome do ficheiro
	 */
	private static void readModelos(BESTAuto best, String file) {
		try {
			List<LeitorFicheiros.Bloco> blocos = LeitorFicheiros.lerFicheiro(file);
			for (LeitorFicheiros.Bloco b : blocos) {
				String id = b.getValor("id");
				String modelo = b.getValor("modelo");
				Categoria categoria = Categoria.valueOf(b.getValor("categoria"));
				String marca = b.getValor("marca");
				int lotacao = Integer.parseInt(b.getValor("lotacao"));
				int bagagem = Integer.parseInt(b.getValor("bagagem"));
				long preco = Integer.parseInt(b.getValor("preco"));

				// TODO FEITO completar o método
				Modelo m = new Modelo(id, modelo, categoria, marca, lotacao, bagagem, preco);
				best.modelos.add(m);

			}
		} catch (IOException e) {
			System.out.println("Erro na leitura do ficheiro " + file);
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Lê o ficheiro com as informações sobre as viaturas
	 * 
	 * @param best a companhia
	 * @param file o nome do ficheiro
	 */
	private static void readViaturas(BESTAuto best, String file) {
		try {
			List<LeitorFicheiros.Bloco> blocos = LeitorFicheiros.lerFicheiro(file);
			for (LeitorFicheiros.Bloco b : blocos) {
				String matricula = b.getValor("matricula");
				String nomeModelo = b.getValor("modelo");
				String nomeEstacao = b.getValor("estacao");
				String idModelo = b.getValor("id");
				Modelo modelo = new Modelo(idModelo, nomeModelo, null, idModelo, 0, 0, 0);
				Estacao estacao = new Estacao(idModelo, nomeEstacao, null, idModelo, null, null);
				


				for (Modelo m:best.modelos){
					if(m.getNome()==nomeModelo){
						modelo= m;
					}
				}

				for(Estacao e:best.estacoes){
					if(e.getNome()==nomeEstacao){
						estacao= e;
					}
					
				}
			

				// TODO FEITO completar o método
				Viatura viatura = new Viatura(matricula, modelo, estacao);
				best.viaturas.add(viatura);

			}
		} catch (IOException e) {
			System.out.println("Erro na leitura do ficheiro " + file);
			e.printStackTrace();
			System.exit(0);
		}
	}
}
