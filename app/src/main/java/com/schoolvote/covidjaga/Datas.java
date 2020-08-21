package com.schoolvote.covidjaga;

import java.io.IOException;

public class Datas {

    String dataXML = null;

    public Datas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    dataXML = new ReadCOVIDData().getData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }

    public boolean isNumeric(String s) {
        return s.matches("^[0-9]+$");
    }
}
