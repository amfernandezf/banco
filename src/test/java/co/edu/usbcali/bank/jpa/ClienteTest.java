package co.edu.usbcali.bank.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.bank.domain.Cliente;
import co.edu.usbcali.bank.domain.TipoDocumento;

@SpringBootTest
@Rollback(false)
class ClienteTest {
	
	private final static Long clieId=142010L;
	
	private final static Logger log=LoggerFactory.getLogger(ClienteTest.class);						
	
	@Autowired
	private EntityManager entityManager;	

	@Test
	@DisplayName("Save")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	void aTest() {
		assertNotNull(entityManager);
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNull(cliente, "EL cliente ya existe");
		cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("homeroj@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("555-55-555");
		
		TipoDocumento tipoDocumento=entityManager.find(TipoDocumento.class, 1L);
		assertNotNull(tipoDocumento, "El tipo de docuemnto no existe");
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.persist(cliente);		
	}
	
	@Test
	@DisplayName("findById")
	@Transactional(readOnly = true)
	void bTest() {
		assertNotNull(entityManager);
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "EL cliente ya existe");
		
		log.info(cliente.getNombre());
		log.info(cliente.getEmail());
	}
	
	@Test
	@DisplayName("Update")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	void cTest() {
		assertNotNull(entityManager);
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "EL cliente ya existe");
		
		cliente.setActivo("N");
		entityManager.merge(cliente);
	}
	
	@Test
	@DisplayName("Delete")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	void dTest() {
		assertNotNull(entityManager);
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "EL cliente ya existe");
		
		entityManager.remove(cliente);
	}
	
	@Test
	@DisplayName("findAll")
	@Transactional(readOnly = true)
	void eTest() {
		assertNotNull(entityManager);
		String jpql="SELECT cli FROM Cliente cli";
		List<Cliente> losClientes=entityManager.createQuery(jpql).getResultList();
		
		for (Cliente cliente : losClientes) {
			log.info("ID: "+cliente.getClieId());
			log.info("NOMBRE: "+cliente.getNombre());
		}
		
		losClientes.forEach(cliente->{
			log.info("ID: "+cliente.getClieId());
			log.info("NOMBRE: "+cliente.getNombre());
		});
	}	
}
