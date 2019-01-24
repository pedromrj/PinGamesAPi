package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Usuario;
import pingamesapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> readAll() {
		return usuarioRepository.findAll();
	}

	public Usuario create(Usuario obj) {
		obj.getJogos().setUsuario(obj);
		usuarioRepository.save(obj);
		bibliotecaService.create(obj.getJogos());
		return obj;
	}

	public Usuario update(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario findOne(Long id) {
		return usuarioRepository.findById(id).get();
	}

}
