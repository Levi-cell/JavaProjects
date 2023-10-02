package com.students.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoService {

    private List<Alunos> alunos;

    public AlunoService() {
        this.alunos = new ArrayList<>();
    }

    //Adicionar aluno
   public void registerStudent(Alunos aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size() + 1);
        }
        alunos.add(aluno);
       new ResponseEntity<>("Cadastrado com Sucesso!!", HttpStatus.CREATED);
   }
   public List<Alunos> Students (String nome){
        return alunos;
   }

   //Buscar Aluno Cadastrado pelo nome e idade
    public List<Alunos> searchByNameAndAge(String nome){
        List<Alunos> SearchByName = alunos.stream()
                .filter(aln -> aln.getNome().contains(nome)).collect(Collectors.toList());

        if(SearchByName.isEmpty() ) {
            throw new NomeNaoEncontradoExeception();
        }

        return SearchByName;
    }
    public List<Alunos> SearchById (Integer id){
            List<Alunos> filterId = alunos.stream()
                    .filter(i -> i.getId().equals(id)).collect(Collectors.toList());

            if(filterId.isEmpty() ){
                throw new NomeNaoEncontradoExeception();
            }

            return filterId;
    }


// Atualizar cadastro do ALUNO
    public void updateStudent(@RequestBody Alunos students) {
    alunos.stream()
            .filter(id -> id.getId().equals(students.getId()))
            .forEach(n -> n.setNome(students.getNome()));
    alunos.stream()
            .filter(n -> n.getId().equals(students.getId()))
            .forEach(n -> n.setIdade(students.getIdade()));
    alunos.stream()
            .filter(id -> id.getId().equals(students.getId()))
            .forEach(cpf -> cpf.setCpf(students.getCpf()));

    }
// DElETAR ESTUDANTE
    public ResponseEntity deleteStudent(Integer id){
        alunos.removeIf(i-> i.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
