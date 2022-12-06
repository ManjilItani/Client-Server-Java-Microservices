package TicTactoe.TicTacToe.game;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TestPredicates {

    public static int[] numbers = IntStream.rangeClosed(1,50).toArray();
    static Predicate<Integer> isEven = e -> e % 2 == 0;
    static Predicate<Integer> fIsMultipleOf11 = e -> e % 11 == 0;
    static Predicate<Integer> fIsMultipleOf5 = e -> e % 5 == 0;

    public static void main(String[] args) {

        e3(2,11,5);

        }

        public static void e2(){

        Predicate<Integer> pTotal = e -> false;

        pTotal = isEven.or(fIsMultipleOf5).or(fIsMultipleOf11);

            for (int i:numbers) {
                boolean isEligible = pTotal.test(i);
                System.out.printf("number: %s is eligible: %s \n", i, isEligible);

            }
        }

        public static void e3(int... num){

        Predicate<Integer> pTotal = e -> false;

            for (int i : num) {
                pTotal = pTotal.or(e -> e % i == 0);

            }
            for (int i: numbers) {

                boolean isEligible = pTotal.test(i);
                System.out.printf("number : %s is eligible: %s \n", i, isEligible);

            }


        }

    }

