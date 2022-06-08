import java.util.Scanner;

public class guessTheNumberV3 {

    public void main(String[] args) {

        //gets users name
        Scanner scan = new Scanner(System.in);
        String name = "";
        try {
            System.out.println("Greetings! Please enter your name: ");
            name = scan.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Sorry, I had an issue getting your name. Good-bye.");
            System.exit(-1);
        }

        //runs the program until the user signals to stop
        boolean done = false;
        do {

            //generates random number
            int randNum = (int) ((Math.random() * (20 - 1)) + 1);

            //asks and stores users initial number guess, and checks if it's a number
            System.out.println("OK " + name + ", I am thinking of a number between 1 and 20. To win, you must guess my number within 6 tries\nGo ahead and take a guess what it is (invalid input does not count as guesses): ");
            String input = scan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Oops, invalid input. Good-bye.");
                System.exit(-1);
            }

            //creates variables used for guess comparison, tests for right answer, and gives output to user
            int guesses = 1;
            boolean exit = false;

            do {
                if (num == randNum) {
                    if (guesses == 1) {
                        System.out.println("Congratulations! You guessed my number in " + guesses + " turn!");
                        exit = true;
                    } else if (guesses > 1 && guesses < 7) {
                        System.out.println("Congratulations! You guessed my number in " + guesses + " turns!");
                        exit = true;
                    }
                } else if (num > randNum && num > 0 && num < 21) {
                    guesses++;
                    System.out.println("Nope. Your guess was too high.");
                    if (guesses != 7)
                    {
                        System.out.println("Try again: ");
                        input = scan.nextLine();
                    }

                    try {
                        num = Integer.parseInt(input);
                    } catch (Exception e) {
                        System.out.println("Oops, invalid input. Good-bye.");
                        System.exit(-1);
                    }

                } else if (num < randNum && num > 0 && num < 21) {
                    guesses++;
                    System.out.println("Nope. Your guess was too low.");
                    if (guesses != 7)
                    {
                        System.out.println("Try again: ");
                        input = scan.nextLine();
                    }

                    try {
                        num = Integer.parseInt(input);
                    } catch (Exception e) {
                        System.out.println("Oops. Not a number. Good-bye.");
                        System.exit(-1);
                    }

                }
                else {
                    System.out.println("Oops. Your number was out of range. Try again: ");
                    input = scan.nextLine();

                    try {
                        num = Integer.parseInt(input);
                    } catch (Exception e) {
                        System.out.println("Oops, invalid input. Good-bye.");
                        System.exit(-1);
                    }
                } if (guesses == 7) {
                    System.out.println("\nSorry, you ran out of guesses. My number was " + randNum);
                    exit = true;
                }
            }
            while (!exit);

            //checks if user still wants to play
            try {
                System.out.println("Would you like to play the game again (y/n): ");
                String playAgain = scan.nextLine();
                switch (playAgain) {
                    case "y":
                        System.out.println("I'll reset the game then.\n");
                        break;
                    case "Y":
                        System.out.println("Alright, I'll reset the game.\n");
                        break;
                    case "n":
                        System.out.println("OK, good-bye for now.");
                        done = true;
                        break;
                    case "N":
                        System.out.println("Alright, good-bye for now.");
                        done = true;
                        break;
                    default:
                        System.out.println("Sorry, that's invalid input. Exiting by default . . .\n");
                        done = true;
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Sorry, something must have been wrong with your input. Good-bye.");
                System.exit(-1);
            }
        }
        while (!done);
    }
}
