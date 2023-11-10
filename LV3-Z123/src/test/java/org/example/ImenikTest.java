

package org.example;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Set;

public class ImenikTest {
    private Imenik imenik;
    @Mock
    private TelefonskiBroj telefonskiBrojMock;
    @BeforeEach
    public void Priprema() {
        MockitoAnnotations.openMocks(this);
        imenik = new Imenik();
    }
    @Test
    public void testDodajIDajBroj() {
        when(telefonskiBrojMock.ispisi()).thenReturn("012-3456789");
        imenik.dodaj("Adnan", telefonskiBrojMock);
        assertEquals("012-3456789", imenik.dajBroj("Adnan"));
        verify(telefonskiBrojMock).ispisi();
    }
    @Test
    public void testDajIme() {
        String ocekivani = "012-3456789";
        when(telefonskiBrojMock.ispisi()).thenReturn(ocekivani);
        imenik.dodaj("Adnan", telefonskiBrojMock);
        TelefonskiBroj BrojMock = mock(TelefonskiBroj.class);
        when(BrojMock.ispisi()).thenReturn(ocekivani);
        String result = imenik.dajIme(BrojMock);
        assertEquals("Adnan", result);
    }
}