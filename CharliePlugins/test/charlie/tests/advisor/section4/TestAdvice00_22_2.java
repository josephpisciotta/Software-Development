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
public class TestAdvice00_22_2 {
    @Test
    public void test() {
        IAdvisor advisor = new Advisor();
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand: 5 & 5
        hand.hit(new Card(5, Card.Suit.HEARTS));
        hand.hit(new Card(5, Card.Suit.SPADES));
        
        // Up card = 4
        Play currentPlay = advisor.advise(hand, new Card(4, Card.Suit.HEARTS));
        Play expectedPlay = Play.DOUBLE_DOWN;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
