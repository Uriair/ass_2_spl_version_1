package main.java.bgu.spl.mics.application.passiveObjects;

import java.util.ArrayList;

import main.java.bgu.spl.mics.Future;

/**
 * Passive object representing the resource manager.
 * You must not alter any of the given public methods of this class.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private methods and fields to this class.
 */
public class ResourcesHolder {
	
    // ---------------------- fields ----------------------
    private DeliveryVehicle[] VehicleCollection;
    private static ResourcesHolder instance = null;
	/**
     * Retrieves the single instance of this class.
     */
	public static ResourcesHolder getInstance() {
       if(instance == null) {
          instance = new ResourcesHolder();
       }
       return instance;
    }

	/**
     * Tries to acquire a vehicle and gives a future object which will
     * resolve to a vehicle.
     * <p>
     * @return 	{@link Future<DeliveryVehicle>} object which will resolve to a 
     * 			{@link DeliveryVehicle} when completed.   
     */
	public Future<DeliveryVehicle> acquireVehicle() {
		Future<DeliveryVehicle> futureVehicle=new Future<DeliveryVehicle>();
		for(DeliveryVehicle element:VehicleCollection )
		{
			if(element.isAvailable())
			{
				futureVehicle.resolve(element);
				element.lock();
			}
		}
		return null;
	}
	
	/**
     * Releases a specified vehicle, opening it again for the possibility of
     * acquisition.
     * <p>
     * @param vehicle	{@link DeliveryVehicle} to be released.
     */
	public void releaseVehicle(DeliveryVehicle vehicle) {
		for(DeliveryVehicle element:VehicleCollection )
			if(element==vehicle)
			{
				vehicle.release();
				return;
				
			}
	}
	
	/**
     * Receives a collection of vehicles and stores them.
     * <p>
     * @param vehicles	Array of {@link DeliveryVehicle} instances to store.
     */
	public void load(DeliveryVehicle[] vehicles) {
		VehicleCollection=vehicles;
	}

}
