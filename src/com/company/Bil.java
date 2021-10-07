package com.company;

public class Bil {

    String type;
    String model;
    int stelnr;
    int numDoors;
    double softwareVersion;
    double gpsx;
    double gpsy;
    int speed;

    private Motor engine = new Motor();

    public Bil (){
        type = "Tesla";
        model = "Model x";
        stelnr = 29309230;
        numDoors = 5;
        softwareVersion = 1.01;
        gpsx = 55.22458;
        gpsy = 11.757075;
        speed = 0;
    }

    public String toString() {
        return  "\nCar type: " + type +
                "\nModel: " + model +
                "\nStelnumber: " + stelnr +
                "\nNumber of doors: " + numDoors +
                "\nSoftwareVersion: " + softwareVersion +
                "\nGps coordinates: " + gpsx + ", " + gpsy +
                "\nSpeed = " + speed + " km/h";
    }

    public void powerButton () {
        engine.setEngineStatus(!engine.isEngineStatus());
        if(engine.isEngineStatus()) {
            System.out.println("The car has turned on!");
        } else {
            System.out.println("The car has turned off!");
        }
    }

    public void accPos () {
        if (engine.getrPM() < 100) {
            engine.setrPM(engine.getrPM() + 1 );
            updateSpeed();
            System.out.println("The new RPM is now at " + engine.getrPM() + "%");
            System.out.println("your ned speed is " + speed + " km/h");
        } else {
            System.out.println("RPM is already at 100%");
        }
    }

    public void accNeg () {
        if (engine.getrPM() > 0) {
            engine.setrPM(engine.getrPM() - 1 );
            updateSpeed();
            System.out.println("The new RPM is now at " + engine.getrPM() + "%");
            System.out.println("your ned speed is " + speed + " km/h");
        } else {
            System.out.println("RPM is already at 0%");
        }
    }

    public void accSet (int i) {
        if (i <= 100 && i >= 0) {
            engine.setrPM(i);
            updateSpeed();
            System.out.println("the new RPM is now at " + engine.getrPM() + "%");
            System.out.println("your ned speed is " + speed + " km/h");
        }
    }

    private void updateSpeed() {
       this.speed = engine.getrPM() * 2;
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public int getStelnr() {return stelnr;}
    public void setStelnr(int stelnr) {this.stelnr = stelnr;}

    public int getNumDoors() {return numDoors;}
    public void setNumDoors(int numDoors) {this.numDoors = numDoors;}

    public double getSoftwareVersion() {return softwareVersion;}
    public void setSoftwareVersion(float softwareVersion) {this.softwareVersion = softwareVersion;}

    public double getGpsx() {return gpsx;}
    public void setGpsx(float gpsx) {this.gpsx = gpsx;}

    public double getGpsy() {return gpsy;}
    public void setGpsy(float gpsy) {this.gpsy = gpsy;}

    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public boolean getEngineStatus() {return this.engine.isEngineStatus();}

}
