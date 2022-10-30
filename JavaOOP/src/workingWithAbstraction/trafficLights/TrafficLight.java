package workingWithAbstraction.trafficLights;

public class TrafficLight {
    private Color color;


    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.valueOf(this.color);
    }

    public void changeColor(){
        switch (color){
            case RED :
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color=Color.YELLOW;
                break;
            case YELLOW:
                this.color=Color.RED;
                break;
        }
    }
}
