package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticketForAdd) {
        Ticket ticket_1 = findById(ticketForAdd.getId());
        if (ticket_1 != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + ticketForAdd.getId() + " already exists"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticketForAdd;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket ticket_2 = findById(id);

        if (ticket_2 == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Ticket[] getSavedTickets() {
        return tickets;
    }

}

