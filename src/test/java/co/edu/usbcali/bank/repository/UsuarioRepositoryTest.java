package co.edu.usbcali.bank.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.bank.domain.Usuario;

@SpringBootTest
@Rollback(false)
class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	private final static Logger log = LoggerFactory.getLogger(UsuarioRepositoryTest.class);
	
	private final static String usuUsuario = "tatimonc";
	
	@Test
	@DisplayName("save")
	void aTest() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		assertFalse(usuarioRepository.findById(usuUsuario).isPresent());
		
		Usuario usuario = new Usuario();
		usuario.setUsuUsuario(usuUsuario);
		usuario.setIdentificacion(new BigDecimal(1004));
		usuario.setClave("7nh8wq2");
		usuario.setNombre("Tatiana Moncada");
		usuario.setActivo("S");
		
		assertTrue(tipoUsuarioRepository.findById(1L).isPresent());
		usuario.setTipoUsuario(tipoUsuarioRepository.findById(1L).get());
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("findById")
	void bTest() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuUsuario);
		assertTrue(usuarioOptional.isPresent());
		usuarioOptional.ifPresent(usuario->{
			log.info("Nombre: " + usuario.getNombre());
		});
	}
	
	@Test
	@DisplayName("update")
	void cTest() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuUsuario);
		assertTrue(usuarioOptional.isPresent());
		Usuario usuario = usuarioOptional.get();
		usuario.setClave("3lk9gf0");;
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("delete")
	void dTest() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuUsuario);
		assertTrue(usuarioOptional.isPresent());
		Usuario usuario = usuarioOptional.get();
		
		usuarioRepository.delete(usuario);
	}
	
	@Test
	@DisplayName("findAll")
	void eTest() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		
		List<Usuario> losUsuarios = usuarioRepository.findAll();
		assertNotNull(losUsuarios);
		assertFalse(losUsuarios.isEmpty());
		
		losUsuarios.forEach(usuario->{
			log.info("Usuario: " + usuario.getUsuUsuario());
			log.info("Nombre: " + usuario.getNombre());
		});
				
		
	}
	
	@Test
	@DisplayName("findByIdentificacion")
	void findByIdentificacion() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		
		List<Usuario> losUsuarios = usuarioRepository.findByIdentificacion(new BigDecimal(221));
		assertNotNull(losUsuarios);
		assertFalse(losUsuarios.isEmpty());
		
		losUsuarios.forEach(usuario->{
			log.info("Usuario: " + usuario.getUsuUsuario());
			log.info("Nombre: " + usuario.getNombre());
		});
				
		
	}
	
	@Test
	@DisplayName("findByTipoUsuarioAndIdentificacion")
	void findByTipoUsuarioAndIdentificacion() {
		assertNotNull(usuarioRepository);
		assertNotNull(tipoUsuarioRepository);
		
		List<Usuario> losUsuarios = usuarioRepository.findByTipoUsuarioAndIdentificacion(1L, (new BigDecimal(189)));
		assertNotNull(losUsuarios);
		assertFalse(losUsuarios.isEmpty());
		
		losUsuarios.forEach(usuario->{
			log.info("Usuario: " + usuario.getUsuUsuario());
			log.info("Nombre: " + usuario.getNombre());
		});
				
		
	}

}
