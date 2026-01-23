package es.fplumara.dam1.operaciones;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperacionesTest {

    @ParameterizedTest
    @CsvSource({

            "0.0,INSUFICIENTE",
            "4.99,INSUFICIENTE",
            "5.0,APROBADO",
            "6.99,APROBADO",
            "7.0,NOTABLE",
            "8.99,NOTABLE",
            "9.0,SOBRESALIENTE",
            "10.0,SOBRESALIENTE"


    })
    @DisplayName("Comprueba las notas")
    public void clasificacionNotasValidas(double nota, String resultadoEsperado) {
        String resultado = Operaciones.calificacion(nota);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("lanza la ecxepción si la nota es menor que 0 o mayor que 10")
    public void comprobarNotasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(-2));
        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(11));


    }

}

