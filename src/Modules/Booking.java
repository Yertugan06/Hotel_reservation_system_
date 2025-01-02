package Modules;

public class Booking extends HotelReservationSystem implements ReservationSystem {
    private int[][] rooms;

    public Booking(int[][] rooms) {
        this.rooms = rooms;
    }


    public void price(String start_time, String end_time, int twenty_four_hour_price, int twelve_hour_price, int one_hour_price) {
        int needed_hours = HotelReservationSystem.needed_hours(start_time, end_time);
        int total_price = twenty_four_hour_price * (needed_hours / 24)
                + twelve_hour_price * ((needed_hours % 24) / 12)
                + one_hour_price * (needed_hours % 12);
        System.out.println("Total price is: " + total_price + " tenge");
    }
}
