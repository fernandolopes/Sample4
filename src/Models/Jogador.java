package Models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import Controllers.JogadorController;

@Entity
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String Nome;
	@Column
	private String apelido;
	@Column
	private String cidade;
	@Column
	private String estado;
	@Column
	private String pais;
	@Column
	private Date dataNascimento;
	@Column
	private String time;
	@Column
	private int numeroCamisa;
	@Column
	private String cpf;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getNumeroCamisa() {
		return numeroCamisa;
	}
	
	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Boolean Validar() {
		JogadorController c = new JogadorController();
		List<Jogador> jogadores = c.lista();
		
		for(int i = 0; i < jogadores.size(); i++) {
			Jogador j = jogadores.get(i);
			if(j.getCpf().equals(cpf) || (j.getNumeroCamisa() == numeroCamisa && j.getTime().equals(time) ) ) {
				return false;
			}
		}
		
		return true;
	}
}
