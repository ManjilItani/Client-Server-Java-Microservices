package TicTactoe.TicTacToe.game.thecounter.service;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ABCService {

    public static Character[] getABC() {
        var data = IntStream.iterate(65, e -> e + 1).limit(26)
                        .mapToObj(e -> (char) e)
                .toArray(Character[]::new);


        return data;
    }
    public static int[] get123(int... limit) {

        int newLimit = 26;
        if (limit.length != 0)
            newLimit = limit[0];

        var num = IntStream.rangeClosed(0,newLimit)
                .toArray();


        return num;
    }

    public static void main(String[] args)
    {

        Arrays.stream(get123(45)).forEach(System.out::print);
    }
}
