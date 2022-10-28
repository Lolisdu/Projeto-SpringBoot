package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Cadastro;
import com.cadastro.serviceImpl.CadastroServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cadastro")
public class CadastroController {

		@Autowired
		private CadastroServiceImpl service;
		
		//TESTE
		@GetMapping ("/home")
		public String hello() {
			return "Oi";
		}
		 
		//LISTAGEM REQUEST
		//localhost:8080/api/cadastro
		@GetMapping
		public ResponseEntity<List<Cadastro>> findAll() {
			List<Cadastro> cadastro = service.getAllCadastro();
			return ResponseEntity.ok().body(cadastro);
			
		}
		//localhost:8080/api/cadastro/1
		@GetMapping ("{id}")
		public ResponseEntity<Cadastro> getCadastroById(@PathVariable("id") long CadastroId){
			return new ResponseEntity<Cadastro>(service.getCadastroById(CadastroId), HttpStatus.OK);
		}
		
		//REQUEST PARA SALVAR
		//localhost:8080/api/cadastro
		@PostMapping
		public ResponseEntity<Cadastro> saveCadastro(@RequestBody Cadastro cadastro){
			return new ResponseEntity<Cadastro>(service.saveCadastro(cadastro), HttpStatus.CREATED);
		}
		
		//REQUEST PARA UPDATE
		//localhost:8080/api/cadastro/1
		@PutMapping("{id}")
		public ResponseEntity<Cadastro> updateCadastro(@PathVariable("id") long id, @RequestBody Cadastro cadastro){
			return new ResponseEntity<Cadastro>(service.updateCadastro(cadastro, id), HttpStatus.OK);
		}
		
		//REQUEST DELETAR
		@DeleteMapping ("{id}")
		public ResponseEntity<String> deleteCadastro(@PathVariable ("id")  long id ){
			service.deleteCadastro(id);
			return new ResponseEntity<String>("Cadastro deletado com sucesso.", HttpStatus.OK);
			
		}
	}



