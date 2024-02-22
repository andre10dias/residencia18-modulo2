package com.aeroporto.aeroporto.controller.dto;

package com.aeroporto.aeroporto.controller.dto;

import com.modeloAeronave.aeroporto.controler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModeloAeronaveDTO {
	private Long id;
	private String fabricante;
	private String nome;
	
	public ModeloAeronaveDTO(ModeloAeronave m) {
		this.id = m.getId();
		this.fabricante = m.getFabricante();
		this.nome = m.getNome();
	}
}
