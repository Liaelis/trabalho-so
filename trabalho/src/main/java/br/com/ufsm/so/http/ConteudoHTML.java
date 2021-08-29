package br.com.ufsm.so.http;

public class ConteudoHTML {

    public String getInicioHtml(){
        return ""
                +"<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
                "    <title>Trabalho SO</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <header>\n" +
                "        <navclass=\"nav justify-content-center navbar-dark\">\n" +
                "    \n" +
                "                  <h3>RESERVA DE PASSAGEM</h3>\n" +
                "        \n" +
                "        </nav>\n" +
                "       \n" +
                "    </header>\n" +
                "</br>"+
                "</br>"+
                "    <div class=\"container\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"row\">\n"
                ;
    }
    public String getLugarDisponivel(int i, String nome, String dataHora){
        return ""
                + "                         <div class=\"align-self-center text-center col-2\">\n"
                + "                             <div class=\"card bg-success\">\n"
                + "                                 <div class=\"card-block py-1 px-1\">\n"
                + "                                     <h2  class=\"mb-1\">" + (i + 1) + "</h2>\n"
                + "                                     <hr class=\"my-1\">\n"
                + "                                     <p class=\"mb-0\"> <b>" + nome + "</b> </p>\n"
                + "                                     <p class=\"mb-1\">" + dataHora + "</p>\n"
                + "                                     <button type=\"button\" data-id=\"" + (i + 1) + "\" class=\"btn btn-primary lugarNumber\" data-toggle=\"modal\" data-target=\"#modalReservar\">Reservar</button>\n"
                + "                                 </div>\n"
                + "                             </div>\n"
                + "                         </div>\n";
    }
    public String getQuebraLinha() {
        return ""
                + "                     </div>\n"
                + "                     <div class=\"row mt-4 d-flex justify-content-end\">\n";
    }
    public String getLugardReservado(int i, String nome, String dataHora) {
        return ""
                + "                        <div class=\"align-self-center text-center col-2\">\n"
                + "                            <div class=\"card bg-danger\">\n"
                + "                                <div class=\"card-block py-1 px-1\">\n"
                + "                                    <h2  class=\"mb-1\">" + (i + 1) + "</h2>\n"
                + "                                    <hr class=\"my-1\">\n"
                + "                                    <p class=\"mb-0\"> " + nome + " </p>\n"
                + "                                    <p class=\"mb-1\">" + dataHora + "</p>\n"
                + "                                    <button type=\"button\" class=\"btn btn-primary disabled\">Reservar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </div>\n";
    }
    public String getFinalCards() {
        return ""
                + "                         </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n";
    }
    public String getLugarJaReservado(int lugar) {
        return ""
                + "HTTP/1.1 200 OK\n" + "Content-Type: text/html; charset=UTF-8\n\n"
                + "<!DOCTYPE HTML>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>SO A</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <body>\n"
                + "</html>\n"
                + "<script>\n"
                + "    alert(\"O lugar " + lugar + " não pode ser reservado! Motivo: Já reservado.\");\n"
                + "    window.location = \"/\";\n"
                + "</script>\n";
    }
    public String getPaginaLugarReservadoComSucesso(int lugar, String nome) {
        return ""
                + "HTTP/1.1 200 OK\n" + "Content-Type: text/html; charset=UTF-8\n\n"
                + "<!DOCTYPE HTML>\n"
                + "<html>\n"
                + "    <head>\n"
                + "    <title>Sucesso</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <body>\n"
                + "</html>\n"
                + "<script>\n"
                + "    alert(\"✔ Lugar " + lugar + " reservado para " + nome + " com sucesso" + "\");\n"
                + "    window.location = \"/\";\n"
                + "</script>\n";
    }
    public String getFinalHtml(){
        return ""
                + "</div>\n" +
                "  </div>\n" +
                " </div>\n"
                + "        <div class=\"modal fade\" id=\"modalReservar\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                + "            <div class=\"modal-dialog\" role=\"document\">\n"
                + "                <div class=\"modal-content\">\n"
                + "                    <div class=\"modal-header\">\n"
                + "                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Reservar lugar</h5>\n"
                + "                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Fechar\">\n"
                + "                            <span aria-hidden=\"true\">&times;</span>\n"
                + "                        </button>\n"
                + "                    </div>\n"
                + "                    <div class=\"modal-body\">\n"
                + "                        <form method=\"GET\" action=\"reservar\">\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label class=\"col-form-label\">Nome:</label>\n"
                + "                                <input required name='nome' type=\"text\" class=\"form-control\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label for=\"recipient-name\" class=\"col-form-label\">Lugar:</label>\n"
                + "                                <input type=\"text\" class=\"form-control\" name='lugar' id=\"lugarId\" readonly>\n"
                + "                            </div>\n"
                + "                            <div class=\"dropdown-divider pb-4\"></div>\n"
                + "                            <div class=\"form-row\">\n"
                + "                               <div class=\"col-md-6\">\n"
                + "                                   <button class=\"btn btn-secondary btn-block\" data-dismiss=\"modal\">Cancelar</button>\n"
                + "                               </div>\n"
                + "                                <div class=\"col-md-6\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-primary btn-block\">Reservar</button>\n"
                + "                               </div>\n"
                + "                            </div>\n"
                + "                        </form>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n"
                + "        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n"
                + "        <script>\n"
                + "            $(document).on(\"click\", \".lugarNumber\", function () {\n"
                + "                var myBookId = $(this).data('id');\n"
                + "                $(\".modal-body #lugarId\").val( myBookId );\n"
                + "            });\n"
                + "        </script>\n"
                + "</body>\n"
                +"<style type=\"text/css\">"
                +".justify-content-center {\n" +
                "    -ms-flex-pack: center !important;\n" +
                "    justify-content: center !important;\n" +
                "}\n" +
                ".nav {\n" +
                "    display: -ms-flexbox;\n" +
                "    display: flex;\n" +
                "    background-color: aquamarine;\n" +
                "    -ms-flex-wrap: wrap;\n" +
                "    flex-wrap: wrap;\n" +
                "    padding-left: 10px;\n" +
                "    margin-bottom: 8px;\n" +
                "    list-style: none;\n" +
                "}"
                +"</style>"
                +  "</html>\n";

    }
}
