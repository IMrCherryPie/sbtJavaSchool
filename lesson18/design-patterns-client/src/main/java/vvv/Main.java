package vvv;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = null;
        try{
            Class clazz = Class.forName(VehicleFactory.class.getName());
            VehicleFactory vehicleFactory = (VehicleFactory) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
