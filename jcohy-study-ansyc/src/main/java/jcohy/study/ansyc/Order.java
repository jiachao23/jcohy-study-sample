package jcohy.study.ansyc;

/**
 * Created by jiac on 2019/3/27.
 * ClassName  : jcohy.study.ansyc
 * Description  :
 */
public class Order {
    private Integer orderId;
    private String name;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order(Integer orderId, String name) {
        this.orderId = orderId;
        this.name = name;
    }
}
