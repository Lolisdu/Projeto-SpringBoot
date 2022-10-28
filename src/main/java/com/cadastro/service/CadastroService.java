package com.cadastro.service;

import java.util.List;

import com.cadastro.model.Cadastro;

public interface CadastroService {
	Cadastro saveCadastro (Cadastro cadastro);
	List<Cadastro> getAllCadastro ();
	Cadastro getCadastroById(long id);
	Cadastro updateCadastro(Cadastro cadastro, long id);
	void deleteCadastro (long id);
	
}
