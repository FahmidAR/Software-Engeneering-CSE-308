public class microcontrolerFactory {
    public microprocessor getMicrocontroler(String name)
    {
        if(name.equalsIgnoreCase("arduinoMega"))
        {
            return new arduinoMega();
        }
        else if(name.equalsIgnoreCase("ATMega32"))
        {
            return new ATMega32();
        }
        else if(name.equalsIgnoreCase("raspberryPi"))
        {
            return new raspberryPi();
        }
        return null;
    }
}
