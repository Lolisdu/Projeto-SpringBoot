package com.cadastro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.exception.ResourceNotFoundException;
import com.cadastro.model.Cadastro;
import com.cadastro.repositories.CadastroRepository;
import com.cadastro.service.CadastroService;


	@Service
	public class CadastroServiceImpl implements CadastroService {
		
		
		@Autowired
		private CadastroRepository CadastroRepository;	
		
		@Override
		public Cadastro saveCadastro (Cadastro cadastro) {
			return CadastroRepository.save(cadastro);
		}
		
		@Override
		public List<Cadastro> getAllCadastro () {
			return CadastroRepository.findAll();
		}
		@Override
		public Cadastro getCadastroById(long id) {
			return CadastroRepository.findById(id).orElseThrow (()->
			new ResourceNotFoundException("Cadastro", "id", id));
			
		}
		@Override
		public Cadastro updateCadastro (Cadastro cadastro, long id) {
			Cadastro cadastroExistente = CadastroRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Cadastro", "id", id));
			
			cadastroExistente.setNome(cadastro.getNome());
			cadastroExistente.setCPF(cadastro.getCPF());
			cadastroExistente.setEmail(cadastro.getEmail());
			
			CadastroRepository.save(cadastroExistente);
			return cadastroExistente;			
	}
		@Override
		public void deleteCadastro(long id) {
			CadastroRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Cadastro", "id", id));
			CadastroRepository.deleteById(id);
			
		}
		
		
	}


