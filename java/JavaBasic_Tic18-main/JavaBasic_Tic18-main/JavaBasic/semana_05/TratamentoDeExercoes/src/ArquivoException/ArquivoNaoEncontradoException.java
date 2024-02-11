package ArquivoException;

public class ArquivoNaoEncontradoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nomeArquivo;
	
	public ArquivoNaoEncontradoException(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public String getMessage() {
		return "Arquivo " + nomeArquivo + " não encontrado";
	}
}
