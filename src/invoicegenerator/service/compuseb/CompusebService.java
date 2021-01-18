package invoicegenerator.service.compuseb;

import invoicegenerator.service.Service;
import java.util.Calendar;

/**
 * Clase que modela el comportamiento del servicio Compuseb SAS.
 * */
public class CompusebService implements Service {

    /** Referencia de pago*/
    private String paymentReference;
    /** Valor unitario por servicio*/
    private double unitValuePerService;

    /**Constructor de la clase*/
    public CompusebService() {
        super();
    }

    /**
     * Constructor de la clase
     * @param unitValuePerService Valor unitario por servicio.
     * */
    public CompusebService(double unitValuePerService) {
        this.unitValuePerService = unitValuePerService;
    }



    /**
     * Calcula el valor unitario del servicio.
     * */
    @Override
    public double calculateConsumptionValue() {
        return (this.unitValuePerService);
    }

    /**
     * Imprime la factura
     * */
    @Override
    public String printInvoice() {
        this.paymentReference = this.generatePaymentRefence();
        StringBuilder invoice = new StringBuilder();
        invoice.append("***************************************\n");
        invoice.append("*            Compuseb S.A.S           *\n");
        invoice.append("*            Factura de Pago          *\n");
        invoice.append("*     " + Calendar.getInstance().getTime().toString() + "    *\n");
        invoice.append("*                                     *\n");
        invoice.append("* Referencia de pago: " + this.paymentReference + "        *\n");
        invoice.append("* Cargo fijo 20Mb/s: " + this.unitValuePerService + "          *\n");
        invoice.append("* Valor a pagar: $" + this.calculateConsumptionValue() + "             *\n");
        invoice.append("* Fecha límite: " + this.generateDayMaxPayment() + "            *\n");
        invoice.append("*                                     *\n");
        invoice.append("*                                     *\n");
        invoice.append("*                                     *\n");
        invoice.append("***************************************\n");
        return (invoice.toString());

    }

    /**
     * Genera el código de referencia de la factura
     * */
    @Override
    public String generatePaymentRefence() {
        return (String.valueOf((int) (Math.random() * 100000000)));
    }

    /**
     * Genera la fecha límite máxima de pago.
     * */
    @Override
    public String generateDayMaxPayment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 11);
        calendar.add(Calendar.MONTH, 1);
        StringBuilder date = new StringBuilder();
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        date.append(((day.length() == 1) ? "0" + day : day));
        date.append("-");
        String month = String.valueOf(calendar.get(Calendar.MONTH));
        date.append(((month.length() == 1) ? "0" + month : month));
        date.append("-");
        date.append(calendar.get(Calendar.YEAR));
        return (date.toString());
    }



    /**
     * Obtiene la referencia de pago.
     * @return paymentReference
     * */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * Establece la referencia de pago.
     * @param paymentReference Referencia de pago.
     * */
    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    /**
     * Obtiene el valor unitario por servicio.
     * @return unitValuePerService Valor unitario por servicio.
     * */
    public double getUnitValuePerService() {
        return unitValuePerService;
    }

    /**
     * Establece el valor unitario por servicio.
     * @param unitValuePerService Valor unitario por servicio.
     * */
    public void setUnitValuePerService(double unitValuePerService) {
        this.unitValuePerService = unitValuePerService;
    }
}
