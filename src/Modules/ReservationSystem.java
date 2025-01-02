package Modules;

public interface ReservationSystem {
    void put_information(int phone_number, String name, int room_number);
    void remove(int room_number);
    void free_room(String start_time, String end_time, int room_number);
    void free_rooms(String start_time, String end_time);

}
