
package MAIN;    import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DRIVER {
     
  


public class ParkingLot {
    private int capacity;
    private List<Boolean> slots;
    private Map<String, Integer> bookings;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new ArrayList<Boolean>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.slots.add(false);
        }
        this.bookings = new HashMap<String, Integer>();
    }

    public int findEmptySlot() {
        for (int i = 0; i < capacity; i++) {
            if (!slots.get(i)) {
                return i;
            }
        }
        return -1; // no empty slot found
    }

    public boolean bookSlot(String driverName, int hours) {
        int emptySlot = findEmptySlot();
        if (emptySlot == -1) {
            return false; // parking lot is full
        } else {
            slots.set(emptySlot, true);
            bookings.put(driverName, emptySlot);
            double fee = hours * 200.0;
            System.out.printf("Parking fee is $%.2f\n", fee);
            return true;
        }
    }

    public boolean moveCar(String driverName, int slot) {
        if (slot < 0 || slot >= capacity) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        if (slots.get(slot)) {
            return false; // slot is occupied
        } else {
            int oldSlot = bookings.get(driverName);
            slots.set(oldSlot, false);
            slots.set(slot, true);
            bookings.put(driverName, slot);
            return true;
        }
    }

    public void leaveSlot(String driverName) {
        int slot = bookings.get(driverName);
        slots.set(slot, false);
        bookings.remove(driverName);
    }

    public void renewBooking(String driverName) {
        int slot = bookings.get(driverName);
        slots.set(slot, false);
        bookSlot(driverName, 1);
    }

    public boolean addSlot() {
        return false;
    }

    public void addOperator(String operatorName) {
    }

    public void updateOperator(String operatorName) {
    }
    
} 

  
}
