package com.senac.tcc.meuproduto.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcc.meuproduto.model.Categoria;
import com.senac.tcc.meuproduto.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")

public class Categoria_Controle {
	@Autowired
	CategoriaRepository repository;
	

//	@Autowired
//	MeuProdutoRepository repository;


	/*
	@GetMapping
	public void teste() {
		Categoria Categoria = new Categoria();
		Categoria.setNome("teste");
		Categoria.setSite("teste2");
		repository.save(Categoria);

		System.out.println("###Teste com sucesso");
		
	}
*/
	@PostMapping
	public ResponseEntity<?> novoProduto(@RequestBody Categoria Categoria) {
		
	//	Categoria.setDatacadastro(LocalDateTime.now());
		repository.save(Categoria);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping
	public List<Categoria> recuperatodascategorias() {
		
		return repository.findAll();
	}
	

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletacategorias(@PathVariable Long id) {
		Optional<Categoria> findById = repository.findById(id);
		if (findById.isPresent()) {
			repository.delete(findById.get());
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
}
