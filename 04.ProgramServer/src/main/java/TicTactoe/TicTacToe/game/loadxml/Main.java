package TicTactoe.TicTacToe.game.loadxml;


import TicTactoe.TicTacToe.game.loadxml.piechart.GroupByStateDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       GroupByStateDAO.findAll().forEach(System.out::println);
       SelectProperties.findAll().forEach(System.out::println);
    }

    public static void loadDataFromXML(String[] args) {
        List<Property> propertyList = new ArrayList<>();
        XMLUtility.process("C:Users/manji/data/properties.xml", "property", element -> {
            var property = new Property(element);

            propertyList.add(property);

        });

        PropertyInsert.process(propertyList);

    }

    public static void getXml(String[] args) {
        XMLUtility.process("C:Users/manji/data/properties.xml", "property", element -> {
            var properties = new Property(element);
            System.out.println(properties);
        });
    }
}
