public class Car {
    private String licensePlateNum;


//CONSTRUCTOR FOR CAR CLASS
    public Car(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;


    }
//METHOD TO GET THE LICENSE PLATE NUMBER OF THE CAR
    public String getLicensePlateNum() {
        return licensePlateNum;
    }
//METHOD TO CHANGE THE LICENSE PLATE NUMBER OF THE CAR
    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

}