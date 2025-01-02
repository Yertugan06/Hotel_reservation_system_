package Modules;

public class Guest {
    private String name;
    private int phone_number;
    private int room_number;


    public Guest(String name, int phone_number, int room_number) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Guest name cannot be null or empty.");
        }
        if (phone_number <= 0) {
            throw new IllegalArgumentException("Phone number must be a positive integer.");
        }
        if (room_number <= 0) {
            throw new IllegalArgumentException("Room number must be a positive integer.");
        }

        this.name = name;
        this.phone_number = phone_number;
        this.room_number = room_number;
    }

    public String get_name() {
        return name;
    }

    public int getPhoneNumber() {
        return phone_number;
    }

    public int getRoomNumber() {
        return room_number;
    }


    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Guest name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setPhoneNumber(int phone_number) {
        if (phone_number <= 0) {
            System.out.println("Guest name cannot be null or empty.");
        }
        this.phone_number = phone_number;
    }

    public void setRoomNumber(int room_number) {
        if (room_number <= 0) {
            System.out.println("Guest name cannot be null or empty.");
        }
        this.room_number = room_number;
    }

    @Override
    public String toString() {
        return "Guest{name='" + name + "', phone number=" + phone_number + ", room number=" + room_number + '}';
    }
}
