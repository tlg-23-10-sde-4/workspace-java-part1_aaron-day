package com.entertainment;

import java.util.Arrays;

/*
 * sets class to model workings of a tv, no main method here
 *
 */
public class Television {
    //sets attributes of tv, known as fields
    private String brand;
    private int volume;
    private DisplayType display = DisplayType.LED; //default is always null for enums unless otherwise specified

    //for muting
    private boolean isMuted; //provide getter only
    private int oldVolume;  //no getter/setter

    //statics
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;
    public static final String[] VALID_BRANDS = { "Samsung", "Sony", "LG", "Toshiba"};

    private static int instanceCount = 0;

    //ctor
    public Television(){
        instanceCount++;
    }

    public Television(String brand)
            throws InvalidBrandException {
        this();
        this.brand = brand;
    }

    public Television(String brand, int volume)
            throws IllegalArgumentException, InvalidBrandException {
        this(brand);
        setVolume(volume);
    }

    public Television(String brand, int volume, DisplayType display)
            throws IllegalArgumentException, InvalidBrandException {
        this(brand, volume);
        setDisplay(display);
    }

    //functions/operations aka business methods what do tv's do?
    public boolean isMuted(){
        return false;
    }

    public void mute(){
        if(!isMuted()){ //not currently muted
            oldVolume = getVolume();
            setVolume(0);
            isMuted = true;
        }
        else{   //currently muted, restore oldVolume
            setVolume(oldVolume);
            isMuted = false;
        }
    }

   public void turnOn() {
       boolean isConnected = verifyInternetConnection();

       System.out.println("Turning on your " + getBrand() + " TV to volume " + getVolume() + ".");
   }

   public void turnOff() {
       System.out.println("Shutting down...goodbye");
   }
   private boolean verifyInternetConnection(){
        return true; //fake implementation
   }

    //accessor methods
    public static int getInstanceCount() {
        return instanceCount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidBrandException {
        boolean valid = false;

        if(isValidBrand(brand)){
            this.brand = brand;
        }
        else{
            throw new InvalidBrandException("Brand must be one of the following: " + Arrays.toString(VALID_BRANDS));
        }
    }


    private static boolean isValidBrand(String brand) {
        boolean isValid = false;

        for (String validBrand : VALID_BRANDS) {
            if (validBrand.equalsIgnoreCase(brand)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public int getVolume() {
       return volume;
    }

    public void setVolume(int volume) throws IllegalArgumentException {
        if(MIN_VOLUME <= volume && volume <= MAX_VOLUME){
            this.volume = volume;
            isMuted = false;
        }
        else{
            throw new IllegalArgumentException(
                    String.format("Invalid volume: %s. Must be between %s and %s.\n",
                    volume, MIN_VOLUME, MAX_VOLUME));
            //System.out.println("Error, volume must be between " + MIN_VOLUME + " and " + MAX_VOLUME);
        }

    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    //toString
    @Override
    public String toString() {
        String volumeString = isMuted() ?  "<muted>" : String.valueOf(getVolume());

        return String.format("Television: brand= %s, volume= %s, display= %s",
                getBrand(), volumeString, getDisplay());

//        return ("Television brand = " + getBrand() +
//                ", volume= " + volumeString +
//                " Display = " + getDisplay());
                }

}