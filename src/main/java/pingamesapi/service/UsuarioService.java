package pingamesapi.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Biblioteca;
import pingamesapi.domain.Usuario;
import pingamesapi.dto.Cadastra.CadastraUsuario;
import pingamesapi.repository.UsuarioRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private BibliotecaService bibliotecaService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> readAll() {
		return usuarioRepository.findAll();
	}

	public Usuario create(CadastraUsuario userDTO) {
		Usuario user = fromDTO(userDTO);
		Biblioteca jogos = new Biblioteca();
		user.setBiblioteca(jogos);
		bibliotecaService.create(jogos);
		return usuarioRepository.save(user);
	}

	public Usuario update(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	public Usuario findOne(Long id) {
		if (usuarioRepository.existsById(id)) {
			return usuarioRepository.findById(id).get();
		}
		throw new ObjectNotFoundException("Usuario não encotrada! id:" + id + ", Tipo:" + Usuario.class.getName());
	}

	public Usuario findById(Long id) {
		if (usuarioRepository.existsById(id)) {
			return usuarioRepository.findById(id).get();
		}
		throw new ObjectNotFoundException("Usuario não encotrada! id:" + id + ", Tipo:" + Usuario.class.getName());
	}

	private Usuario fromDTO(CadastraUsuario obj) {
		ModelMapper model = new ModelMapper();
		Usuario user = model.map(obj, Usuario.class);
		return user;
	}
}