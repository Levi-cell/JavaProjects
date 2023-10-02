package com.students.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GenericControllerAdvice {
    Logger LOOGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler({NomeNaoEncontradoExeception.class})
    public ResponseEntity<String> Exeception(final NomeNaoEncontradoExeception e){
        final String AlunoNaoEncontrado = "ALUNO NÃO ENCONTRADO";
        LOOGER.error(AlunoNaoEncontrado);
        return new ResponseEntity<>(AlunoNaoEncontrado, HttpStatus.NOT_FOUND);
    }
}
