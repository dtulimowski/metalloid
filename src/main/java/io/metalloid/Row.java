package io.metalloid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Row implements Comparable<Row> {
    private String email;
    private String account;
    private float amount;

    @Override
    public int compareTo(Row row) {
        return 0;
    }
}
