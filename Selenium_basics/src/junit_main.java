public class junit_main {

    private String liquidType;
    private double percentFull;

    junit_main(String liquidType,double percentFull){
        this.liquidType=liquidType;
        this.percentFull=percentFull;
    }

    public String getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public double getPercentFull() {
        return percentFull;
    }

    public void setPercentFull(double percentFull) {
        this.percentFull = percentFull;
    }
}
