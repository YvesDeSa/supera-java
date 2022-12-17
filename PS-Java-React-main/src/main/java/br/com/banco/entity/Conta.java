package br.com.banco.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable{
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_conta;
	@NotEmpty(message = "O NOME não pode ser vazio")
	@Length(min = 3, max=100, message="O nome deve ter entre 3 e 100 caracteres")
	private String nome_responsavel;


	@JsonIgnore
	@OneToMany(mappedBy = "conta")
	private List<Transferencia> transferencias;

	public Conta() {
		super();
	}

	public Conta(Integer id_conta, String nome_responsavel) {
        super();
		this.id_conta = id_conta;
		this.nome_responsavel = nome_responsavel;
		this.transferencias = new ArrayList<>();;
	}

	public Integer getId_conta() {
		return id_conta;
	}

	public void setId_conta(Integer id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_conta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id_conta, other.id_conta);
	}
}
