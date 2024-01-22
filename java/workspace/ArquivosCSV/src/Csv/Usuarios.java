package Csv;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	
	private List<Usuario> listaUsuarios;

	public Usuarios() {
		listaUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
