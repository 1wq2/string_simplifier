import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    Simplifier simple = new Simplifier();

    @Test
    public void testRemoveC() throws Exception {
        String str = "success";
        simple.removeC(str);
        assertEquals("suksess", simple.str1);
    }

    @Test
    public void testRemoveDouble() throws Exception {
        String str1 = "ooo oou iee";
        simple.removeDouble(str1);
        assertEquals("uo u i", simple.str2);
    }

    @Test
    public void testRemoveE() throws Exception {
        String str2 = "The";
        simple.removeE(str2);
        assertEquals("Th", simple.str3);
    }

    @Test
    public void testRemoveArt() throws Exception {
        String str = "the table";
        String str3 = "th tabl";
        simple.removeArt(str3, str);
        assertEquals("tabl", simple.str4.toString().trim());
    }
}
