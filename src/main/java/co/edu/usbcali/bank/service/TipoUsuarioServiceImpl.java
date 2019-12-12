package co.edu.usbcali.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.bank.domain.TipoUsuario;
import co.edu.usbcali.bank.repository.TipoUsuarioRepository;

@Service
@Scope("singleton")
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<TipoUsuario> findById(Long id) {
		return tipoUsuarioRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public TipoUsuario save(TipoUsuario entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public TipoUsuario update(TipoUsuario entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(TipoUsuario entity) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		throw new UnsupportedOperationException();
	}

}
