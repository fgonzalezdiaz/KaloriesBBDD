package com.kalories.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kalories.demo.logging.CustomLogging;
import com.kalories.demo.model.User;
import com.kalories.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        CustomLogging.info("Consultant tots els users", "UserService", "findAll");
        return userRepository.findAll();
    }

    public User findById(Long id) {
        CustomLogging.info("Consultant user per id", "UserService", "findById");
        List<User> users = userRepository.findById(id);
        if (users.isEmpty()) {
            CustomLogging.error("L'usuari amb id = " + id + " no existeix", "UserSerice", "findOne");
            return null;
        }
        return users.get(0);
    }

    public int createUser(User user) throws Exception {
        CustomLogging.info("Creant user", "UserService", "createUser");
        return userRepository.save(user);
    }

    public String uploadCsvUsers(MultipartFile csvFile) throws Exception {
        int usersCreats = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arguments = line.split(",");
                // Cambiar el formato de las entradas arguments

                usersCreats += userRepository.save(new User(Long.parseLong(arguments[0]), arguments[1], arguments[2],
                        arguments[3], LocalDate.parse(arguments[4]), Integer.parseInt(arguments[5]),
                        BigDecimal.valueOf(Long.parseLong(arguments[6])), Integer.parseInt(arguments[7]),
                        Integer.parseInt(arguments[8]), arguments[9]));
            }
            CustomLogging.info("S'han creat " + usersCreats + " usuaris", "UserService", "uploadCsvUsers");
            return "S'han creat " + usersCreats + " usuaris";
        } catch (Exception e) {
            CustomLogging.error("Error al importar els usuaris: " + e.getMessage(), "UserService", "uploadCsvUsers");
            return "Error al importar els usuaris: " + e.getMessage();
        }
    }

    // Parte Osama //
    public void uploadImage(long id, MultipartFile file) throws Exception {
        File uploadsDir = new File("uploads");
        if (!uploadsDir.exists())
            uploadsDir.mkdir();

        String filePath = "uploads/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        CustomLogging.info("Imagen subida correctamente", "UserService", "uploadImage");

        userRepository.addImagePath(id, filePath);
    }

    // Actualizar usuario
    public boolean updateUser(long id, String email, String contrasena) {
        int updated = userRepository.updateUser(id, email, contrasena);
        if (updated == 1) {
            CustomLogging.info("Usuario actualizado correctamente", "UserService", "updateUser");
            return true;
        } else {
            CustomLogging.warning("Intento de actualización de usuario con id " + id + " que no existe", "UserService",
                    "updateUser");
            return false;
        }
    }

    // Borrar todos los usuarios
    public int deleteAllUsers() {

        int deleted = userRepository.deleteAll();
        if (deleted > 0) {
            CustomLogging.info("Todos los usuarios eliminados", "UserService", "deleteAllUsers");
        } else {
            CustomLogging.error("No se han encontrado usuarios para eliminar", "UserService", "deleteAllUsers");
        }
        return deleted;
    }

    // Borrar usuario por id
    public boolean deleteUserById(long id) {
        int deleted = userRepository.deleteById(id);
        if (deleted > 0) {
            CustomLogging.info("Usuario con id " + id + " eliminado", "UserService", "deleteUserById");
            return true;

        } else {
            CustomLogging.warning("Intento de eliminación de usuario con id " + id + " que no existe", "UserService",
                    "deleteUserById");
            return false;
        }
    }
}
