package TicTactoe.TicTacToe.game.property;

import TicTactoe.TicTacToe.game.loadxml.Property;
import TicTactoe.TicTacToe.game.loadxml.SelectProperties;
import TicTactoe.TicTacToe.game.thecounter.service.ABCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {


    @GetMapping("/")
    public List<Property> getList(){

        return PropertyDAO.findAll();
    }

}
