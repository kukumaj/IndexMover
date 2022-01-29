import java.util.Scanner;

public class IndexMover {
    public static void main(String[] args) {
        int startIndex =0;
        String ch = " ";
        String someNumbers = "123456789";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type 'end' to exit\n");

        System.out.println(someNumbers);
        System.out.println("^");

        do {

            String input = scanner.nextLine();

            if (input.equals("end")) {
                System.exit(0);
            }
            char operation = input.charAt(0);
            int number;
            try {
                number = Integer.parseInt(input.substring(1));
            } catch (NumberFormatException ignore) {
                continue;
            }

            if (number < 0) {
                continue;
            } // --2

            switch (operation) {
                case '+' -> {
                    startIndex = (startIndex + number)%someNumbers.length();

                    System.out.println(someNumbers);
                    System.out.println(ch.repeat(startIndex)+"^");


                }
                case '-' -> {
                    int newPosition = startIndex-number;
                    if (newPosition < 0) {
                        newPosition = -newPosition;
                        int moduloshift = newPosition%someNumbers.length();
                        moduloshift = moduloshift == 0?someNumbers.length():moduloshift;
                        startIndex = someNumbers.length() - moduloshift;

                    }
                    else{
                        startIndex = newPosition;
                    }

//numbers.lengt -(number-number%numberlenght-1)
                    System.out.println(someNumbers);
                    System.out.println(ch.repeat(startIndex)+"^");

                }

            }
        } while (true);
    }
}