package Torneo.Futbol.Controlador;

import Torneo.Futbol.Modelo.Pais;
import Torneo.Futbol.Repositorio.PaisRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PaisControllerTest {
    @Mock
    PaisRepositorio paisRepositorio;
    @InjectMocks
    private PaisController paisController;
    private Pais pais;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pais=new Pais();
        pais.setNombre();
        pais.setId();
        //commit

    }

    @Test
    void listarPaises() {
        when(PaisRepositorio.findAll()).thenReturn()
    }
}