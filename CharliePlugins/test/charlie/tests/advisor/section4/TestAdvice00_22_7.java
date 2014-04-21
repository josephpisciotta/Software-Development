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
public class TestAdvice00_22_7 {
    @Test
    public void test() {
        IAdvisor advisor = new Advisor();
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand: 9 & 9
        hand.hit(new Card(9, Card.Suit.CLUBS));
        hand.hit(new Card(9, Card.Suit.HEARTS));
        
        // Up card = 8
        Play currentPlay = advisor.advise(hand, new Card(8, Card.Suit.HEARTS));
        Play expectedPlay = Play.SPLIT;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
