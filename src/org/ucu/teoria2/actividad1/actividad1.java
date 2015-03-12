<<<<<<< HEAD
package org.ucu.teoria2.actividad1;

/**
 * Actividad 1, Teorica de la Computación y sistemas formales.
 * Grupo 6 - Pancreas.
 * 9/3/2015
 * Integrantes: Rodrigo Suarez, Sebastian Caredio, Fernando Torterolo, Gianni Iaquinta, José Ignacio Chartier.
 * Descripcion: Dado una entrada de un numero en base 10, que puede contener signo, decimales y separador de miles,
 * espacios al antes y despues del signo y de la entrada, debe verificar una entrada valida o no.
 *
 */

public class actividad1 {


  public static void main(String args[]) {
	  int prueba ;
    String [] validos = new String [] { "123.456","1", "3,14", "1.000", "-5", " - 4,6 ", " 5.000,8", " 500 ", "+2 "} ;

    String [] invalidos = new String [] {"abcdef","  123abc", "123abc", "<>9io", "+", "1125,54.125", "125..300",
            "+-10", "10.", "67 89", "", "123.13,05", "eˆ2", " 3, ", "252,12,12", "123.13,05.36", "125,5.2",
            "164.445.843.7899", "22222.222"};

    Boolean res;
    System.out.println("\nValidos: =>" +  validos.length);

    for (String str : validos)
    {
      res = Parser.parsear(str);
      System.out.println( "El resultado de parsear la entrada valida: '" + str + "' es => " + res);
      if (!res) throw new AssertionError("Error al parsear: " + str);
    }

    System.out.println("\n\nInvalidos=>" +  invalidos.length);

    for (String str : invalidos)
    {
      res = Parser.parsear(str);
      System.out.println("El resultado de parsear la entrada invalida: '" + str + "' es => " + res);
      if (res) throw new AssertionError("Error al parsear: " + str);
    }

  }

  public static class Parser {
    public static Boolean parsear(String entrada) {

      char car;
      char[] caracteres = entrada.toCharArray();
      int largo = entrada.length();
        int iterador = 0, sepMilesCout = 0, numCount = 0;

        Boolean bSign = false, bNumber = false, bDot = false, bColon = false, bCantHaveDot = false,
                bFinished = false, bIsError = false, bDecimalPart = false, bContainsDot = false;

        while (!bIsError && iterador < largo) {

            car = caracteres[iterador];
        switch (car) {

          case ' ':
              if (bNumber) {
                  bFinished = true;
            }
            break;

          case '+' : case '-':

                if (!bFinished) {
                    if (bSign || bNumber) {
                        bIsError = true;
              }
              else {
                        bSign = true;
              }
            } else {
                    bIsError = true;
            }
            break;

          case '0' : case '1': case '2': case '3' : case '4' : case '5' : case '6' : case '7': case '8': case '9':
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

}
=======
package org.ucu.teoria2.actividad1;

/**
 * Actividad 1, Teorica de la Computación y sistemas formales.
 * Grupo 6 - Pancreas.
 * 9/3/2015
 * Integrantes: Rodrigo Suarez, Sebastian Caredio, Fernando Torterolo, Gianni Iaquinta, José Ignacio Chartier.
 * Descripcion: Dado una entrada de un numero en base 10, que puede contener signo, decimales y separador de miles,
 * espacios al antes y despues del signo y de la entrada, debe verificar una entrada valida o no.
 *
 */

public class actividad1 {


  public static void main(String args[]) {
	  int prueba ;
    String [] validos = new String [] { "123.456","1", "3,14", "1.000", "-5", " - 4,6 ", " 5.000,8", " 500 ", "+2 "} ;

    String [] invalidos = new String [] {"abcdef","  123abc", "123abc", "<>9io", "+", "1125,54.125", "125..300",
            "+-10", "10.", "67 89", "", "123.13,05", "eˆ2", " 3, ", "252,12,12", "123.13,05.36", "125,5.2",
            "164.445.843.7899", "22222.222"};

    Boolean res;
    System.out.println("\nValidos: =>" +  validos.length);

    for (String str : validos)
    {
      res = Parser.parsear(str);
      System.out.println( "El resultado de parsear la entrada valida: '" + str + "' es => " + res);
      if (!res) throw new AssertionError("Error al parsear: " + str);
    }

    System.out.println("\n\nInvalidos=>" +  invalidos.length);

    for (String str : invalidos)
    {
      res = Parser.parsear(str);
      System.out.println("El resultado de parsear la entrada invalida: '" + str + "' es => " + res);
      if (res) throw new AssertionError("Error al parsear: " + str);
    }

  }

  public static class Parser {
    public static Boolean parsear(String entrada) {

      char car;
      char[] caracteres = entrada.toCharArray();
      int largo = entrada.length();
        int iterador = 0, sepMilesCout = 0, numCount = 0;

        Boolean bSign = false, bNumber = false, bDot = false, bColon = false, bCantHaveDot = false,
                bFinished = false, bIsError = false, bDecimalPart = false, bContainsDot = false;

        while (!bIsError && iterador < largo) {

            car = caracteres[iterador];
        switch (car) {

          case ' ':
              if (bNumber) {
                  bFinished = true;
            }
            break;

          case '+' : case '-':

                if (!bFinished) {
                    if (bSign || bNumber) {
                        bIsError = true;
              }
              else {
                        bSign = true;
              }
            } else {
                    bIsError = true;
            }
            break;

          case '0' : case '1': case '2': case '3' : case '4' : case '5' : case '6' : case '7': case '8': case '9':
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

}
>>>>>>> 905831aa7a7ca02ad80fad2dd424bd339f32566c
