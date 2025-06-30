
import com.ecomarket.user_service.controller.UsuarioController;
import com.ecomarket.user_service.model.Usuario;
import com.ecomarket.user_service.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testListarUsuarios() throws Exception {
        Usuario usuario = new Usuario(1, "12345678-9", "Juan", "Pérez", "juan@example.com");
        Mockito.when(usuarioService.findAll()).thenReturn(Arrays.asList(usuario));

        mockMvc.perform(get("/api/v1/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("Juan")));
    }

    @Test
    void testListarUsuariosVacio() throws Exception {
        Mockito.when(usuarioService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/usuarios"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGuardarUsuario() throws Exception {
        Usuario usuario = new Usuario(null, "98765432-1", "Ana", "Gómez", "ana@example.com");
        Usuario guardado = new Usuario(2, "98765432-1", "Ana", "Gómez", "ana@example.com");

        Mockito.when(usuarioService.save(Mockito.any(Usuario.class))).thenReturn(guardado);

        mockMvc.perform(post("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nombre", is("Ana")));
    }

    @Test
    void testBuscarUsuarioExistente() throws Exception {
        Usuario usuario = new Usuario(1, "12345678-9", "Juan", "Pérez", "juan@example.com");
        Mockito.when(usuarioService.findById(1)).thenReturn(usuario);

        mockMvc.perform(get("/api/v1/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Juan")));
    }

    @Test
    void testBuscarUsuarioNoExistente() throws Exception {
        Mockito.when(usuarioService.findById(99)).thenThrow(new RuntimeException("No encontrado"));

        mockMvc.perform(get("/api/v1/usuarios/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testActualizarUsuario() throws Exception {
        Usuario usuarioExistente = new Usuario(1, "11111111-1", "Pedro", "Soto", "pedro@correo.com");
        Usuario actualizado = new Usuario(1, "22222222-2", "Luis", "Mena", "luis@correo.com");

        Mockito.when(usuarioService.findById(1)).thenReturn(usuarioExistente);
        Mockito.when(usuarioService.save(Mockito.any(Usuario.class))).thenReturn(actualizado);

        mockMvc.perform(put("/api/v1/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(actualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Luis")));
    }

    @Test
    void testEliminarUsuario() throws Exception {
        Mockito.doNothing().when(usuarioService).delete(1L);

        mockMvc.perform(delete("/api/v1/usuarios/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testEliminarUsuarioNoExistente() throws Exception {
        Mockito.doThrow(new RuntimeException("No encontrado")).when(usuarioService).delete(99L);

        mockMvc.perform(delete("/api/v1/usuarios/99"))
                .andExpect(status().isNotFound());
    }
}
