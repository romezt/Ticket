package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 5000, "DME", "SVX", 180);
    private Ticket second = new Ticket(2, 3000, "SVX", "AER", 180);
    private Ticket third = new Ticket(3, 4000, "DME", "AER", 300);
    private Ticket fourth = new Ticket(4, 2000, "DME", "SVX", 180);

    @Test
    void searchByAirportOneTicket() {
        TicketManager tic = new TicketManager(repository);
        tic.add(first);
        tic.add(second);
        tic.add(third);
        tic.add(fourth);
        Ticket[] expected = tic.findAll("SVX", "AER");
        Ticket[] actual = new Ticket[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAirportTwoTicket() {
        TicketManager tic = new TicketManager(repository);
        tic.add(first);
        tic.add(second);
        tic.add(third);
        tic.add(fourth);
        Ticket[] expected = tic.findAll("DME", "SVX");
        Ticket[] actual = new Ticket[]{fourth, first};
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAirportNoTicket() {
        TicketManager tic = new TicketManager(repository);
        tic.add(first);
        tic.add(second);
        tic.add(third);
        tic.add(fourth);
        Ticket[] expected = tic.findAll("VKO", "SVX");
        Ticket[] actual = new Ticket[0];
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }

}