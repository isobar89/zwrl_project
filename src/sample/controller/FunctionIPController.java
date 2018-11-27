package sample.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FunctionIPController implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private TextArea ipInfoList;
    private ObservableList<String> obList1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        obList1 = FXCollections.observableArrayList();






        ArrayList<String> lista = new ArrayList<>();
        String fileName = "test2.txt";
        File file = new File(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scan.hasNextLine()) {
            lista.add(scan.nextLine());
            i++;
        }

        for (int a = 0; a < i ; a++){
            obList1.add(lista.get(a));
            listView.setItems(obList1);
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }
}