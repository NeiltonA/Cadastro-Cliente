package br.com.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="cliente",
uniqueConstraints={@UniqueConstraint(columnNames="nome")}
)

public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	
	@Column(name = "nome",unique =true)
	private String nome;
	private String sobrenome;
	private String idade;
	private Date dataNascimento;

	
	public Cliente() {
		super();
		
	}
	
	public Cliente (long id,String nome, String sobrenome, String idade, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;

	}


	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String  getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}
	
	public void setIdade(String  idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
}
