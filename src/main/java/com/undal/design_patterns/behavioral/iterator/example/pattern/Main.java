package com.undal.design_patterns.behavioral.iterator.example.pattern;

public class Main {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator it= nameRepository.getIterator(); it.hasNext();
             ) {
            String name = (String) it.next();
            System.out.println("name: " + name);
        }
    }
}
