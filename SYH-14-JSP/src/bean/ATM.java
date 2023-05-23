package bean;

import java.util.Objects;

public class ATM {
    private int atmId;
    private String atmCode;
    private String atmName;
    private String atmPwd;
    private double atmMoney;

    public ATM(int atmId, String atmCode, String atmName, String atmPwd, double atmMoney) {
        this.atmId = atmId;
        this.atmCode = atmCode;
        this.atmName = atmName;
        this.atmPwd = atmPwd;
        this.atmMoney = atmMoney;
    }

    public ATM() {
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getAtmCode() {
        return atmCode;
    }

    public void setAtmCode(String atmCode) {
        this.atmCode = atmCode;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public String getAtmPwd() {
        return atmPwd;
    }

    public void setAtmPwd(String atmPwd) {
        this.atmPwd = atmPwd;
    }

    public double getAtmMoney() {
        return atmMoney;
    }

    public void setAtmMoney(double atmMoney) {
        this.atmMoney = atmMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return atmId == atm.atmId &&
                Double.compare(atm.atmMoney, atmMoney) == 0 &&
                Objects.equals(atmCode, atm.atmCode) &&
                Objects.equals(atmName, atm.atmName) &&
                Objects.equals(atmPwd, atm.atmPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atmId, atmCode, atmName, atmPwd, atmMoney);
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atmId=" + atmId +
                ", atmCode='" + atmCode + '\'' +
                ", atmName='" + atmName + '\'' +
                ", atmPwd='" + atmPwd + '\'' +
                ", atmMoney=" + atmMoney +
                '}';
    }
}
