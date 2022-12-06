package TicTactoe.TicTacToe.game.loadxml;

import java.util.List;

import static TicTactoe.TicTacToe.game.loadxml.DBConnection.*;
public class SelectProperties {
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
