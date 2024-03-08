package com.example.cellularautomata;

import java.util.Map;

public class Rule {
    private final Map<String, Character> ruleMap;

    public Rule(byte rule) {
        StringBuilder binaryRule = new StringBuilder(Integer.toBinaryString(rule));
        while (binaryRule.length() < 8) {
            binaryRule.insert(0, "0");
        }
        ruleMap = Map.of(
                "111", binaryRule.charAt(0),
                "110", binaryRule.charAt(1),
                "101", binaryRule.charAt(2),
                "100", binaryRule.charAt(3),
                "011", binaryRule.charAt(4),
                "010", binaryRule.charAt(5),
                "001", binaryRule.charAt(6),
                "000", binaryRule.charAt(7)
        );
    }

    public Cell getNextCell(Cell currentCell, Cell rightNeighbor, Cell leftNeighbor) {
        String rulePattern =  (leftNeighbor.isAlive() ? "1" : "0") +
                (currentCell.isAlive() ? "1" : "0") +
                (rightNeighbor.isAlive() ? "1" : "0");

        Character cellValue = ruleMap.get(rulePattern);

        return new Cell(cellValue == '1');
    }
}
