package co.edu.usbcali.bank.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.bank.domain.Cliente;
import co.edu.usbcali.bank.dto.ClienteDTO;
import co.edu.usbcali.bank.mapper.ClienteMapper;
import co.edu.usbcali.bank.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	ClienteMapper clienteMapper;

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			Optional<Cliente> clienteOptional = clienteService.findById(id);
			if (clienteOptional.isPresent()==false) {
				throw new Exception("El cliente no existe");
			}
			Cliente cliente = clienteOptional.get();
			clienteService.delete(cliente);
			ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
			return ResponseEntity.ok(clienteDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(400, e.getMessage()));
		}
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteMapper.ClienteDTOtoCliente(clienteDTO);
			cliente = clienteService.update(cliente);
			clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
			return ResponseEntity.ok(clienteDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(400, e.getMessage()));
		}
	}

	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteMapper.ClienteDTOtoCliente(clienteDTO);
			cliente = clienteService.save(cliente);
			clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
			return ResponseEntity.ok(clienteDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(400, e.getMessage()));
		}
	}

	@GetMapping("findAll")
	public List<ClienteDTO> findAll() {
		List<Cliente> losClientes = clienteService.findAll();
		List<ClienteDTO> losClientesDTO = clienteMapper.toClienteDTOs(losClientes);
		return losClientesDTO;
	}

	@GetMapping("findById/{id}")
	public ClienteDTO findById(@PathVariable("id") Long id) {
		Optional<Cliente> clienteOptional = clienteService.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
			return clienteDTO;
		}
		return null;
	}

}
