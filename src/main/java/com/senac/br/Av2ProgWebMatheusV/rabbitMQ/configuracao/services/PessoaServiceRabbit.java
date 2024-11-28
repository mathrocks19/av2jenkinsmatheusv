package com.senac.br.Av2ProgWebMatheusV.rabbitMQ.configuracao.services;

import com.senac.br.Av2ProgWebMatheusV.entities.Pessoa;
import com.senac.br.Av2ProgWebMatheusV.rabbitMQ.configuracao.Configuracao.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceRabbit {

    private final RabbitTemplate rabbitTemplate;

    public PessoaServiceRabbit(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarPessoa(Pessoa pessoa) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                pessoa
        );
        System.out.println("Pessoa enviada para RabbitMQ: " + pessoa);
    }
}
