package com.controleacademico.controleacademico.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnviaMensagem {
	
	@RequestMapping("/")
	@ResponseBody
	public String mensagem() {
		return "Hello world";
	}
	
	@RequestMapping("/1")
	@ResponseBody
	public String mensagem1() {
		return "chile";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public String mensagem2() {
		return "Russia";
	}
	
	@RequestMapping("/texto")
	@ResponseBody
	public String texto() {
		return lerArquivo();
	}
	
	public String lerArquivo() {
		FileReader fr = null;
		BufferedReader br = null;
		String linha = "";
		
		String nomeArquivo = "teste.txt";
		
		try {
			fr = new FileReader(nomeArquivo);
			br = new BufferedReader(fr);
			
			System.out.println("Lendo arquivo...\n");
			while(br.ready()){
				linha += br.readLine();
				System.out.println(linha);
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo " + e);
			e.printStackTrace();
		}
		
		return linha;
	}

}
