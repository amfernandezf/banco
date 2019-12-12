package co.edu.usbcali.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.bank.domain.TipoDocumento;
import co.edu.usbcali.bank.repository.TipoDocumentoRepository;

@Service
@Scope("singleton")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoDocumento> findById(Long id) {
		return tipoDocumentoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public TipoDocumento save(TipoDocumento entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public TipoDocumento update(TipoDocumento entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(TipoDocumento entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		throw new UnsupportedOperationException();
	}

}
