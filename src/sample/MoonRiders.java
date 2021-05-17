package sample;

public interface MoonRiders {
    Cell position();

    Cell[] way(String dest);
    default String icon(){
        return String.format(
                "$s.png",this.getClass().getSimpleName()
        );
    }

    MoonRiders copy(String dest);
}
