package br.com.hudson.transporte.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.hudson.transporte.domain.Cliente;
import br.com.hudson.transporte.exception.RecursoNaoEncontradoException;
import br.com.hudson.transporte.repository.ClienteCustomRepository;
import br.com.hudson.transporte.repository.ClienteRepository;
import br.com.hudson.transporte.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteCustomRepository clienteCustomRepository;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public List<Cliente> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@PostMapping
	public Cliente inserir(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	@DeleteMapping("/{id}")
	public Optional<Cliente> excluir(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente.get());
		return cliente;
	}

	@PutMapping
	public Cliente editar(@RequestBody Cliente cliente) {
		Cliente clienteEditado = clienteRepository.save(cliente);
		return clienteEditado;
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorCodigo(@PathVariable Long id) {
		try {
			Cliente cliente = clienteService.buscarPorCodigo(id);
			return cliente;
		} catch (RecursoNaoEncontradoException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não Encontrado!!!", e);
		}
	}
	
	@GetMapping("/filter")
	public List<Cliente> buscarPorNome(@RequestParam("nome") String nome){
		List<Cliente> cliente = clienteService.buscarPorNome(nome);
		return cliente;
	}
	
	@GetMapping("/filter/custom")
	public List<Cliente> buscarPorNomeCustom(
				@RequestParam(value = "id", required = false) Long id,
				@RequestParam(value = "nome", required = false) String nome){
		List<Cliente> cliente = clienteCustomRepository.find(id, nome);
		return cliente;
	}
}
