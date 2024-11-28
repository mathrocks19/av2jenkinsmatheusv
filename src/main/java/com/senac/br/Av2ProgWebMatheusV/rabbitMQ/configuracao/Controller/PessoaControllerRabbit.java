package com.senac.br.Av2ProgWebMatheusV.rabbitMQ.configuracao.Controller;

import com.senac.br.Av2ProgWebMatheusV.entities.Pessoa;
import com.senac.br.Av2ProgWebMatheusV.rabbitMQ.configuracao.services.PessoaServiceRabbit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("pessoaControllerRabbit")
public class PessoaControllerRabbit {

    private final PessoaServiceRabbit pessoaServiceRabbit;

    public PessoaControllerRabbit(PessoaServiceRabbit pessoaServiceRabbit) {
        this.pessoaServiceRabbit = pessoaServiceRabbit;
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarPessoa(@RequestBody Pessoa pessoa) {
        pessoaServiceRabbit.enviarPessoa(pessoa);
        return new ResponseEntity<>("Pessoa enviada para a fila com sucesso: " + pessoa, HttpStatus.CREATED);
    }
}
