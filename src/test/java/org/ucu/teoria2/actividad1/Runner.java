package org.ucu.teoria2.actividad1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 *
 * Test runner is used for executing the test cases. Here is an example which assumes TestJunit test class already exists.
 */
public class Runner {

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(TestInvalidos.class, TestValidos.class);
    for (Failure failure : result.getFailures()) {
      System.out.println("Failure:" + failure.toString());
    }
    System.out.println("Result wasSuccessful ? : " + result.wasSuccessful());
  }
}
