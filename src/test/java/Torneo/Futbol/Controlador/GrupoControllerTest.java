package Torneo.Futbol.Controlador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GrupoControllerTest {

    @BeforeEach
    void setUp() {
        System.out.println("antes de");
    }

    @Test
    void listarGrupo() {
        System.out.println("durante");
    }
}