import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    private static final double BASE_SHIPPING_COST = 4.00;
    private static final double WEIGHT_RATE = 0.5;


    public void processShipping(List<Iship> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Shipping items cannot be null or empty");
        }
        System.out.println("** Shipment Notice **");
        
        double totalWeight = 0.0;
        Map<String, Integer> itemCounts = new HashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();
        for (Iship item : items) {
            String itemName = item.getName();
            double itemWeight = item.getWeight()/ 1000.0 ;
            
            totalWeight += item.getWeight();
            itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
            itemWeights.put(itemName, itemWeight);
            
        }
        for(String itemName:itemCounts.keySet()){
            int count = itemCounts.get(itemName);
            double weight = itemWeights.get(itemName);
            System.out.println(count+"x" +" " + itemName + "       " + weight + " g");
        }
      
        System.out.println("Total Package Weight " + totalWeight + " kg");
        System.out.println("                                         ");


        
       
    }

    public double calculateShippingCost(List<Iship> items) {
        if (items == null || items.isEmpty()) {
            return 0.0; 
        }
        double totalWeight = 0.0;
        for (Iship item : items) {
            totalWeight += item.getWeight();
        }
        return BASE_SHIPPING_COST + (totalWeight * WEIGHT_RATE);
    }

}
