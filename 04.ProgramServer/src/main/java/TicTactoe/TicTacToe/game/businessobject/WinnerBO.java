package TicTactoe.TicTacToe.game.businessobject;

import TicTactoe.TicTacToe.game.model.WinnerStatus;
import ch.qos.logback.core.net.SyslogOutputStream;

public class WinnerBO {

    public WinnerStatus getWinner(String moves) {

        String[] move = moves.split("");


        WinnerStatus ws = new WinnerStatus();

        int[][] match = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};

        int length = match.length;

        for(int x = 0; x < length; x++)
        {
            if( (( move[match[x][0]].equals(move[match[x][1]]) ) && (move[match[x][0]].equals(move[match[x][2]]))) && (!move[match[x][0]].equals("N")))
            {
                int[] position = {match[x][0],match[x][1],match[x][2]};
                ws = new WinnerStatus(true,position,move[match[x][0]]);
                return ws;
            }
        }

        return ws;

    }

}
