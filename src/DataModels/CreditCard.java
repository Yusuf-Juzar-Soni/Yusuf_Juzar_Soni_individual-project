package DataModels;

public class CreditCard {
    private String creditCardNo;
    public CreditCard(String creditCardNo){
        this.creditCardNo=creditCardNo;

    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNo='" + creditCardNo + '\'' +
                '}';
    }
}
