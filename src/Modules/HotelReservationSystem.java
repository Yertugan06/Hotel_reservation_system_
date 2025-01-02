package Modules;

import java.util.HashMap;

public class HotelReservationSystem  {
    private int phone_number;
    private String name;
    private int twenty_four_hour_price = 20000;
    private int twelve_hour_price = 12000;
    private int one_hour_price = 1500;
    private int[][] rooms = new int[61][25]; // Room numbers from 1 to 60
    private HashMap<Integer, String> room_details = new HashMap<>();
    private Room room;
    private Booking booking;

    public HotelReservationSystem() {
    }

    public HotelReservationSystem(int phone_number, String name) {
        this.phone_number = phone_number;
        this.name = name;
        this.room = new Room(rooms, room_details);
        this.booking = new Booking(rooms);
    }

    public void put_information(int phone_number, String name, int room_number) {
        if (room_number < 1 || room_number >= rooms.length) {
            System.out.println("Invalid room number: " + room_number);
            return;
        }
        room_details.put(room_number, name + " - " + phone_number);
    }

    public void remove(int room_number) {
        if (!room_details.containsKey(room_number)) {
            System.out.println("Room number " + room_number + " is not assigned to any guest.");
            return;
        }
        room_details.remove(room_number);
    }

    public void free_room(String start_time, String end_time, int room_number) {
        room.free_room(start_time, end_time, room_number);
    }

    public void free_rooms(String start_time, String end_time) {
        room.free_rooms(start_time, end_time);
    }

    public void change_price(int time, int changing_price) {
        if (time == 24) {
            twenty_four_hour_price = changing_price;
        } else if (time == 12) {
            twelve_hour_price = changing_price;
        } else if (time == 1) {
            one_hour_price = changing_price;
        } else {
            wrong_input();
        }
    }

    public void get_price_list() {
        System.out.println("Price for 24 hours: " + twenty_four_hour_price + " tenge");
        System.out.println("Price for 12 hours: " + twelve_hour_price + " tenge");
        System.out.println("Price for 1 hour: " + one_hour_price + " tenge");
        System.out.println();
    }

    public static int needed_hours(String start_time, String end_time) {
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        int total_hours = end - start;
        if (total_hours < 0) {
            total_hours += 24;
        }
        return total_hours;
    }

    public void get_price(String start_time, String end_time) {
        booking.price(start_time, end_time, twenty_four_hour_price, twelve_hour_price, one_hour_price);
    }

    public void wrong_input() {
        System.out.println("Input is invalid. Please check the time or room number.");
    }

    public void get_room_details(int room_number) {
        System.out.println(room_details.getOrDefault(room_number, "No details available for this room"));
    }

    public String toString() {
        return "HotelReservationSystem{" + "phone_number=" + phone_number + ", name='" + name + '\'' + '}';
    }
}
