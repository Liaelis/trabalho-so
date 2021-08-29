package br.com.ufsm.so.http;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Controller implements Runnable{
    public static Lugar[] lugares = new Lugar[12];
    private static Socket s;
    public  ConteudoHTML conteudoHTML = new ConteudoHTML();

    public Controller(Socket s, Lugar[] lugares){
        this.lugares =lugares;
        this.s=s;
    }
    public static void startTratamento(Socket s, Lugar[] lugares){
        new Thread(new Controller(s,lugares)).start();
    }


    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int tam = s.getInputStream().read(buffer);
            String requisicao = new String(buffer, 0, tam);
            //System.out.println("[REQ] recebida " +requisicao);
            String[] lines = requisicao.split("\n");
            String[] linha0 = lines[0].split(" ");
            String[] lines2 = requisicao.split("\\?");
            String[] linha1 = lines2[0].split(" ");
            if (linha0[1].equals("/")) {

                StringBuilder resposta = new StringBuilder();
                resposta.append(conteudoHTML.getInicioHtml());
                carregaCards(resposta);
                resposta.append(conteudoHTML.getFinalCards());
                resposta.append(conteudoHTML.getFinalHtml());

                OutputStream out = s.getOutputStream();
                out.write(("HTTP/1.1 200 OK  \n" + "Content-Type: text/html; charset=UTF-8\n\n").getBytes());
                out.write(resposta.toString().getBytes("UTF-8"));


            } else {
                //tratamento request com parametro aqui
                if (linha1[1].equals("/reservar")) {

                    reservarLugar(s, lines2[1]);
                }

            }
        }catch (IOException e) {
            e.printStackTrace();

        }

    }
    private void carregaCards (StringBuilder resposta){
        String card;
        for (int i = 0; i < 12; i++) {
            if (i == 4 || i == 8) {
                resposta.append(conteudoHTML.getQuebraLinha());
            }
            if (lugares[i].getReservado()) {
                card = conteudoHTML.getLugardReservado(i, lugares[i].getNomeResponsavel(), lugares[i].getData());
            } else {
                card = conteudoHTML.getLugarDisponivel(i, lugares[i].getNomeResponsavel(), lugares[i].getData());
            }
            resposta.append(card);
        }
        // return  resposta;
    }
    private void reservarLugar(Socket socket, String parametroUrl1) throws IOException {
        OutputStream out = socket.getOutputStream();
        String parametroUrl = parametroUrl1;
        String[] dadosUrl = parametroUrl.split("&");
        String primeiroArg[]= dadosUrl[0].split("=");
        String segundoArg[] = dadosUrl[1].split("=");
        String segundoArg2[]= segundoArg[1].split(" ");
        String nomePessoa = primeiroArg[1];
        int numeroLugar = Integer.parseInt(segundoArg2[0]);
        synchronized (s) {
            if (lugares[numeroLugar - 1].getReservado()) {
                String resposta = conteudoHTML.getLugarJaReservado(numeroLugar);
                out.write(resposta.getBytes("UTF-8"));
            } else {
                lugares[numeroLugar - 1] = new Lugar(nomePessoa, true);
                FileWriter fileWriter = new FileWriter("src\\main\\java\\br\\com\\ufsm\\so\\http\\log.txt", true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.printf(InetAddress.getLocalHost().getHostAddress() + "%n");
                fileWriter.close();
                String resposta = conteudoHTML.getPaginaLugarReservadoComSucesso(numeroLugar, nomePessoa);
                out.write(resposta.getBytes("UTF-8"));
            }
        }
    }
}

