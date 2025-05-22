/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiupv;

import java.util.List;         
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author alber
 */
public class ejercicios {
    private final String enunciado;
    private final List<String> respuestas;
    private final int RespuestaCorrecta;
    
    public ejercicios(String enunciado, List<String> respuestas, int RespuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestas = new ArrayList<>(respuestas);
        this.RespuestaCorrecta = RespuestaCorrecta;
    }
    
    public String getEnunciado() { return enunciado; }
    public int getRespuestaCorrecta() { return RespuestaCorrecta; }
    public List<String> getRespuestas() { return new ArrayList<>(respuestas); }
    
    public List<String> getRespuestasMezcladas() {
        List<String> respuestasMezcladas = new ArrayList<>(respuestas);
        Collections.shuffle(respuestasMezcladas);
        return respuestasMezcladas;
    }
}