package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 2500, "DME", "LED", 120);
    Ticket ticket2 = new Ticket(2, 5000, "VKO", "VOG", 150);
    Ticket ticket3 = new Ticket(3, 3500, "DME", "LED", 130);
    Ticket ticket4 = new Ticket(4, 1500, "VKO", "VOG", 90);
    Ticket ticket5 = new Ticket(5, 5000, "DME", "LED", 150);
    Ticket ticket6 = new Ticket(6, 4500, "VKO", "VOG", 100);


    @BeforeEach
    public void SetUp() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
    }

    @Test
    //добавление нового билета
    public void shouldAddTicket() {
        Ticket ticket7 = new Ticket(7, 7000, "SVO", "KRR", 180);
        manager.add(ticket7);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.findAll();
    }

    @Test
        //Найти билеты DME -> LED
    void shouldFindDmeToLedTickets() {
        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket5};

        Ticket[] actual = manager.findAllTicketsSearch("DME", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
        //Найти билеты VKO -> VOG
    void shouldFindVkoToVogTickets() {
        Ticket[] expected = new Ticket[]{ticket4, ticket6, ticket2};

        Ticket[] actual = manager.findAllTicketsSearch("VKO", "VOG");

        assertArrayEquals(expected, actual);
    }

    @Test
        //Не должен искать билеты PES -> SVO
    void shouldNotFindAndSort() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAllTicketsSearch("PES", "SVO");

        assertArrayEquals(expected, actual);
    }

    @Test
        //Сортироввка билетов по цене
    void shouldSortTicketsByPrice() {
        Ticket[] expected = new Ticket[]{ticket4, ticket1, ticket3, ticket6, ticket2, ticket5};
        Ticket[] actual = repo.getTickets();
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
