package TicTactoe.TicTacToe.game.loadxml.piechart;

import TicTactoe.TicTacToe.game.loadxml.Property;
import TicTactoe.TicTacToe.game.loadxml.SQLExecutable;
import TicTactoe.TicTacToe.game.loadxml.SQLUtility;

import java.util.ArrayList;
import java.util.List;

import static TicTactoe.TicTacToe.game.loadxml.DBConnection.getConnection;

public class GroupByStateDAO {

    public static List<GroupByState> findAll() {
        String SQL = """
                select state, count(state) as stateCount, sum(netIncome) as sumOfNetIncome
                from properties
                group by state
                """;
        SQLExecutable<GroupByState> exec = rs -> {
            var groupByState = new GroupByState(
                    rs.getString("state"), rs.getFloat("stateCount")
                    , rs.getFloat("sumOfNetIncome")

            );

            return groupByState;
        };

        List<GroupByState> list = SQLUtility.findAll(SQL, getConnection(), exec);

        return list;

    }
}
