package invoicegenerator.service.surtigas;

import invoicegenerator.service.Service;
import java.util.Calendar;

/**
 * Clase que modela el comportamiento del servicio de Surtigas.
 */
public class SurtigasService implements Service {

    /** Referencia de pago*/
    private String paymentReference;
    /** Metros cúbicos de gas consumidos*/
    private int cubicMetersConsumed;
    /** Valor por metro cúbico de gas*/
    private double cubicMeterValue;


    /**Constructor de la clase*/
    public SurtigasService() {
        super();
    }

    /**
     * Constructor de la clase.
     * @param cubicMeterValue El valor de los métros cúbicos de gas consumidos.
     **/
    public SurtigasService(double cubicMeterValue) {
        this.cubicMeterValue = cubicMeterValue;
    }

    /**
     * Constructor de la clase.
     * @param cubicMeterValue  El valor por metro cúbico de gas.
     * @param cubicMetersConsumed La cantidad de metros cúbicos de gas consumidos.
     **/
    public SurtigasService(double cubicMeterValue, int cubicMetersConsumed){
        this.cubicMeterValue = cubicMeterValue;
        this.cubicMetersConsumed = cubicMetersConsumed;
    }

    /**
     * Constructor de la clase.
     * @param cubicMetersConsumed La cantidad de metros cúbicos de gas consumidos.
     **/
    public SurtigasService(int cubicMetersConsumed){
        this.cubicMetersConsumed = cubicMetersConsumed;
    }

    /**
     * Calcula el valor de consumo del usuario.
     * */
    @Override
    public double calculateConsumptionValue() {
        return (this.cubicMetersConsumed * this.cubicMeterValue);
    }


    @Override
    public String printInvoice() {
        this.paymentReference = this.generatePaymentRefence();
        StringBuilder invoice = new StringBuilder();
        invoice.append("***************************************\n");
        invoice.append("*             Surtigas                *\n");
        invoice.append("*          Factura de Pago            *\n");
        invoice.append("*     " + Calendar.getInstance().getTime().toString() + "    *\n");
        invoice.append("*                                     *\n");
        invoice.append("* Referencia de pago: " + this.paymentReference + "        *\n");
        invoice.append("* Consumo (m3): " + this.cubicMetersConsumed + " m3 (metros cúbicos)" + " *\n");
        invoice.append("* Valor por m3: $" + this.cubicMeterValue + "               *\n");
        invoice.append("* Valor a pagar: $" + this.calculateConsumptionValue() + "             *\n");
        invoice.append("* Fecha límite: " + this.generateDayMaxPayment() + "            *\n");
        invoice.append("*                                     *\n");
        invoice.append("*                                     *\n");
        invoice.append("***************************************\n");
        return (invoice.toString());
    }

    @Override
    public String generatePaymentRefence() {
        return (String.valueOf((int) (Math.random() * 100000000)));
    }

    @Override
    public String generateDayMaxPayment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 5);
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



    /**Obtiene la referencia de pago.
     * @return paymentReference Referencia de pago.
     * */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * Obtiene los metros cúbicos consumidos de gas.
     * @return cubicMetersConsumed La cantidad de metros cúbicos de gas consumidos.
     * */
    public int getCubicMetersConsumed() {
        return cubicMetersConsumed;
    }

    /**
     * Establece los metros cúbicos consumidos de gas.
     * @param cubicMetersConsumed La cantidad de metros cúbicos de gas consumidos.
     * */
    public void setCubicMetersConsumed(int cubicMetersConsumed) {
        this.cubicMetersConsumed = cubicMetersConsumed;
    }

    /**
     * Obtiene el valor por metro cúbico de gas.
     * @return cubicMetersValue El valor por metro cúbico de gas.
     **/
    public double getCubicMeterValue() {
        return cubicMeterValue;
    }

    /**
     * Establece el valor por metro cúbico de gas.
     * @param cubicMeterValue El valor por metro cúbico de gas.
     * */
    public void setCubicMeterValue(double cubicMeterValue) {
        this.cubicMeterValue = cubicMeterValue;
    }

}
