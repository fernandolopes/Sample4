import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import Controllers.JogadorController;
import Models.Jogador;

public class Program {

	public static void main(String[] args) {
		// TODO Alunos
		// Denise Rodrigues - 362043
		// Fernando Lopes - 61051
		
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Fernando Lopes");
		jogador1.setNumeroCamisa(11);
		jogador1.setApelido("FFE");
		jogador1.setCidade("Fortaleza");
		jogador1.setCpf("456455555");
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date data = formatter.parse("11-11-1978");
			jogador1.setDataNascimento(data);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		jogador1.setEstado("Ceará");
		jogador1.setPais("Brasil");
		jogador1.setTime("Fortaleza");
		
		JogadorController jogadorController = new JogadorController();
		Boolean valid = jogador1.Validar();
		if(valid) {
			jogadorController.inserir(jogador1);
		}
		
		Jogador jogador2 = jogadorController.buscar(3L);
		jogadorController.apagar(jogador2);
		
		List<Jogador> lista = jogadorController.lista();
		for(Jogador jogador : lista){
			System.out.println(jogador.getApelido());
		}
	}

}
