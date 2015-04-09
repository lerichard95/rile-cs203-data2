/**
 * @author Richard Le
 */

import tester.*;

import java.util.Random;

/**
 * This is the main method that will invoke the tests.
 */
public class Data2 {
    public static Random rand = new Random();

    public static void main(String[] args) {
        //  Using the tester library
        FiniteBagExamples FiniteBagExamples = new FiniteBagExamples();
        Tester.run(FiniteBagExamples);

        System.out.println("data2 - Run configuration is correct! Ready to start!");
    }


}