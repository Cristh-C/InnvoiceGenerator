/**
 *
 */
package invoicegenerator.service;

/**
 * Interfaz que modela el comportamiento de un servicio.
 */
public interface Service {

    /**
     * Método que calcula el valor del consumo total respecto a las unidades de medida.
     *
     * @return Valor total del consumo.
     */
    double calculateConsumptionValue();

    /**
     * Imprime la factura de pago.
     *
     * @return Una Cadena de String con el formato de la factura de pago.
     */
    String printInvoice();

    /**
     * Genera la referencia de pago de la factura a pagar.
     *
     * @return La referencia de pago de la factura a pagar.
     */
    String generatePaymentRefence();

    /**
     * Método que genera la fecha maxima de pago.
     * @return La fecha maxima de pago.
     */
    String generateDayMaxPayment();
}
