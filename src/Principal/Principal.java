package Principal;




import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {


        //API
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/eb60a299dd050017ce8e39de/latest/USD"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");


        //OBTENIENDO TASAS DE CONVERSION BASE USD
        double usd = conversionRates.get("USD").getAsDouble();
        double ars = conversionRates.get("ARS").getAsDouble();
        double brl = conversionRates.get("BRL").getAsDouble();
        double cop = conversionRates.get("COP").getAsDouble();
        double pen  = conversionRates.get("PEN").getAsDouble();

        //MENU
        String menu = """
                      1. Dolar => Peso argentino
                      2. Peso bargentino => Dolar\s
                      3. Dolar => Real brasileño
                      4. Real brasileño => Dolar\s
                      5. Dolar => Peso colombiano
                      6. Peso colombiano => Dolar
                      7. Salir
                      
        **********************************************************************
                      """;

        //FUNCIONAMIENTO

        System.out.println(ars);
        System.out.println(usd);
        System.out.println("************************************************");
        System.out.println("Bienvenido/a al conversor de monedas\n");
        Scanner inputUsuario = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Escoge una opción");
            System.out.println(menu);


            opcion = 0;
            opcion = inputUsuario.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto = inputUsuario.nextDouble();
                    double dolarPesArgenrino = monto*ars;

                    System.out.println("************************************************\n");
                    System.out.println("El valor de " + monto + " [USD] "+
                            "equivalen a : " + dolarPesArgenrino+
                            " [ARS]\n") ;
                    System.out.println("************************************************\n");

                    break;
                case 2:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto2 = inputUsuario.nextDouble();
                    double pesArgenrinoDolar = monto2/ars;
                    System.out.println("************************************************\n");
                    System.out.println("El valor de " + monto2 + " [ARS], " + "equivalen " +
                            "a : " +  BigDecimal.valueOf(pesArgenrinoDolar) +
                            " [USD] ") ;
                    System.out.println("************************************************\n");
                    break;

                case 3:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto3 = inputUsuario.nextDouble();
                    double dolarRealBrasil = monto3*brl;
                    System.out.println("************************************************\n");
                    System.out.println("El valor de  " + monto3 + " [USD] " + " equivalen a" +
                            ": " + dolarRealBrasil  +
                            " [BRL]") ;
                    System.out.println("************************************************\n");
                    break;

                case 4:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto4 = inputUsuario.nextDouble();
                    double realBrasilDolar = monto4/brl;
                    System.out.println("************************************************\n");
                    System.out.println("El valor de  " + monto4 + " [BRL] equivalen a " +
                            ": " +   BigDecimal.valueOf(realBrasilDolar) +
                            " [USD] ") ;
                    System.out.println("************************************************\n");
                    break;

                case 5:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto5 = inputUsuario.nextDouble();
                    double dolarPesoColombiano = monto5*cop;
                    System.out.println("************************************************\n");
                    System.out.println("El valor de  " + monto5 + " [USD] " + "equivalen a" +
                            ": " + dolarPesoColombiano +
                            "  [COP]") ;
                    System.out.println("************************************************\n");
                    break;

                case 6:
                    System.out.println("Ingresa el monto a convertir: ");
                    double monto6 = inputUsuario.nextDouble();
                    double pesoColombianoDolar = monto6/cop;
                    System.out.println("************************************************\n");
                    System.out.println("El valor de " + monto6 + " [COP] equivalen a " +
                            ": " + BigDecimal.valueOf(pesoColombianoDolar) +
                            " [USD] ") ;
                    System.out.println("************************************************\n");
                    break;
                case 7:
                    System.out.println("Hasta la próxima");



                default:
                    System.out.println("*******************************");
//                    System.out.println("Realiza una nueva conversión");
//                    System.out.println(menu);
            }

        }
        while (opcion != 7);





        }

















            }



