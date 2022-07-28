package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;


    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }


    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {

        return repo.getTickets();
    }

    public Ticket[] findAllTicketsSearch(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repo.getTickets()) {
            if (item.getDepartureAirport().equals(from) && item.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
