package Modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem(123456789, "Hotel A");
        String file_path = "src/Sources/Guests.txt";

        try {
            Scanner sc = new Scanner(new File(file_path));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] guest_info = line.split(",");
                int phone_number = Integer.parseInt(guest_info[0]);
                String guest_name = guest_info[1];
                int guest_room = Integer.parseInt(guest_info[2]);
                hotel.put_information(phone_number, guest_name, guest_room);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        hotel.free_rooms("10:00", "18:00");
        hotel.free_room("12:00", "16:00", 1);
        hotel.get_price("12:00", "16:00");
        hotel.get_price_list();
        System.out.println("Needed hours: " + hotel.needed_hours("12:00", "01:00"));
        hotel.change_price(1, 1600);
        hotel.change_price(2, 1600);
        hotel.get_room_details(5);
        hotel.get_room_details(20);
    }
}
