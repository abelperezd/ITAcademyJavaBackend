package n3;

import java.util.LinkedList;
import java.util.List;

public class Parking {
    LinkedList<IVehicleCommand> arrencar = new LinkedList<>();
    LinkedList<IVehicleCommand> accelerar = new LinkedList<>();
    LinkedList<IVehicleCommand> frenar = new LinkedList<>();

    public void addArrencar(IVehicleCommand vehicle){
        arrencar.add(vehicle);
    }
    public void addAccelerar(IVehicleCommand vehicle){
        accelerar.add(vehicle);
    }
    public void addAFrenar(IVehicleCommand vehicle){
        frenar.add(vehicle);
    }

    public void executeArrencar(){
        System.out.println("Arrencant vehicles: ");
        arrencar.forEach(IVehicleCommand::arrencar);
        System.out.println("");
    }

    public void executeAccelerar(){
        System.out.println("Accelerant vehicles: ");
        accelerar.forEach(IVehicleCommand::accelerar);
        System.out.println("");
    }
    public void executeFrenar(){
        System.out.println("Frenant vehicles: ");
        frenar.forEach(IVehicleCommand::frenar);
        System.out.println("");
    }

}
