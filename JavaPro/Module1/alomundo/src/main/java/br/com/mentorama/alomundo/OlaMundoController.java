package br.com.mentorama.alomundo;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {
    ////inserir
    private final List<Message> messages;

    public OlaMundoController() {
        this.messages = new ArrayList<>();

    }

    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message) {
        if (message != null) {

            return messages.stream()
                    .filter(msg -> msg.getMessage().contains(message))
                    .collect(Collectors.toList());

        }
        return messages;
    }

    @GetMapping("/{id}")
    public Message findByid(@PathVariable("id") Integer id) {
        return this.messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse((null));
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final  Message message) {
        if(message.getId() == null) {
            message.setId(messages.size() + 1);
        }
        messages.add(message);
        return new ResponseEntity<>(message.getId(), HttpStatus.CREATED);

    }
    ///atualizar
    @PutMapping
    public ResponseEntity update(@RequestBody final Message message) {
        messages.stream()
                 .filter(msg -> msg.getId().equals(message.getId()))
                 .forEach(msg -> msg.setMessage(message.getMessage()));
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        ///deletar

    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        messages.removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    }




