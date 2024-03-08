package com.example.cellularautomata;

import java.util.HashMap;
import java.util.Map;

public class Rule {
    private final Map<String, Character> ruleMap;

    public Rule(byte rule) {
        StringBuilder binaryRule = new StringBuilder(Integer.toBinaryString(rule));
        while (binaryRule.length() < 8) {
            binaryRule.insert(0, "0");
        }
        ruleMap = new HashMap<>();
        ruleMap.put("111", binaryRule.charAt(0));
        ruleMap.put("110", binaryRule.charAt(1));
        ruleMap.put("101", binaryRule.charAt(2));
        ruleMap.put("100", binaryRule.charAt(3));
        ruleMap.put("011", binaryRule.charAt(4));
        ruleMap.put("010", binaryRule.charAt(5));
        ruleMap.put("001", binaryRule.charAt(6));
        ruleMap.put("000", binaryRule.charAt(7));
    }

    public Cell getNextCell(Cell currentCell, Cell rightNeighbor, Cell leftNeighbor) {
        String rulePattern =  (leftNeighbor.isAlive() ? "1" : "0") +
                (currentCell.isAlive() ? "1" : "0") +
                (rightNeighbor.isAlive() ? "1" : "0");
        System.out.println(rulePattern + " " + ruleMap.get(rulePattern));

        Character cellValue = ruleMap.get(rulePattern);


        return new Cell(cellValue == '1');
    }
}
