public class TrainCompany {
    private String companyName;
    private String companyCode;
    private int numberOfJourneys;
    private Journey[] journeyHistory = new Journey[100000];
    private Codes[] allCodes = new Codes[10000];

    public TrainCompany(String x, String y) {
        this.companyName = x;
        this.companyCode = y;
        this.numberOfJourneys = 0;
    }

    public TrainCompany(){}
    // accessor and mutator methods


    public String getCompanyCode() {
        return this.companyCode;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public int getNumberOfJourneys(){
        return this.numberOfJourneys;
    }

    //seems to return a specified journey from the journey history, but it isn't a public method?
    Journey getJourney(int x)
    {
        return journeyHistory[x];
    }

    public void addJourney(Journey j) {
        journeyHistory[numberOfJourneys] = j;
        numberOfJourneys++;
    }

    public double averageDelay() {
        double average = 0;
        int numToAverage = 0;
        for(int n=0; n<this.numberOfJourneys; n++){
            if(!journeyHistory[n].getWeatherRelated()){
                average+=journeyHistory[n].getDelay();
                numToAverage++;
            }
        }
        return average/numToAverage;
    }
    // returns the average delay for all of a company’s journeys

    public String longestDelay(Codes[] c) {
        int n;
        int longestDelayJourney = 0;
        for(n=0; n<this.journeyHistory.length; n++){
            if(journeyHistory[n]==null){
                break;
            }else{
                if((!journeyHistory[n].getWeatherRelated())&&journeyHistory[n].getDelay()>journeyHistory[longestDelayJourney].getDelay()){
                    longestDelayJourney = n;
                }
            }
        }
        int i;
        for(i=0; i<allCodes.length; i++) {
            if (allCodes[i].getRouteCode().equals(journeyHistory[n].getRouteCode())) {
                break;
            }
        }
        return allCodes[i].getRouteName();
    }
    // returns the route name for the journey with the longest delay

    public String toString(Codes[] c) {
        return this.getCompanyName() + " : Average Delay = " + this.averageDelay() + " : Longest Delay = " + this.longestDelay(allCodes);
    }
}