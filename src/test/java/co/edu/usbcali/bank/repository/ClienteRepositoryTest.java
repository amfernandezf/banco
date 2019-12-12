package co.edu.usbcali.bank.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.bank.domain.Cliente;

@SpringBootTest
@Rollback(false)
class ClienteRepositoryTest {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	private final static Logger log=LoggerFactory.getLogger(ClienteRepositoryTest.class);
	
	private final static Long clieId=8080L;
	
	@Test
	@DisplayName("Save")
	void aTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		assertFalse(clienteRepository.findById(clieId).isPresent());
		
		Cliente cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("homeroj@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("555-55-555");
		
		assertTrue(tipoDocumentoRepository.findById(2L).isPresent());
		cliente.setTipoDocumento(tipoDocumentoRepository.findById(2L).get());
		
		clienteRepository.save(cliente);
	}
	
	@Test
	@DisplayName("FindbyId")
	void bTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(clieId);
		assertTrue(clienteOptional.isPresent());
		clienteOptional.ifPresent(cliente->{
			log.info(cliente.getNombre());
		});
	}
	
	@Test
	@DisplayName("Update")
	void cTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(clieId);
		assertTrue(clienteOptional.isPresent());
		Cliente cliente=clienteOptional.get();
		cliente.setActivo("N");
		
		clienteRepository.save(cliente);
	}
	
	@Test
	@DisplayName("Delete")
	void dTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(clieId);
		assertTrue(clienteOptional.isPresent());
		Cliente cliente=clienteOptional.get();
				
		clienteRepository.delete(cliente);
	}
	
	@Test
	@DisplayName("FindAll")
	void eTest() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		List<Cliente> losClientes=clienteRepository.findAll();
		assertNotNull(losClientes);
		assertFalse(losClientes.isEmpty());
		
		losClientes.forEach(cliente->{
			log.info("ID: "+cliente.getClieId());
			log.info("NOMBRE: "+cliente.getNombre());
			log.info("Email: "+cliente.getEmail());
		});
	}
	
	@Test
	@DisplayName("FindByNombre")
	void findByNombre() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		List<Cliente> losClientes=clienteRepository.findByNombre("Jerrie Cannell");
		assertNotNull(losClientes);
		assertFalse(losClientes.isEmpty());
		
		losClientes.forEach(cliente->{
			log.info("ID: "+cliente.getClieId());
			log.info("NOMBRE: "+cliente.getNombre());
		});
	}
	
	@Test
	@DisplayName("FindByTipoDocumento")
	void findTipoDocumento() {
		assertNotNull(clienteRepository);
		assertNotNull(tipoDocumentoRepository);
		
		List<Cliente> losClientes=clienteRepository.findByTipoDocumento(2L);
		assertNotNull(losClientes);
		assertFalse(losClientes.isEmpty());
		
		losClientes.forEach(cliente->{
			log.info("ID: "+cliente.getClieId());
			log.info("NOMBRE: "+cliente.getNombre());
		});
	}
}
