package es.fplumara.dam1.facturacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FacturaServiceTest {

    @Mock
    Calculadora calculadora;

    @Test
    void testTotalConIva100() {
        when(calculadora.sumar(100, 21)).thenReturn(121);

        FacturaService service = new FacturaService(calculadora);

        int resultado = service.totalConIva(100);
        assertEquals(121, resultado);

        verify(calculadora, times(1)).sumar(100, 21);
        verifyNoMoreInteractions(calculadora);
    }
}