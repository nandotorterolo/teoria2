package org.ucu.teoria2.actividad3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Teoria de la Computación y sistemas formales.
 * Actividad 3, Ejercicio 1
 * Grupo 6 - Pancreas.
 * 14/3/2015
 * Integrantes: Rodrigo Suarez, Sebastian Caredio, Fernando Torterolo, Gianni Iaquinta, José Ignacio Chartier.
 * Descripcion: Implementar parser sencillo para Formato de archivos CSV
 * Definir expresiones regulares para: Cada campo en un registro.
 * Un registro completo linea
 */
public class ParserCSV {

    public static String[] parse(String csvLine) {


        final Pattern csvPattern = Pattern.compile("(?:(?<=\")([^\"]*)(?=\"))|(?<=,|^)([^,]*)(?=,|$)");
        ArrayList<String> allMatches = new ArrayList<String>();
        Matcher matcher = csvPattern.matcher(csvLine);
        String match;
        int size;
        allMatches.clear();

        while (matcher.find()) {
            match = matcher.group(1);
            if (match != null) {
                allMatches.add(match.replace("\"\"", "\"" ));
            } else {
                allMatches.add(matcher.group(2).replace("\"\"", "\"" ));
            }
        }

        size = allMatches.size();
        if (size > 0) {
            return allMatches.toArray(new String[size]);
        } else {
            return new String[0];
        }
    }
}
