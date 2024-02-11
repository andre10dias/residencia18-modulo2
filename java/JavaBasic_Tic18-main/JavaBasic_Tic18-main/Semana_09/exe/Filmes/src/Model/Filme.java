package Model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Filme {
	String titulo;
	String genero;
	int ano;
	ArrayList<String> elenco;
	
	public Filme(String titulo, String genero, int ano) {
		this.titulo = titulo;
		this.genero = genero;
		this.ano = ano;
		this.elenco = new ArrayList<String>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void addElenco(ArrayList<String> elenco) {
		this.elenco.addAll(elenco);
	}
	
	public String toString() {
		return titulo + " - " + genero + " - " + ano;
	}
	
	public static void main(String[] args) {
		String json = "{\"titulo\": \"The Matrix\", \"genero\": \"Ação\", \"ano\": 1999}";
		
		System.out.println("JSON: " + json);
		
		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = new JSONArray();
						
		Filme filme = new Filme(jsonObject.getString("titulo"), jsonObject.getString("genero"), jsonObject.getInt("ano"));
		
		jsonArray.put("julia");
		jsonArray.put("matheus");
		jsonArray.put("joao");
		
		jsonObject.put("elenco", jsonArray);
		
				
		System.out.println("JSON: " + jsonObject.getJSONArray("elenco"));
		
		System.out.println("Filme: " + filme);
	}
}
