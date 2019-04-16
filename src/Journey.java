public class Journey {
    private String routeCode;
    // A unique identifier for a particular route

    private int delay;
    // Minutes late in arriving at the destination

    private boolean weatherRelated;
    // Equals true if the journey is affected by the weather,
    // otherwise false.

    public Journey(String a, int b, boolean c){
        this.routeCode = a;
        this.delay = b;
        this.weatherRelated = c;
    }
    // Constructor which initializes all 3 of the above data items
    
    // accessor and mutator methods.
    public int getDelay(){
        return this.delay;
    }

    public String getRouteCode(){
        return this.routeCode;
    }

    public boolean getWeatherRelated(){return this.weatherRelated;}
}