package TicTactoe.TicTacToe.game.thecounter.controller;

import TicTactoe.TicTacToe.game.thecounter.service.ABCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class Controller123 {


    @GetMapping("/123")
    public int[] count123(@RequestParam (defaultValue = "100") int limit){

        return ABCService.get123(limit);
    }

}
