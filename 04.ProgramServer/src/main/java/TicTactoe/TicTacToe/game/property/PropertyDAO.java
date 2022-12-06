package TicTactoe.TicTacToe.game.property;

import TicTactoe.TicTacToe.game.loadxml.Property;
import TicTactoe.TicTacToe.game.loadxml.SQLExecutable;
import TicTactoe.TicTacToe.game.loadxml.SQLUtility;

import java.util.List;

import static TicTactoe.TicTacToe.game.loadxml.DBConnection.getConnection;

public class PropertyDAO {
    final static String sql = "select * from Properties";
    public static List<Property> findAll() {

        SQLExecutable<Property> exec = rs -> {
            var property = new Property(
                    rs.getString("id"), rs.getFloat("cost")
                    , rs.getFloat("downpayment"), rs.getString("state")
                    , rs.getFloat("percentage"), rs.getFloat("netIncome")
            );

            return property;
        };

        List<Property> list = SQLUtility.findAll(sql, getConnection(), exec);
        return list;
    }

}
