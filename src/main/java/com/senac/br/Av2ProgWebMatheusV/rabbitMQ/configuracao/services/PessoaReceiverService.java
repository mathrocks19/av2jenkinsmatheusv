package com.senac.br.Av2ProgWebMatheusV.rabbitMQ.configuracao.services;

import com.senac.br.Av2ProgWebMatheusV.entities.Pessoa;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PessoaReceiverService {

    @RabbitListener(queues = "pessoaQueue")
    public void receberPessoa(Pessoa pessoa) {
        System.out.println("Pessoa recebida da fila: " + pessoa);

    }
}
