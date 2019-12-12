package co.edu.usbcali.bank.mapper;

import co.edu.usbcali.bank.domain.TipoDocumento;
import co.edu.usbcali.bank.dto.TipoDocumentoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {

    @Override
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(TipoDocumento tipoDocumento) {
        if ( tipoDocumento == null ) {
            return null;
        }

        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

        tipoDocumentoDTO.setTdocId( tipoDocumento.getTdocId() );
        tipoDocumentoDTO.setActivo( tipoDocumento.getActivo() );
        tipoDocumentoDTO.setFechaCreacion( tipoDocumento.getFechaCreacion() );
        tipoDocumentoDTO.setFechaModificacion( tipoDocumento.getFechaModificacion() );
        tipoDocumentoDTO.setNombre( tipoDocumento.getNombre() );
        tipoDocumentoDTO.setUsuCreador( tipoDocumento.getUsuCreador() );
        tipoDocumentoDTO.setUsuModificador( tipoDocumento.getUsuModificador() );

        return tipoDocumentoDTO;
    }

    @Override
    public TipoDocumento tipoDocumentoDTOtoTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
        if ( tipoDocumentoDTO == null ) {
            return null;
        }

        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setTdocId( tipoDocumentoDTO.getTdocId() );
        tipoDocumento.setActivo( tipoDocumentoDTO.getActivo() );
        tipoDocumento.setFechaCreacion( tipoDocumentoDTO.getFechaCreacion() );
        tipoDocumento.setFechaModificacion( tipoDocumentoDTO.getFechaModificacion() );
        tipoDocumento.setNombre( tipoDocumentoDTO.getNombre() );
        tipoDocumento.setUsuCreador( tipoDocumentoDTO.getUsuCreador() );
        tipoDocumento.setUsuModificador( tipoDocumentoDTO.getUsuModificador() );

        return tipoDocumento;
    }

    @Override
    public List<TipoDocumentoDTO> toTipoDocumentoDTOs(List<TipoDocumento> tipoDocumentos) {
        if ( tipoDocumentos == null ) {
            return null;
        }

        List<TipoDocumentoDTO> list = new ArrayList<TipoDocumentoDTO>( tipoDocumentos.size() );
        for ( TipoDocumento tipoDocumento : tipoDocumentos ) {
            list.add( tipoDocumentoToTipoDocumentoDTO( tipoDocumento ) );
        }

        return list;
    }

    @Override
    public List<TipoDocumento> toTipoDocumentos(List<TipoDocumentoDTO> tipoDocumentoDTOs) {
        if ( tipoDocumentoDTOs == null ) {
            return null;
        }

        List<TipoDocumento> list = new ArrayList<TipoDocumento>( tipoDocumentoDTOs.size() );
        for ( TipoDocumentoDTO tipoDocumentoDTO : tipoDocumentoDTOs ) {
            list.add( tipoDocumentoDTOtoTipoDocumento( tipoDocumentoDTO ) );
        }

        return list;
    }
}
