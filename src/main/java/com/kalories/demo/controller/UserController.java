package com.kalories.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kalories.demo.model.User;
import com.kalories.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/upload/csv")
    public String uploadCsvUsers(@RequestParam("file") MultipartFile file) throws Exception {
        return userService.uploadCsvUsers(file);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) throws Exception {
        if (userService.createUser(user) == 1) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.badRequest().body("User not created");
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    // Part Osama ->
    @PostMapping("/{id}/imagen")
    public ResponseEntity<String> uploadImage(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        try {
            userService.uploadImage(id, file);
            return ResponseEntity.ok("Imagen subida correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al subir la imagen");
        }
    }

    // actualizar el usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,
            @RequestParam String email,
            @RequestParam String contrasena) {
        boolean updated = userService.updateUser(id, email, contrasena);
        if (updated) {
            return ResponseEntity.ok("Usuario actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // c2 - borrar todos los usuarios
    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        userService.deleteAllUsers();
        return ResponseEntity.ok("Todos los usuarios eliminados");
    }

    // d2 - borrar usuario por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted) {
            return ResponseEntity.ok("Usuario eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
