package Model;

import java.util.Date;

public class Postagem {
	Usuario usuario;
	String texto;
	Date data_Postagem;
	
	
	public Postagem() {
	}
	
	public Postagem(Usuario usuario, String texto) {
		this.usuario = usuario;
		this.texto = texto;
		this.data_Postagem = new Date();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData_Postagem() {
		return data_Postagem;
	}

	public void setData_Postagem(Date data_Postagem) {
		this.data_Postagem = data_Postagem;
	}

	@Override
	public String toString() {
		return "Autor = " + usuario.getNome_Usuario() + "\ntexto=" + texto + "\ndata_Postagem=" + data_Postagem;
	}
	
	
			
}
