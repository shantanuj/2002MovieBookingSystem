package main;
import java.util.ArrayList;

public class TableBuilder {
    /**
     * The row class represents one row of data,
     * to keep thing simple than using a String[].
     */
    private static class Row {
        String[] data;
        Row(String[] v) { data = v; }
    }

    /**
     * Contains column header and max width information.
     */
    private static class Col {
        String name;
        int maxWidth;
    }

    Col[] cols;
    ArrayList<Row> rows;

    public TableBuilder(String... colNames) {
        cols = new Col[colNames.length];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new Col();
            cols[i].name = colNames[i];
            cols[i].maxWidth = colNames[i].length();
        }

        rows = new ArrayList<>();
    }

    /**
     * Adds a row of data to the TableBuilder.
     * @param values row data
     */
    public void addRow(String... values) {
        if(values.length != cols.length) {
            throw new IllegalArgumentException();
        }

        Row row = new Row(values);
        rows.add(row);
        for(int i = 0; i < values.length; i++) {
            if(values[i].length() > cols[i].maxWidth) {
                cols[i].maxWidth = values[i].length();
            }
        }
    }

    private void print(String v, int w) {
        System.out.print(" ");
        System.out.print(v);
        System.out.print(spaces(w - v.length()));
        System.out.print(" |");
    }

    /**
     * To print out the TableBuilder.
     */
    public void print() {

        System.out.print("|");
        for(Col col : cols) {
            print(col.name, col.maxWidth);
        }
        System.out.println("");
        int numDashes = cols.length*3 + 1;
        for(Col col : cols) numDashes += col.maxWidth;
        // TODO make columns have + instead of -
        System.out.println(dashes(numDashes));
        for(Row row : rows) {
            System.out.print("|");
            int i = 0;
            for(String v : row.data) {
                print(v,cols[i++].maxWidth);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Print a specific number of spaces for padding
     * @param i number of spaces
     * @return string for padding
     */
    private static String spaces(int i) {
        StringBuilder sb = new StringBuilder();
        while(i  --> 0) sb.append(" ");
        return sb.toString();
    }

    /**
     * Print a specific number of dashes
     * @param i number of dashes
     * @return print string
     */
    private static String dashes(int i) {
        StringBuilder sb = new StringBuilder();
        while(i  --> 0) sb.append("-");
        return sb.toString();
    }
}
