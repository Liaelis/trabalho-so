package br.com.ufsm.so.http;

import java.io.*;
import java.net.ServerSocket;



public class HttpService {


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(80);
        Lugar[] lugares = new Lugar[12];
        for (int i = 0; i < 12; i++) {
            lugares[i] = new Lugar("vazio", false);
        }

        while (true) {
            Controller.startTratamento(serverSocket.accept(),lugares);
        }
    }
}
