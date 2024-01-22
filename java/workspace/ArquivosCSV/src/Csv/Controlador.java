package Csv;

public class Controlador {
	
	public static void inserir(Usuarios usuarios, Usuario usuario) {
		usuarios.getListaUsuarios().add(usuario);
	}
	
	public static Integer buscar(Usuarios usuarios, Usuario usuario) {
		return usuarios.getListaUsuarios().indexOf(usuario);
	}
	
	public static void listarTodos(Usuarios usuarios) {
		for (Usuario usuario : usuarios.getListaUsuarios()) {
			System.out.println(usuario.toString());
		}
	}
	
	public static void excluir(Usuarios usuarios, Usuario usuario) {
		int index = buscar(usuarios, usuario);
		usuarios.getListaUsuarios().remove(index);
	}

}
