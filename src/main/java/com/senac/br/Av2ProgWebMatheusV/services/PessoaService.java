package com.senac.br.Av2ProgWebMatheusV.services;

import com.senac.br.Av2ProgWebMatheusV.entities.Pessoa;
import com.senac.br.Av2ProgWebMatheusV.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        // Verifica se a pessoa existe antes de atualizar
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        // Atualiza os campos
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setTelefone(pessoaAtualizada.getTelefone());
        pessoa.setEmail(pessoaAtualizada.getEmail());

        // Salva a pessoa atualizada
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletar(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        pessoaRepository.delete(pessoa);
    }

    public boolean existsById(Long id) {
        return pessoaRepository.existsById(id);
    }
}
