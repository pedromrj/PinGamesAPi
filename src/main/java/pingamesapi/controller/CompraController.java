package pingamesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pingamesapi.domain.Compra;
import pingamesapi.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Compra> findOne(@PathVariable Long id){
		return new ResponseEntity<Compra>(compraService.findOne(id), HttpStatus.OK);
	}

	@PostMapping(path = "/nova")
	public ResponseEntity<Compra> create(@RequestBody Compra obj) {
		return new ResponseEntity<Compra>(compraService.create(obj), HttpStatus.CREATED);
	}
}
