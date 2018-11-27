package sample.controller;

import java.io.IOException;
import java.util.Scanner;

public class FunctionIPController {
    class function

    {
        String[] cmdarray = {"netstat", "-n"};
        Process process = Runtime.getRuntime().exec(cmdarray);
        Scanner sc = new Scanner(process.getInputStream());

        function() throws IOException {
        }
    }
    public FunctionIPController() throws IOException {
        function fun = new function();
        System.out.println(fun);
    }
}
