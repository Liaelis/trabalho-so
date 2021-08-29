package br.com.ufsm.so.http;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lugar {
    private String nomeResponsavel;
    private Boolean reservado;
    private String data;

    public Lugar(String nomeResponsavel, Boolean reservado) {
        this.nomeResponsavel = nomeResponsavel;
        this.reservado = reservado;
        LocalDateTime dataTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/uuuu");
        this.data = formatter.format(dataTime);
    }
    public Lugar(){

    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

