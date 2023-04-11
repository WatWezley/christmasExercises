package xmasExercise;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class TableExercise {

    public static void main(String[] arg){
        Integer[][] marks = {
                { 70, 66, 76, 89, 67, 98 },
                { 67, 89, 64, 78, 59, 78 },
                { 68, 87, 71, 65, 87, 86 },
                { 80, 56, 89, 98, 59, 56 },
                { 75, 95, 90, 73, 57, 79 },
                { 69, 49, 56, 78, 76, 77 }
        };
        String [] students = { "", "S2", "", "S4", "", "S6"};
        for(Integer[] row : marks){
        System.out.println(Arrays.deepToString(row));}
        System.out.println(Arrays.toString(students));
        JTable table = new JTable(marks, students);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setFont(font);
        table.setRowHeight(30);
        table.setGridColor(blue);
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        frame.setBackground(green);
        table.getColumnModel().getColumn(3).setCellRenderer(

        //table.getColumn("").setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table,
                                                                   Object value,
                                                                   boolean isSelected,
                                                                   boolean hasFocus,
                                                                   int row,
                                                                   int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.yellow);
                        return this;
                    };
    });


        table.getColumnModel().getColumn(0).setCellRenderer(

                //table.getColumn("").setCellRenderer(
                new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table,
                                                                   Object value,
                                                                   boolean isSelected,
                                                                   boolean hasFocus,
                                                                   int row,
                                                                   int column) {
                        setText(value.toString());
                        setBackground(isSelected ? Color.blue : Color.yellow);
                        return this;
                    };
                });

    }
}


