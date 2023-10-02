package br.com.mentorama.LojaOnline_OrderSalesOperation.entities.enums;

public enum PaymentMethod {

    AT_SIGHT(0),
    CREDITCARD_1x(1),
    CREDITCARD_2x(2),
    CREDITCARD_3x(3);

    public int paymentMethod;

    private PaymentMethod(int method) {
        this.paymentMethod = method;
    }
}
