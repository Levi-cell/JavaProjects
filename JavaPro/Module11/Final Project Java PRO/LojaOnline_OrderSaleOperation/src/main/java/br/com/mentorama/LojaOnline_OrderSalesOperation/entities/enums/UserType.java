package br.com.mentorama.LojaOnline_OrderSalesOperation.entities.enums;

public enum UserType {

    NOT_DEFINED (0),
    SHOP_ATTENDANT (1),
    SHOP_COORDINATOR(2),
    SALES_MANAGER(3);

    public int userType;

    UserType(int level) {
        this.userType = level;
    }
}
