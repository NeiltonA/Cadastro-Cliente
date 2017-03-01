package br.com.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dao.ClienteDao;
import br.com.entidade.Cliente;



@ManagedBean
@SessionScoped
public class ClienteBean {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private ClienteDao add;
	private List<Cliente> ClienteList;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.add = new ClienteDao();
		this.ClienteList = add.list();
	}

	public String newCliente() {
		return "cliente";
	}

	public String newHome() {
		return "home";
	}

	public String delete(Cliente cliente) {
		add.delete(cliente);
		if (cliente != null) {
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente deletado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "listaCliente";
		} else {
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Deletar Cliente!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "listaCliente";
		}

	}

	public String edit(Cliente cliente) {
		this.cliente = cliente;
		if (cliente != null) {
			return "editCliente";
		} else {
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Alterar Cliente!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "editCliente";
		}
	}

	public String editar() throws Exception {
		add.saveOrUpdate(cliente);
		if (cliente != null) {
			cliente = new Cliente();
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Alterado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "editCliente";
		} else {
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Alterar Cliente!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "editCliente";
		}
	}

	public String save() throws Exception {

		add.saveOrUpdate(cliente);

		if (cliente != null) {
			this.cliente = new Cliente();
			FacesMessage face = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Cadastrado com Sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, face);
			return "cliente";

		} else {
			return "cliente";
		}

	}

	// Geters and seters

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDao getAdd() {
		return add;
	}

	public void setAdd(ClienteDao add) {
		this.add = add;
	}

	public List<Cliente> getClienteList() {
		this.ClienteList = add.list();
		return ClienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		ClienteList = clienteList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}