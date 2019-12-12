package co.edu.usbcali.bank.mapper;

import co.edu.usbcali.bank.domain.TipoUsuario;
import co.edu.usbcali.bank.dto.TipoUsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class TipoUsuarioMapperImpl implements TipoUsuarioMapper {

    @Override
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

        tipoUsuarioDTO.setTiusId( tipoUsuario.getTiusId() );
        tipoUsuarioDTO.setActivo( tipoUsuario.getActivo() );
        tipoUsuarioDTO.setFechaCreacion( tipoUsuario.getFechaCreacion() );
        tipoUsuarioDTO.setFechaModificacion( tipoUsuario.getFechaModificacion() );
        tipoUsuarioDTO.setNombre( tipoUsuario.getNombre() );
        tipoUsuarioDTO.setUsuCreador( tipoUsuario.getUsuCreador() );
        tipoUsuarioDTO.setUsuModificador( tipoUsuario.getUsuModificador() );

        return tipoUsuarioDTO;
    }

    @Override
    public TipoUsuario tipoUsuarioDTOtoTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        if ( tipoUsuarioDTO == null ) {
            return null;
        }

        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setTiusId( tipoUsuarioDTO.getTiusId() );
        tipoUsuario.setActivo( tipoUsuarioDTO.getActivo() );
        tipoUsuario.setFechaCreacion( tipoUsuarioDTO.getFechaCreacion() );
        tipoUsuario.setFechaModificacion( tipoUsuarioDTO.getFechaModificacion() );
        tipoUsuario.setNombre( tipoUsuarioDTO.getNombre() );
        tipoUsuario.setUsuCreador( tipoUsuarioDTO.getUsuCreador() );
        tipoUsuario.setUsuModificador( tipoUsuarioDTO.getUsuModificador() );

        return tipoUsuario;
    }

    @Override
    public List<TipoUsuarioDTO> toTipoUsuarioDTOs(List<TipoUsuario> tipoUsuarios) {
        if ( tipoUsuarios == null ) {
            return null;
        }

        List<TipoUsuarioDTO> list = new ArrayList<TipoUsuarioDTO>( tipoUsuarios.size() );
        for ( TipoUsuario tipoUsuario : tipoUsuarios ) {
            list.add( tipoUsuarioToTipoUsuarioDTO( tipoUsuario ) );
        }

        return list;
    }

    @Override
    public List<TipoUsuario> toTipoUsuarios(List<TipoUsuarioDTO> tipoUsuarioDTOs) {
        if ( tipoUsuarioDTOs == null ) {
            return null;
        }

        List<TipoUsuario> list = new ArrayList<TipoUsuario>( tipoUsuarioDTOs.size() );
        for ( TipoUsuarioDTO tipoUsuarioDTO : tipoUsuarioDTOs ) {
            list.add( tipoUsuarioDTOtoTipoUsuario( tipoUsuarioDTO ) );
        }

        return list;
    }
}
