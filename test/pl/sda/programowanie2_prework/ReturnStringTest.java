package pl.sda.programowanie2_prework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReturnStringTest {
    private ReturnString test;

    @BeforeEach
    public void setup() {
        test = new ReturnString();
    }


    @Test
    void splitText() {
        assertEquals("Ala Ma Kota",test.buildAString("ala ma kota"));
    }

    @Test
    void splitTextFromUpperCase() {
        assertEquals("Ala Ma Kota",test.buildAString("Ala Ma Kota"));
    }

    @Test
    void splitTextOneWord() {
        assertEquals("Banan",test.buildAString("banan"));
    }

    @Test
    void splitTextNull() {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() {
                test.buildAString(null);
            }
        });;
    }

    @Test
    void splitTextNullEmpty() {
        assertEquals("", test.buildAString(""));
    }

@Test
    void typicalString() {
        assertEquals("Szklarska Poreba",test.buildAString("szklarska poreba"));
}

    @Test
    void StringWithSeparator() {
        assertEquals("Kędzierzyn - Koźle",test.buildAString("kędzierzyn - koźle"));
    }

    @Test
    void nameWithSeparator() {
        assertEquals("Walaszko - Nowicka",test.buildAString("walaszko-nowicka"));
    }

    @Test
    void nameWithBothSeparators() {
        assertEquals("Zenek Dąbrowkski - Nowakowski",test.buildAString("Zenek Dąbrowkski - Nowakowski"));
    }
}
