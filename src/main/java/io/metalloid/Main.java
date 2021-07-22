package io.metalloid;



import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        MultiValuedMap<String, Row> rows = new ArrayListValuedHashMap<>();
        Row row1 = new Row("first@kanga.exchange", " PL 1010101010101010101010", 100);
        rows.put(row1.getEmail(), row1);
        Row row2 = new Row("first@kanga.exchange", "PL 1112121212121212121212",150);
        rows.put(row2.getEmail(), row2);
        Row row3 = new Row("second@kanga.exchange","PL 1220202020202020202020",50);
        rows.put(row3.getEmail(), row3);
        Row row4 = new Row("second@kanga.exchange", "PL 1010101010101010101010",200);
        rows.put(row4.getEmail(), row4);
        Row row5 = new Row("third@kanga.exchange", "PL 1220202020202020202020",50);
        rows.put(row5.getEmail(), row5);
        Row row6 = new Row("third@kanga.exchange", "PL 4014141010404010104444",50);
        rows.put(row6.getEmail(), row6);

       // TreeMap<String, Row> sorted = new TreeMap<>();
        //sorted.putAll(rows.asMap());
   // rows.asMap().
        //sorted.forEach( (s, row) -> System.out.println("%s " + s));

    }
}
