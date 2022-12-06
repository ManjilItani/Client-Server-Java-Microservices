package TicTactoe.TicTacToe.game.controller;

import TicTactoe.TicTacToe.game.businessobject.WinnerBO;
import TicTactoe.TicTacToe.game.model.WinnerStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping("/tictactoe")
    public WinnerStatus x(@RequestParam String moves){

        return new WinnerBO().getWinner(moves);
    }
    @GetMapping("/check")
    public void check(@RequestParam String moves)
    {
        String[] move = moves.split("");
        System.out.println("THe move is" + move[0]);
    }

}
