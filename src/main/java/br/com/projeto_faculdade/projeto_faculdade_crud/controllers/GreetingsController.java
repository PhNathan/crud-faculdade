package br.com.projeto_faculdade.projeto_faculdade_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_faculdade.projeto_faculdade_crud.model.Usuario;
import br.com.projeto_faculdade.projeto_faculdade_crud.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
		@Autowired
		private UsuarioRepository usuarioRepository;
	
    
    
    
    /*Listar*/
    @GetMapping(value = "listatodos")/*Metodo listar usuarios*/
    @ResponseBody /*Devolve os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listaUsuarios(){
    	List<Usuario> usuarios =  usuarioRepository.findAll();/*consulta no bd*/
    	
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);/*Retorna lista JSON*/
    }
    
    
    /*Cadastrar*/
    @PostMapping(value = "cadastrar")/*Mapeia a url post*/
    @ResponseBody/*Descreve a resposta*/
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){/*Recebe os dados para salvar*/
    	
    	Usuario user = usuarioRepository.save(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }
    
    
    /*Deletar*/
    
    @DeleteMapping(value = "deletar")/*Mapeia a url post*/
    @ResponseBody/*Descreve a resposta*/
    public ResponseEntity<String> deletar(@RequestParam Long iduser){/*Recebe os dados para deletar*/
    	
    	usuarioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    }
    
    /*Buscar*/
    
    
    @GetMapping(value = "buscaruser")/*Mapeia a url post*/
    @ResponseBody/*Descreve a resposta*/
    public ResponseEntity<Usuario> buscaruser(@RequestParam(name = "iduser") Long iduser){/*Recebe os dados para buscar*/
    	
    	Usuario usuario = usuarioRepository.findById(iduser).get();/*busca usuario por id*/
    	
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    
    /*atualizar*/
    
    @PutMapping(value = "atualizar")/*Mapeia a url post*/
    @ResponseBody/*Descreve a resposta*/
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){/*Recebe os dados para atualizar*/
    	
    	if (usuario.getId() == null) {/*Válida se o id esta sendo passado*/
    		return new ResponseEntity<String>("id obrigatório", HttpStatus.OK);
		}
    	
    	Usuario user = usuarioRepository.saveAndFlush(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }
    
    
    /*busca por nome*/

    @GetMapping(value = "buscarnome")/*Mapeia a url get*/
    @ResponseBody/*Descreve a resposta*/
    public ResponseEntity<List<Usuario>> buscarnome(@RequestParam(name = "name") String name){/*Recebe os dados para buscar por nome*/
    	
    	List<Usuario> usuario = usuarioRepository.buscarNome(name.trim().toUpperCase());/*busca usuario por nome*/
    	
    	return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    }
    
    
}
