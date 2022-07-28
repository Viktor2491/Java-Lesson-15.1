package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

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
    //добавление по ид
    public void shouldFindById() {

        Ticket expected = ticket3;
        Ticket actual = repo.findById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //не должен добавлять по ид билета, который не добавлен
    public void shouldNotFindById() {

        Ticket expected = null;
        Ticket actual = repo.findById(10);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //удаление по ид
    public void shouldRemoveProductById() {
        repo.removeById(1);
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //отрицательный ид
    public void shouldRemoveProductById2() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-10);
        });
    }

    @Test
    //добавление билета по ид
    public void shouldAddProductById() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.getSavedTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    // не должен добавлять с таким же ид
    public void shouldNotAddSomeId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket2);
        });
    }
}
