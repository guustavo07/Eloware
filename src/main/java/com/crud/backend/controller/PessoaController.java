package com.crud.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.backend.model.Pessoa;
import com.crud.backend.repository.PessoaRepository;

@RestController

public class PessoaController {

  @Autowired
  private PessoaRepository repository;

  @PostMapping("/pessoa")
  public Pessoa create(@RequestBody Pessoa pessoa) {
    return repository.save(pessoa);
  }

  @GetMapping("/pessoa/{id}")
  public Pessoa get(@PathVariable Long id) {
    return repository.findById(id).orElse(null);
  }

  @GetMapping("/pessoas")
  List<Pessoa> getAllPessoas() {
    return repository.findAll();
  }

  @PutMapping("/pessoa/{id}")
  public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
    pessoa.setId(id);
    return repository.save(pessoa);
  }

  @DeleteMapping("/pessoa/{id}")
  String deletePessoa(@PathVariable Long id) {
    repository.deleteById(id);
    return "O Usuário com id " + id + " foi deletado com sucesso.";
  }
}