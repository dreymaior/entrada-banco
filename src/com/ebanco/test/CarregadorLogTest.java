package com.ebanco.test;

import com.ebanco.controller.CarregadorLog;

import static org.junit.jupiter.api.Assertions.*;

class CarregadorLogTest {

    @org.junit.jupiter.api.Test
    void testValidarFormato1() {
        String s = "[2018-11-20 09:15:14] - Abertura da Porta OK";
        boolean retornoEsperado = true;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato2() {
        String s = "[09:15:14 2018-11-20] - Abertura da Porta OK";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato3() {
        String s = "[09:15:14 2018-11-20] - Alguma coisa OK";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato4() {
        String s = "[09:15:14 2018-11-20] OK";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato5() {
        String s = "OK";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato6() {
        String s = "";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testValidarFormato7() {
        String s = "[2018-11-20 09:15:14] - Abertura da Porta OK\n[2018-11-20 09:15:14] - Abertura da Porta OK";
        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().validarFormato(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente1() {
        String s = "[2018-11-20 09:59:59] - Abertura da Porta OK";

        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente2() {
        String s = "[2018-11-20 10:00:00] - Abertura da Porta OK";

        boolean retornoEsperado = true;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente3() {
        String s = "[2018-11-20 10:00:01] - Abertura da Porta OK";

        boolean retornoEsperado = true;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente4() {
        String s = "[2018-11-20 15:59:59] - Abertura da Porta OK";

        boolean retornoEsperado = true;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente5() {
        String s = "[2018-11-20 16:00:00] - Abertura da Porta OK";

        boolean retornoEsperado = true;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

    @org.junit.jupiter.api.Test
    void testVerificaExpediente6() {
        String s = "[2018-11-20 16:00:01] - Abertura da Porta OK";

        boolean retornoEsperado = false;

        boolean retornoObtido = new CarregadorLog().verificaExpediente(s);

        assertEquals(retornoEsperado, retornoObtido);
    }

}