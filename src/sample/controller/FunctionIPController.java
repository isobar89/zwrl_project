package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FunctionIPController implements Initializable {

    @FXML
    private ListView <String> listView;
    @FXML
    private Button checkButton;
    @FXML
    private TextArea listInfo;
    private ObservableList <String> obList1;
    private String zmienieTo;

    public String getTabIP() {
        return tabIP.toString();
    }

    public void setTabIP(String[] tabIP) {
        this.tabIP = tabIP;
    }

    private String tabIP[] = new String[12];
    ArrayList <String> tab3 = new ArrayList <>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        obList1 = FXCollections.observableArrayList();


        ArrayList <String> lista = new ArrayList <>();
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

        for (int a = 0; a < i; a++) {
            obList1.add(lista.get(a));
            listView.setItems(obList1);
        }
           obList1.add("80.192.167.88"); //Testowy IP
        listView.setItems(obList1);// To tez Do usuniecia
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();

        String testowyIP = "1.1.1.0";


    }
//-------------------------


    public void setZmienieTo(String zmienieTo) {
        this.zmienieTo = zmienieTo;
    }

    //----------------
    @FXML

    void  checkIP(MouseEvent event){
        listInfo.clear();
        displaySelected();
        Check(zmienieTo);
        for (int a = 0;a <tab3.size() ; a++) {
            listInfo.appendText(String.valueOf(tab3.get(a)) + "\n");
        }

        listInfo.setWrapText(true);
        remove();
    }


    private void displaySelected() {
    }

    @FXML
    void displaySelected(MouseEvent event) {




                String selected = listView.getSelectionModel().getSelectedItem();
                setZmienieTo(selected);

                ;
            }









    public String getZmienieTo() {
        return zmienieTo;
    }

    public void Check(String testowo) {
        ArrayList <String> tab1 = new ArrayList <>();
        ArrayList <String> tab2 = new ArrayList <>();

        String ipTest = getZmienieTo();
        final String url = "https://check-host.net/ip-info?host=" + testowo;
        try {
            Document document = Jsoup.connect(url).get();

            for (Element row : document.select("table.hostinfo.result tr")) {

                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    tab1.add(row.select("td:nth-of-type(1)").text());
                    tab2.add(row.select("td:nth-of-type(2)").text());


                }

            }

            for (int a = 0; a < 12; a++) {
               tab3.add(tab1.get(a) + " " + tab2.get(a));


                a++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }




        }


        public void remove(){

    tab3.clear();
        }
}


