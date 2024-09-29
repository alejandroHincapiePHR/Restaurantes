package com.gammaPedidos.Restaurantes.Restaurantes.controladores;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Restaurante;
import com.gammaPedidos.Restaurantes.Restaurantes.repositorios.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestauranteController {

    @Autowired
    private RestauranteRepositorio restauranteRepository;

    // Obtener todos los restaurantes
    @GetMapping
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    // Obtener un restaurante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        return restaurante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo restaurante
    @PostMapping
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    // Actualizar un restaurante existente
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable Long id, @RequestBody Restaurante updatedRestaurante) {
        Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(id);

        if (optionalRestaurante.isPresent()) {
            Restaurante existingRestaurante = optionalRestaurante.get();
            existingRestaurante.setNombre(updatedRestaurante.getNombre());
            existingRestaurante.setEmail(updatedRestaurante.getEmail());
            return ResponseEntity.ok(restauranteRepository.save(existingRestaurante));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un restaurante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

