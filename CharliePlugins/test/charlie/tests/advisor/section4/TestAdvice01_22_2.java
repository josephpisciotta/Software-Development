package charlie.tests.advisor.section4;
import charlie.advisor.Advisor;
import charlie.card.Card;
import charlie.card.Hand;
import charlie.card.Hid;
import charlie.dealer.Seat;
import charlie.plugin.IAdvisor;
import charlie.util.Play;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author josephpisciotta
 */
public class TestAdvice01_22_2 {
    @Test
    public void test() {
        IAdvisor advisor = new Advisor();
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand: 10 & 10
        hand.hit(new Card(10, Card.Suit.CLUBS));
        hand.hit(new Card(10, Card.Suit.HEARTS));
        
        // Up card = 2
        Play currentPlay = advisor.advise(hand, new Card(2, Card.Suit.HEARTS));
        Play expectedPlay = Play.STAY;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
