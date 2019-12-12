package co.edu.usbcali.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.bank.domain.TipoUsuario;
import co.edu.usbcali.bank.dto.TipoUsuarioDTO;

@Mapper
public interface TipoUsuarioMapper {

	TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario);

	TipoUsuario tipoUsuarioDTOtoTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);

	List<TipoUsuarioDTO> toTipoUsuarioDTOs(List<TipoUsuario> tipoUsuarios);

	List<TipoUsuario> toTipoUsuarios(List<TipoUsuarioDTO> tipoUsuarioDTOs);

}
