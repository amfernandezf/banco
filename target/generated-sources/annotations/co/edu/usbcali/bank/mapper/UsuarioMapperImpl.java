package co.edu.usbcali.bank.mapper;

import co.edu.usbcali.bank.domain.TipoUsuario;
import co.edu.usbcali.bank.domain.Usuario;
import co.edu.usbcali.bank.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setTiusId( usuarioTipoUsuarioTiusId( usuario ) );
        usuarioDTO.setUsuUsuario( usuario.getUsuUsuario() );
        usuarioDTO.setActivo( usuario.getActivo() );
        usuarioDTO.setClave( usuario.getClave() );
        usuarioDTO.setFechaCreacion( usuario.getFechaCreacion() );
        usuarioDTO.setFechaModificacion( usuario.getFechaModificacion() );
        usuarioDTO.setIdentificacion( usuario.getIdentificacion() );
        usuarioDTO.setNombre( usuario.getNombre() );
        usuarioDTO.setUsuCreador( usuario.getUsuCreador() );
        usuarioDTO.setUsuModificador( usuario.getUsuModificador() );

        return usuarioDTO;
    }

    @Override
    public Usuario UsuarioDTOtoUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setTipoUsuario( usuarioDTOToTipoUsuario( usuarioDTO ) );
        usuario.setUsuUsuario( usuarioDTO.getUsuUsuario() );
        usuario.setActivo( usuarioDTO.getActivo() );
        usuario.setClave( usuarioDTO.getClave() );
        usuario.setFechaCreacion( usuarioDTO.getFechaCreacion() );
        usuario.setFechaModificacion( usuarioDTO.getFechaModificacion() );
        usuario.setIdentificacion( usuarioDTO.getIdentificacion() );
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setUsuCreador( usuarioDTO.getUsuCreador() );
        usuario.setUsuModificador( usuarioDTO.getUsuModificador() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toUsuariosDTOs(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( usuarioToUsuarioDTO( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toUsuarios(List<UsuarioDTO> usuariosDTOs) {
        if ( usuariosDTOs == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( usuariosDTOs.size() );
        for ( UsuarioDTO usuarioDTO : usuariosDTOs ) {
            list.add( UsuarioDTOtoUsuario( usuarioDTO ) );
        }

        return list;
    }

    private Long usuarioTipoUsuarioTiusId(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        if ( tipoUsuario == null ) {
            return null;
        }
        Long tiusId = tipoUsuario.getTiusId();
        if ( tiusId == null ) {
            return null;
        }
        return tiusId;
    }

    protected TipoUsuario usuarioDTOToTipoUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setTiusId( usuarioDTO.getTiusId() );

        return tipoUsuario;
    }
}
