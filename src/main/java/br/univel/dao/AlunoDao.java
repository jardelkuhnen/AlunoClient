package br.univel.dao;

import java.util.List;

import br.univel.model.Aluno;

public interface AlunoDao {

	Aluno salvar(Aluno aluno);

	List<Aluno> getTodosAlunos();

}