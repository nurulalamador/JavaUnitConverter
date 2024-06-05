public class ConvertFunction {
    public double ConvertDistance(Double inputValue, Object inputUnit, Object outputUnit) {
        Double baseValue = 0.0;
        Double convetedValue = 0.0;

        if(inputUnit == "Kilometer") {
            baseValue = inputValue*1000;
        }
        else if(inputUnit == "Centimeter") {
            baseValue = inputValue/100;
        }
        else if(inputUnit == "Mile") {
            baseValue = inputValue*1609.344;
        }
        else if(inputUnit == "Inch") {
            baseValue = inputValue/39.37;
        }
        else if(inputUnit == "Yard") {
            baseValue = inputValue/1.094;
        }
        else if(inputUnit == "Foot") {
            baseValue = inputValue/3.281;
        }
        else {
            baseValue = inputValue;
        }


        if(outputUnit == "Kilometer") {
            convetedValue = baseValue/1000;
        }
        else if(outputUnit == "Centimeter") {
            convetedValue = baseValue*100;
        }
        else if(outputUnit == "Mile") {
            convetedValue = baseValue/1609.344;
        }
        else if(outputUnit == "Inch") {
            convetedValue = baseValue*39.37;
        }
        else if(outputUnit == "Yard") {
            convetedValue = baseValue*1.094;
        }
        else if(outputUnit == "Foot") {
            convetedValue = baseValue*3.281;
        }
        else if(outputUnit == "Meter"){
            convetedValue = baseValue;
        }
        
        return convetedValue;
    }


    public double ConvertTemperature(Double inputValue, Object inputUnit, Object outputUnit) {
        Double baseValue = 0.0;
        Double convetedValue = 0.0;

        if(inputUnit == "Fahrenheit") {
            baseValue = (inputValue-32.0)*(5.0/9.0);
        }
        else if(inputUnit == "Kelvin") {
            baseValue = inputValue-273.15;
        }
        else {
            baseValue = inputValue;
        }


        if(outputUnit == "Fahrenheit") {
            System.out.println(baseValue);
            convetedValue = (baseValue*(9.0/5.0))+32.0;
            System.out.println(convetedValue);
        }
        else if(outputUnit == "Kelvin") {
            convetedValue = baseValue+273.15;
        }
        else {
            convetedValue = baseValue;
        }

        return convetedValue;
    }


    public double ConvertTime(Double inputValue, Object inputUnit, Object outputUnit) {
        Double baseValue = 0.0;
        Double convetedValue = 0.0;

        if(inputUnit == "Nanosecond") {
            baseValue = inputValue/1000000000;
        }
        else if(inputUnit == "Microsecond") {
            baseValue = inputValue/1000000;
        }
        else if(inputUnit == "Millisecond") {
            baseValue = inputValue/1000;
        }
        else if(inputUnit == "Minute") {
            baseValue = inputValue*60;
        }
        else if(inputUnit == "Hour") {
            baseValue = inputValue*3600;
        }
        else if(inputUnit == "Day") {
            baseValue = inputValue*86400;
        }
        else if(inputUnit == "Week") {
            baseValue = inputValue*604800;
        }
        else if(inputUnit == "Month") {
            baseValue = inputValue*2630000;
        }
        else if(inputUnit == "Year") {
            baseValue = inputValue*31536000;
        }
        else {
            baseValue = inputValue;
        }


        if(outputUnit == "Nanosecond") {
            convetedValue = baseValue*1000000000;
        }
        else if(outputUnit == "Microsecond") {
            convetedValue = baseValue*1000000;
        }
        else if(outputUnit == "Millisecond") {
            convetedValue = baseValue*1000;
        }
        else if(outputUnit == "Minute") {
            convetedValue = baseValue/60;
        }
        else if(outputUnit == "Hour") {
            convetedValue = baseValue/3600;
        }
        else if(outputUnit == "Day") {
            convetedValue = baseValue/86400;
        }
        else if(outputUnit == "Week") {
            convetedValue = baseValue/604800;
        }
        else if(outputUnit == "Month") {
            convetedValue = baseValue/2630000;
        }
        else if(outputUnit == "Year") {
            convetedValue = baseValue/31536000;
        }
        else {
            convetedValue = baseValue;
        }

        return convetedValue;
    }

    public double Convert(Object type, Double inputValue, Object inputUnit, Object outputUnit) {
        if(type == "Distance") {
            return ConvertDistance(inputValue,inputUnit,outputUnit);
        }
        else if(type == "Temperature") {
            return ConvertTemperature(inputValue,inputUnit,outputUnit);
        }
        else if(type == "Time") {
            return ConvertTime(inputValue,inputUnit,outputUnit);
        }
        else {
            return 0.0;
        }
    }
}
