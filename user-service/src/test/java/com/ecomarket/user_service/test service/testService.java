import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecomarket.user_service.model.Usuario;
import com.ecomarket.user_service.repository.UsuarioRepository;
import com.ecomarket.user_service.service.UsuarioService;

class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        final List<Usuario> usuarios = List.of(new Usuario(), new Usuario());
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        final List<Usuario> result = usuarioService.findAll();

        assertEquals(2, result.size());
        verify(usuarioRepository).findAll();
    }

    @Test
    void testFindById() {
        final Usuario usuario = new Usuario();
        usuario.setId(1);  // Usar Integer para id
        when(usuarioRepository.findById((long) 1)).thenReturn(Optional.of(usuario));

        final Usuario result = usuarioService.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(usuarioRepository).findById((long) 1);
    }

}


