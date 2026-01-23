package es.fplumara.dam1.operaciones;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;



import static org.junit.jupiter.api.Assertions.*;

class OperacionesMediaTest {
    static Stream<Arguments> datosMedia() {
        return Stream.of(
                Arguments.of(new double[]{5.0}, 5.0),
                Arguments.of(new double[]{5.0, 7.0}, 6.0),
                Arguments.of(new double[]{0.0, 0.0, 0.0}, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("datosMedia")
    @DisplayName("Prueba de medias con varios valores")
    void testMedia(double[] notas, double esperado) {
        double resultado = Operaciones.media(notas);
        Assertions.assertEquals(esperado, resultado, 0.0001);
    }

    @Test
    @DisplayName("Prueba varias medias con assertAll")
    void testVariasMedias() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(6.0, Operaciones.media(5.0, 7.0), 0.0001),
                () -> Assertions.assertEquals(10.0, Operaciones.media(10.0), 0.0001),
                () -> Assertions.assertEquals(0.0, Operaciones.media(0.0, 0.0, 0.0), 0.0001)
        );
    }

    @Test
    @DisplayName("Error si no se pasan notas")
    void testSinNotas() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Operaciones.media());
    }

    @Test
    @DisplayName("Error si las notas son null")
    void testNotasNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Operaciones.media((double[]) null));


    }
}