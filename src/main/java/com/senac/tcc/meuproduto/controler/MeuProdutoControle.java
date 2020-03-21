package com.senac.tcc.meuproduto.controler;

import java.time.LocalDateTime;
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

import com.senac.tcc.meuproduto.model.MarcaProduto;
import com.senac.tcc.meuproduto.repository.MeuProdutoRepository;

@RestController
@RequestMapping("/meuproduto")

public class MeuProdutoControle {

	@Autowired
	MeuProdutoRepository repository;

	/*
	@GetMapping
	public void teste() {
		MarcaProduto marcaproduto = new MarcaProduto();
		marcaproduto.setNome("teste");
		marcaproduto.setSite("teste2");
		repository.save(marcaproduto);

		System.out.println("###Teste com sucesso");
		
	}
*/
	@PostMapping
	public ResponseEntity<?> novoProduto(@RequestBody MarcaProduto marcaProduto) {
		
		marcaProduto.setDatacadastro(LocalDateTime.now());
		repository.save(marcaProduto);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping
	public List<MarcaProduto> recuperatodasmarcasproduto() {
		
		return repository.findAll();
	}
	

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletamarcasproduto(@PathVariable Long id) {
		Optional<MarcaProduto> findById = repository.findById(id);
		if (findById.isPresent()) {
			repository.delete(findById.get());
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
	
	

}
