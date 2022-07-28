package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int time;

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int time) {
        this.id = id;
        this.price = price;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    //Сделал не учитываемыми, т.к не задействованы по требованиям задания

    //   public void setId(int id) {
    //   this.id = id;
    //   }

    //  public int getPrice() {
    //     return price;
    // }

    //public void setPrice(int price) {
    //   this.price = price;
    // }

    // public void setDepartureAirport(String departureAirport) {
    //    this.departureAirport = departureAirport;
    //}

    // public void setArrivalAirport(String arrivalAirport) {
    //    this.arrivalAirport = arrivalAirport;
    // }

    // public int getTime(int time) {
    //   return time;
    // }

    //public void setTime(int time) {
    //  this.time = time;
    // }
}
