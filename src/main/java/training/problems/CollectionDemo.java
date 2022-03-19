package training.problems;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class CollectionDemo {

   public static void main(String[] args) {
      JSONObject obj = new JSONObject();

      obj.put("name","foo");
      obj.put("num", new Integer(100));
      obj.put("balance", new Double(1000.21));
      obj.put("is_vip", new Boolean(true));

      System.out.print(obj);
      
      
   }
}