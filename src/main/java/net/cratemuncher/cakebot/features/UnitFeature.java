package net.cratemuncher.cakebot.features;

import net.cratemuncher.cakebot.CBFeature;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitFeature extends CBFeature {
    private Pattern conversionPattern = Pattern.compile("^.*?(?:(\\d+)(?:[ ]?)([A-Za-z'\"]+)\\s+(in|as|to)\\s+([A-Za-z'\"]+)).*?$");
    HashMap<String, HashMap<String, Double>> measurements;

    public UnitFeature() {
        measurements = new HashMap<String, HashMap<String, Double>>();
        InputStream is = ClassLoader.getSystemResourceAsStream("units.json");
        JSONArray jsonMeasurements = (JSONArray) JSONValue.parse(new InputStreamReader(is));

        for (Object measurementObj : jsonMeasurements) {
            if (measurementObj instanceof JSONObject) {
                HashMap<String, Double> units = new HashMap<String, Double>();

                JSONObject measurement = (JSONObject) measurementObj;

                for (Object unitObj : (JSONArray) measurement.get("units")) {
                    if (unitObj instanceof JSONObject) {
                        JSONObject unit = (JSONObject) unitObj;

                        for (Object nameObj : (JSONArray) unit.get("names")) { // One hell of a cast
                            units.put((String) nameObj, (Double) unit.get("value"));
                        }
                    }
                }

                measurements.put((String) measurement.get("measurement"), units);

            } // Else, someone messed with the file format
        }

        setDesc("Converts units into other units (only distances atm)");
    }

    @Override
    public void onGenericMessage(GenericMessageEvent evt) throws Exception {
        String msg = evt.getMessage();

        Matcher m = conversionPattern.matcher(msg);
        if (m.matches()) {
            try {
                double value = Double.parseDouble(m.group(1));
                String from = m.group(2);
                String to = m.group(3);

                for (HashMap<String, Double> measurement : measurements.values()) {
                    if (measurement.containsKey(from)) {
                        if (measurement.containsKey(to)) {
                            double fromVal = measurement.get(from);
                            double toVal = measurement.get(to);

                            double newVal = value;
                            newVal = newVal * fromVal;
                            newVal = newVal / toVal;

                            evt.respond(round(value, 5) + " " + from + " is " + round(newVal, 5) + " " + to);
                            return;
                        }
                    }
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private String round(double input, int places) {
        return new DecimalFormat("#0." + StringUtils.repeat("#", places)).format(input);
    }
}
