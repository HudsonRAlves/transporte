package br.com.hudson.transporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hudson.transporte.domain.Cliente;
import br.com.hudson.transporte.exception.RecursoNaoEncontradoException;
import br.com.hudson.transporte.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorCodigo(Long id) {
		Optional<Cliente> resultado = clienteRepository.findById(id);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		Cliente cliente = resultado.get();
		return cliente;
	}
	
	public List<Cliente> buscarPorNome(String nome) {
		List<Cliente> cliente = clienteRepository.findByNomeContains(nome);
		return cliente;
	}

}
