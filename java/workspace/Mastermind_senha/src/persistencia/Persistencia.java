package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Persistencia {
	private static final String PATH_CONFIG = "src" + File.separator + "bd" + File.separator + "config.json";
	
	public static JSONArray recuperarDados(Class<?> classe, List<String> nomesAtributos) {
		File arquivo = new File(PATH_CONFIG);
		JSONArray jsonArray = new JSONArray();
		String linha;
		
		if (arquivo.exists()) {		
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("\nLendo arquivo " + arquivo + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			JSONObject json = new JSONObject(linha);
                	
                	if (json.get(classe.getSimpleName()) != null) {					
                		jsonArray = json.getJSONArray(classe.getSimpleName());
    				}
        		}
        		
        	} catch (IOException e) {
        		System.err.println("\nErro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return jsonArray;
	}
	
	public static Boolean gravarDados(List<?> listaDados, Class<?> classe) {
		File arquivo = new File(PATH_CONFIG);
		JSONObject json = new JSONObject();
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
			json.put(classe.getSimpleName(), listaDados);
			
			writer.write(json.toString());
            writer.newLine();
            
            return true;
        } catch (IOException e) {
            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
        }
		
		return false;
	}
}
