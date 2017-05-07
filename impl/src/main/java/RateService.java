import com.google.inject.matcher.Matcher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Created by alex on 5/7/2017.
 */
public class RateService implements IRateService {
    Map<String, Rate> rates = Collections.EMPTY_MAP;


    public void loadData(){
        String filePath = "resources/data.json";
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray lang= (JSONArray) jsonObject.get("rates");

            Iterator i = lang.iterator();
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                String ccy = innerObj.get("currency").toString();
                Double rate = Double.parseDouble(innerObj.get("rate").toString());
                Double multiplier = Double.parseDouble(innerObj.get("multiplier").toString());

                Rate r=new Rate(ccy,rate, Optional.of(multiplier));
                rates.put(ccy, r);
            }


        }catch (FileNotFoundException e){
            System.out.print("File not found");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double getRateForCcy(String ccy) {
        loadData();
        Rate r= rates.get(ccy);
        return r.getRate() * r.getMultiplier();
    }
}

