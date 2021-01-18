package invoicegenerator;

import invoicegenerator.service.aguasdelacosta.AguasDeLaCostaService;
import invoicegenerator.service.compuseb.CompusebService;
import invoicegenerator.service.epm.EpmService;
import invoicegenerator.service.surtigas.SurtigasService;
import java.util.Scanner;

/**
 * Clase principal.
 */
public class InvoiceGenerator {

    /**
     *
     * Método principal del proyecto.
     *
     * @param args Arreglo de {@link String} que recibe los parametros para su ejecución.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido al centro de facturas electrónicas de tus servicios!");

        /** @param action Opción a elegir en el menú.*/
        int action;
        do {
            System.out.println("¿De cuál servicio deseas ver tu factura?");
            System.out.println("#1. Factura de energía (EMP - AFINIA)\n" +
                                "#2. Factura de gas (SURTIGAS)\n" +
                                "#3. Factura de agua (AGUAS DE LA COSTA)\n" +
                                "#4. Servicio de internet (COMPUSEB S.A.S)\n" +
                                "#5. Salir.\n");
            action = sc.nextInt();
            menuOption(action);
        } while (action != 5);
        sc.close();
    }

    /**
     * Muestra al usuario el menú de inicio, donde puede elegir qué funcion elegir
     * @param action Opción a elegir en el menú.
     * */
    public static void menuOption(int action) {
        Scanner sc = new Scanner(System.in);
        switch (action){
            case 1:
                System.out.println(new EpmService(1000, 200).printInvoice());
                break;
            case 2:
                System.out.println(new SurtigasService(1684, 8).printInvoice());
                break;
            case 3:
                System.out.println(new AguasDeLaCostaService(2643, 15).printInvoice());
                break;
            case 4:
                System.out.println(new CompusebService(84000).printInvoice());
                break;
            case 5:
                System.out.println("Gracias.\n¡Vuelve pronto!");
                System.exit(0);
        }
    }

}
