package co.edu.usbcali.bank.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.bank.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	List<Usuario> findByIdentificacion(BigDecimal identificacion);
	
	@Query("SELECT usu FROM Usuario usu WHERE usu.tipoUsuario.tiusId=?1 and usu.identificacion=?2")
	List<Usuario> findByTipoUsuarioAndIdentificacion(Long id, BigDecimal identificacion);

}
