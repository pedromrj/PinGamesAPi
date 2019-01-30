package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.controller.exceptions.ErrorValidacao;
import pingamesapi.domain.Biblioteca;
import pingamesapi.domain.Usuario;
import pingamesapi.dto.Cadastra.CadastraUsuario;
import pingamesapi.dto.Read.ReadUsuario;
import pingamesapi.repository.UsuarioRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;
import pingamesapi.service.exceptions.ValidacaoException;
import pingamesapi.service.utils.CpfAndCnpj;

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
		ValidUser(userDTO);
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

	private ReadUsuario buildDTO(Usuario usuario) {
		ModelMapper model = new ModelMapper();
		ReadUsuario user = model.map(usuario, ReadUsuario.class);
		return user;
	}

	private Usuario fromDTO(CadastraUsuario obj) {
		ModelMapper model = new ModelMapper();
		Usuario user = model.map(obj, Usuario.class);
		return user;
	}

	private boolean heInteiro(String cpf) {
		char[] letra = cpf.toCharArray();
		for (int i = 0; i < letra.length; i++) {
			if (Character.isDigit(letra[i])) {
				return false;
			}
		}
		return true;
	}

	private boolean ValidUser(CadastraUsuario userDTO) {
		List<ErrorValidacao> erros = new ArrayList<ErrorValidacao>();
		if (!heInteiro(userDTO.getNome())) {
			erros.add(new ErrorValidacao("NOME", "SÓ LETRAS"));
		}
		if (heInteiro(userDTO.getCpf())) {
			erros.add(new ErrorValidacao("CPF", "SÓ NUMEROS!!"));
		}
		if (!CpfAndCnpj.ValidCpf(userDTO.getCpf())) {
			erros.add(new ErrorValidacao("CPF", "CPF É INVALIDO!!"));
		}

		if (erros.size() != 0) {
			throw new ValidacaoException(erros, "ERROS DE PARAMETROS!!");
		}
		return true;
	}
}