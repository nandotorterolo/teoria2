package org.ucu.teoria2.actividad1;

/**
 * Actividad 1, Teorica de la Computación y sistemas formales.
 * Grupo 6 - Pancreas.
 * 9/3/2015
 * Integrantes: Rodrigo Suarez, Sebastian Caredio, Fernando Torterolo, Gianni Iaquinta, José Ignacio Chartier.
 * Descripcion: Dado una entrada de un numero en base 10, que puede contener signo, decimales y separador de miles,
 * espacios al antes y despues del signo y de la entrada, debe verificar una entrada valida o no.
 */

public class ParserNumeros {

  public static Boolean parsear(String entrada) {

    char car;
    char[] caracteres = entrada.toCharArray();
    int largo = entrada.length();
    int iterador = 0, sepMilesCout = 0, numCount = 0;

      boolean bSign = false, bNumber = false, bDot = false, bColon = false, bCantHaveDot = false,
            bFinished = false, bIsError = false, bDecimalPart = false, bContainsDot = false;

    while (!bIsError && iterador < largo) {

      car = caracteres[iterador];
      switch (car) {

        case ' ':
          if (bNumber) {
            bFinished = true;
          }
          break;

        case '+':
        case '-':

          if (!bFinished) {
            if (bSign || bNumber) {
              bIsError = true;
            } else {
              bSign = true;
            }
          } else {
            bIsError = true;
          }
          break;

        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
          bNumber = true;
          bDot = false;
          bColon = false;

          if (!bDecimalPart) {
            numCount++;
          }

          if (numCount == 4 && !bContainsDot) {
            bCantHaveDot = true;
          }

          if (!bFinished) {
            if (bContainsDot && !bDecimalPart)
              sepMilesCout--;
          } else {
            bIsError = true;
          }
          break;

        case '.':
          bContainsDot = true;

          if (bDot || bCantHaveDot || bDecimalPart) {
            bIsError = true;
          }

          if (!bFinished) {
            sepMilesCout = 3;
          } else {
            bIsError = true;
          }

          bDot = true;
          bColon = false;

          break;

        case ',':

          bColon = true;
          bDot = false;

          if (!bDecimalPart) {
            bDecimalPart = true;
          } else {
            bIsError = true;
          }

          if (sepMilesCout != 0) {
            bIsError = true;
          }
          break;

        default:
          bIsError = true;
      }

      if (iterador == largo - 1 && bNumber)
        bFinished = true;
      iterador++;
    }

    return bFinished && !bIsError && !bDot && !bColon && sepMilesCout == 0;
  }
}


