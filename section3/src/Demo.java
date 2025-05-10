public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    /**
     * This method performs addition of two numbers
     * @param a first number
     * @param b second number
     * @return result of addition
     */
    public static int add(int a, int b) {
        System.out.println("sum " + (a + b));
        return a + b;
    }

    /**
     * This method performs subtraction of two numbers
     * @param a first number
     * @param b second number
     * @return result of subtraction
     */
    public static int subtract(int a, int b) {
        System.out.println("difference " + (a - b));
        return a - b;
    }

    /**
     * This method performs multiplication of two numbers
     * @param a first number
     * @param b second number
     * @return result of multiplication
     */
    public static int multiply(int a, int b) {
        System.out.println("product " + (a * b));
        return a * b;
    }

    /**
     * This method performs division of two numbers
     * @param a first number
     * @param b second number
     * @return result of division
     */
    public static int divide(int a, int b) {
        System.out.println("quotient " + (a / b));
        return a / b;
    }
}


