package TicTactoe.TicTacToe.game.loadxml.piechart.controller;

import TicTactoe.TicTacToe.game.loadxml.piechart.GroupByState;
import TicTactoe.TicTacToe.game.loadxml.piechart.GroupByStateDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@RestController
public class TriStateController {

    @GetMapping("triState")
    public static List<GroupByState> triState() {

        Predicate<GroupByState> predicate = e -> e.getState().equals("NY")
                ||e.getState().equals("CT")
                ||e.getState().equals("NJ");
        var list = GroupByStateDAO.findAll()
                .stream().filter(predicate).toList();

        return list;


    }

    @RequestMapping(value = "/allStates")
    public static List<GroupByState> getAll(@RequestParam(value = "states", defaultValue  = "all") String[] states) {

        Predicate<GroupByState> predicateFilter = e -> false;

        if (states.length == 1 && states[0].equals("all"))
        {
            predicateFilter = e -> true;
        }
        else {
            Predicate<GroupByState> predicate = e -> false;

            predicateFilter = Arrays.stream(states)
                    .map(m -> predicate.or(e -> e.getState().equals(m)))
                    .reduce((a, b) -> a.or(b)).get();

        }

        var list = GroupByStateDAO.findAll()
                .stream().filter(predicateFilter).toList();

        return list;


    }

}
