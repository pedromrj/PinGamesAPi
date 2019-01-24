package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Biblioteca;
import pingamesapi.domain.Usuario;
import pingamesapi.dto.CadastraUsuario;
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

	public Usuario create(CadastraUsuario userDTO) {
		Usuario user = fromDTO(userDTO);
		Biblioteca jogos = new Biblioteca();
		user.setJogos(jogos);
		bibliotecaService.create(jogos);
		return usuarioRepository.save(user);
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
	
	private Usuario fromDTO(CadastraUsuario obj) {
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setCpf(obj.getCpf());
		user.setDataNascimento(obj.getDataNascimento());
		return user;
	}

}
