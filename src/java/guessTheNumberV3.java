import java.util.Scanner;

public class guessTheNumberV3 {

        protected static String name;
        protected static int num;
        protected static int randNum;

        //gets user's name
        public static void setName(String input)
        {
            name = input;
        }

        //returns user's name
        public static String getName()
        {
            return name;
        }

        //sets user's guess
        public static void setNum(int input)
        {
            num = input;

            //sets random number used by computer
            randNum = (int) ((Math.random() * (20 - 1)) + 1);
        }

        //gets user's guess
        public static int getNum()
        {
            return num;
        }

        //plays the game with user's info
        public static void playGame()
        {
            Scanner scan = new Scanner(System.in);
            String input = "";

            try {
                System.out.println("Greetings! Please enter your name: ");
                name = scan.nextLine();
                setName(name);
            }
            catch (Exception e)
            {
                System.out.println("Sorry, I had an issue getting your name. Good-bye.");
                System.exit(-1);
            }

            System.out.println("OK " + getName() + ", I am thinking of a number between 1 and 20. To win, you must guess my number within 6 tries\nGo ahead and take a guess what it is (invalid input does not count as guesses): ");
            input = scan.nextLine();
            try {
                num = Integer.parseInt(input);
                setNum(num);
            } catch (Exception e) {
                System.out.println("Oops, invalid input. Good-bye.");
                System.exit(-1);
            }

            boolean done = false;
            do {

                //tests for right answer, and gives output to user
                int guesses = 1;
                boolean exit = false;

                do {
                    if (getNum() == randNum) {
                        if (guesses == 1) {
                            System.out.println("Congratulations! You guessed my number in " + guesses + " turn!");
                            exit = true;
                        } else if (guesses > 1 && guesses < 7) {
                            System.out.println("Congratulations! You guessed my number in " + guesses + " turns!");
                            exit = true;
                        }
                    } else if (getNum() > randNum && getNum() > 0 && getNum() < 21) {
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

    public static void main(String[] args)
    {
        playGame();
    }
}
