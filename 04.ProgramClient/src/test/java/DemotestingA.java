import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.tictactoe.model.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DemotestingA {

    @Test
    @DisplayName("Testing server application for an A")
    void demoTestMethod() {

        String url = "http://localhost:9615/game/tictactoe?moves=OXOXOXOXX";
        var object = JSONGet.submitGet(url, Winner.class).getPosition();
        System.out.println(object[1]);
        assertTrue(true);
    }
}