package Reviewing;

import java.io.IOException;
import java.util.*;

public class reviewer {

    public static void main(String [] args) {
             List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

            for (int i : list) {
                Thread th = new Thread() {
                    @Override
                    public void run() {
                        System.out.println(i);
                    }
                };
                th.start();
            }
        }
    }




