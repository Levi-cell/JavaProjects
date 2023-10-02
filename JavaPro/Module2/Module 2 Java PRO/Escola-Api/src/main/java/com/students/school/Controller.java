package com.students.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Controller")
public class Controller {

    AlunoService alunoService = new AlunoService();

    @GetMapping()
    public List<Alunos> searchName(@RequestParam(required = false) String nome, Integer id) {

        if(nome != null) {
            return alunoService.searchByNameAndAge(nome);
        }
        if(id != null ){
            return alunoService.SearchById(id);
        }
        return alunoService.Students(nome);
    }
    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody Alunos name){
        alunoService.registerStudent(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Alunos students){
        alunoService.updateStudent(students);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id ){
        return alunoService.deleteStudent(id);
    }
}