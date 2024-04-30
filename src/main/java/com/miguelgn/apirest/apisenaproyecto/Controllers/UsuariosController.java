package com.miguelgn.apirest.apisenaproyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelgn.apirest.apisenaproyecto.Repositories.UsuariosRepository;
import com.miguelgn.apirest.apisenaproyecto.Entities.Usuarios;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



;;

@RestController
@RequestMapping ("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository usuariosRepository;


    @GetMapping 
    public List <Usuarios> getAllUsuarios(){

        return usuariosRepository.findAll();
    }

    @GetMapping("/buscarxid/{id}")
    public Usuarios getUsuarioXid( @PathVariable Long id) {
        
        return  usuariosRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el usuario por id"));
}

    @PostMapping("/crear")
    public Usuarios createUsuarios(@RequestBody Usuarios usuario) {

        return usuariosRepository.save(usuario);
    }

    @PutMapping("/actualizar/{id}")

    public Usuarios updateUsuarios(@PathVariable Long id, @RequestBody Usuarios detailsUsuario) {
        //TODO: process PUT request
        
        Usuarios usuarios=  usuariosRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el usuario a actualizar por id"));
        usuarios.setNombre(detailsUsuario.getNombre());
        usuarios.setApellido(detailsUsuario.getApellido());

        return usuariosRepository.save(usuarios);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){

        Usuarios usuarios = usuariosRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el usuario a eliminar"));

        usuariosRepository.delete(usuarios);

        return "El usuario fue eliminado correctamente";


    } 
    

}
