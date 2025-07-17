package oops.inheritence;

import java.util.ArrayList;

class Vehicle{
    private String vehicleId;
    private String brand;
    private int hourlyRate;
    private boolean isAvailable;
    public Vehicle(String vehicleId,String brand,int hourlyRate,boolean isAvailable){
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.hourlyRate=hourlyRate;
        this.isAvailable=isAvailable;
    }
    public String getVehicleId(){return vehicleId;}
    public String getBrand(){return brand;}
    public int getHourlyRate(){return hourlyRate;}
    public boolean getIsAvailable(){return isAvailable;}
    public void setAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }
    public double caluclateRent(int hours){
        return this.hourlyRate*hours ;
    }
    public String getType(){
        return "default";
    }
}

class Car2 extends Vehicle{
    private int seatingCapacity;
    public Car2(String vehicleId,String brand,int hourlyRate,boolean isAvailable,int seatingCapacity){
        super(vehicleId,brand,hourlyRate,isAvailable);
        this.seatingCapacity=seatingCapacity;
    }
    public int getSeatingCapacity(){
        return seatingCapacity;
    }
    public double caluclateRent(int hours){
        return super.getHourlyRate()*hours;
    }
    public String getType(){
        return "car";
    }
}
class Bike extends Vehicle{
    private boolean helmetIncluded;
   public Bike(String vehicleId,String brand,int hourlyRate,boolean isAvailable,boolean helmetIncluded){
       super(vehicleId,brand,hourlyRate,isAvailable);
       this.helmetIncluded=helmetIncluded;
   }
   public boolean getHelmetIncluded(){
       return helmetIncluded;
   }
    public double caluclateRent(int hours){
       return (super.getHourlyRate()*hours);
    }
    public String getType(){
        return "bike";
    }
}
class Truck extends Vehicle{
    private int truckCapacity;
    public Truck(String vehicleId,String brand,int hourlyRate,boolean isAvailable,int truckCapacity){
        super(vehicleId,brand,hourlyRate,isAvailable);
        this.truckCapacity=truckCapacity;
    }
    public int getTruckCapacity(){
        return truckCapacity;
    }
    public double caluclateRent(int hours){
        return super.getHourlyRate()*hours+100;
    }
    public String getType(){
        return "truck";
    }
}
class VehicleManager{
    ArrayList<Vehicle> vehicles=new ArrayList<>();
    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }
    public void availableVehicles(){
        for(Vehicle v:vehicles){
            if(v.getIsAvailable()){
                System.out.println("id: "+v.getVehicleId());
                System.out.println("brand: "+v.getBrand());
                System.out.println("rate: "+v.getHourlyRate()+"per hour");
            }
        }
    }
    public void rentVehicleById(String id,int hours){
        boolean found=false;
        for(Vehicle v:vehicles){
            if(v.getVehicleId().equalsIgnoreCase(id)&&v.getIsAvailable()){
               double rent=v.caluclateRent(hours);
               v.setAvailable(false);
                System.out.println("\n vehicle type: "+v.getType()+"\n brand: "+v.getBrand()+"\n rented for"
                +hours+"hours"+"\ntotal price: "+rent);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("vehicle not found");
        }
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
       VehicleManager v=new VehicleManager();
       v.addVehicle(new Car2("123","honda",1000,true,4));
       v.addVehicle(new Bike("124","hero",200,true,true));
       v.addVehicle(new Truck("125","tata",10000,true,100000));
       v.availableVehicles();
       v.rentVehicleById("124",3);

    }
}
