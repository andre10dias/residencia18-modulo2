package persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import model.Cliente;

public class ClienteJson {
	public static void SalvarCliente(ArrayList<Cliente> cliente, String arquivo) throws IOException {
		try {
			FileOutputStream file = new FileOutputStream(arquivo+".json");
			String json = geraStringJson(cliente);
			
			JSONObject jsonObject = new JSONObject(json);
			
			file.write(jsonObject.toString().getBytes());
			
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String geraStringJson(ArrayList<Cliente> cliente) {
		String json = "";
		for (int i = 0; i < cliente.size(); i++) {
			json += "{";
			json +=  "\"Nome\":\"" + cliente.get(i).getNome()+"\",";
			json +=  "\"CPF\":\"" + cliente.get(i).getCpf()+"\",";
			json +=  "\"CNH\":\"" + cliente.get(i).getCnh()+"\"";
			json += "}";
		}
		System.out.println(json);
		return json;
	}
}
