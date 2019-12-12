package co.edu.usbcali.bank.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.bank.domain.Cliente;
import co.edu.usbcali.bank.domain.TipoDocumento;
import co.edu.usbcali.bank.repository.TipoDocumentoRepository;

@SpringBootTest
@Rollback
class ClienteServiceTest {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	private final static Logger log=LoggerFactory.getLogger(ClienteServiceTest.class);
	
	private final static Long clieId=8080L;

	@Test
	@DisplayName("Save")
	void atest() {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoRepository);
		
		Cliente cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("homeroj@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("555-55-555");
		
		Optional<TipoDocumento> tipoDocumentoOptional=tipoDocumentoRepository.findById(2L);
		
		assertTrue(tipoDocumentoOptional.isPresent());
		cliente.setTipoDocumento(tipoDocumentoOptional.get());
		
		try {
			cliente=clienteService.save(cliente);
			assertNotNull(cliente, "No retorno el cliente");
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Update")
	void btest() {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoRepository);
		
		Optional<Cliente> optionalCliente=clienteService.findById(clieId);
		assertTrue(optionalCliente.isPresent(), "El cliente no existe");
		
		Cliente cliente = optionalCliente.get();
		cliente.setActivo("N");		
		
		try {
			cliente=clienteService.update(cliente);
			assertNotNull(cliente, "No retorno el cliente");
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	@Test
	@DisplayName("delete")
	void dtest() {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoRepository);
		
		Optional<Cliente> optionalCliente=clienteService.findById(clieId);
		assertTrue(optionalCliente.isPresent(), "El cliente no existe");
		
		Cliente cliente = optionalCliente.get();		
		
		try {
			clienteService.delete(cliente);
		} catch (Exception e) {
			assertNull(e, e.getMessage());
		}
	}
	
	@Test
	@DisplayName("findById")
	void ctest() {
		assertNotNull(clienteService);
		assertNotNull(tipoDocumentoRepository);
		assertNotNull(clienteService.findById(clieId).get(), "El cliente no Existe");		
	}
	
	@Test
	@DisplayName("findAll")
	void etest() {
		assertNotNull(clienteService);
		List<Cliente> losClientes=clienteService.findAll();
		assertNotNull(losClientes, "La lista es nula");
		assertFalse(losClientes.isEmpty(), "No existe clientes la lista esta vacia");		
	}


}
