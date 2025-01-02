package Modules;

import java.util.HashMap;

public class Room extends HotelReservationSystem implements ReservationSystem {
    private int[][] rooms;
    private HashMap<Integer, String> room_details;

    public Room(int[][] rooms, HashMap<Integer, String> room_details) {
        this.rooms = rooms;
        this.room_details = room_details;
    }

    @Override
    public void free_room(String start_time, String end_time, int room_number) {
        if (room_number < 1 || room_number >= rooms.length) {
            System.out.println("Invalid room number: " + room_number);
            return;
        }
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (end < start) {
            end += 24;
        }
        for (int i = start; i < end; i++) {
            rooms[room_number][i % 24] = 0;
        }
        System.out.println("Room " + room_number + " is now free.");
    }

    @Override
    public void free_rooms(String start_time, String end_time) {
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (end < start) {
            end += 24;
        }
        System.out.println("Available rooms:");
        for (int room = 1; room < rooms.length; room++) {
            boolean is_free = true;
            for (int i = start; i < end; i++) {
                if (rooms[room][i % 24] == 1) {
                    is_free = false;
                    break;
                }
            }
            if (is_free) {
                System.out.println("Room " + room);
            }
        }
    }
}
