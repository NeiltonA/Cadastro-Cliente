package br.com.initial;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Index {

	@PostConstruct
	public String Sair(){
        return "returnLogin.xhtml";
    }

	public String Logout(){
        return "/index.xhtml";
    }
	
	
	public String index(){
         return "index.xhtml";
	}

	public String register() {
		return "register.xhtml";
	}
	public String principal() {
		return "principal.xhtml";
	}
	public String Cliente() {
		return "cliente.xhtml";
	}
	public String Home() {
		return "home.xhtml";
	}
	public String ListaCliente() {
		return "listaCliente.xhtml";
	}

	public String ListaCli() {
		return "listaCli.xhtml";
	}
}


