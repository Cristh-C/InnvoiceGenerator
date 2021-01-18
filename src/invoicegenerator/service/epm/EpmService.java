/**
 *
 */
package invoicegenerator.service.epm;

import invoicegenerator.service.Service;
import java.util.Calendar;

/**
 * Clase que modela el comportamiento del servicio de Epm.
 */
public class EpmService implements Service {

    /** Referencia de pago. */
    private String paymentReference;
    /** Unidades consumidas. */
    private int units;
    /** Valor de Unidad. */
    private double unitValue;

    /**
     * Constructor de la clase.
     */
    public EpmService() {
        super();
    }

    /**
     * Constructor de la clase.
     *
     * @param unitValue El valor de la unidad.
     */
    public EpmService(double unitValue) {
        this.unitValue = unitValue;
    }

    /**
     * Constructor de la clase.
     *
     * @param unitValue el valor de la unidad.
     * @param units Las unidades consumidas.
     */
    public EpmService(double unitValue, int units) {
        this.unitValue = unitValue;
        this.units = units;
    }

    /**
     * Constructor de la clase.
     *
     * @param units Las unidades consumidas..
     */
    public EpmService(int units) {
        this.units = units;
    }

    @Override
    public double calculateConsumptionValue() {
        return (this.units * this.unitValue);
    }

    @Override
    public String generatePaymentRefence() {
        return (String.valueOf((int) (Math.random() * 100000000)));
        //return (UUID.randomUUID().toString());
    }

    /**
     * Obtiene la refencia de pago.
     *
     * @return El paymentInvoice.
     */
    public String getPaymentInvoice() {
        return (this.paymentReference);
    }

    /**
     * Obtiene las unidades consumidas.
     *
     * @return Las unidades consumidas.
     */
    public int getUnits() {
        return (this.units);
    }

    /**
     * Obtiene el valor de la unidad.
     *
     * @return El valor de la unidad.
     */
    public double getUnitValue() {
        return (this.unitValue);
    }

    @Override
    public String printInvoice() {
        this.paymentReference = this.generatePaymentRefence();
        StringBuilder invoice = new StringBuilder();
        invoice.append("***************************************\n");
        invoice.append("*                EPM                  *\n");
        invoice.append("*          Factura de Pago            *\n");
        invoice.append("*     " + Calendar.getInstance().getTime().toString() + "    *\n");
        invoice.append("*                                     *\n");
        invoice.append("* Referencia de pago: " + this.paymentReference + "        *\n");
        invoice.append("* Cantidad de unidades consumidas:" + this.units + " *\n");
        invoice.append("* Valor de la unidad: $" + this.unitValue + "         *\n");
        invoice.append("* Valor a pagar: $" + this.calculateConsumptionValue() + "            *\n");
        invoice.append("* Fecha límite: " + this.generateDayMaxPayment() + "            *\n");
        invoice.append("*                                     *\n");
        invoice.append("*                                     *\n");
        invoice.append("***************************************\n");
        return (invoice.toString());
    }

    /**
     * Establece las unidades consumidas.
     *
     * @param units Las unidades consumidas a establecer
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * Establece el valor de la unidad
     *
     * @param unitValue El valor de la unidad a establecer.
     */
    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public String generateDayMaxPayment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 4);
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

}
