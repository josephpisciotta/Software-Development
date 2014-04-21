package charlie.tests.advisor.section2;
import charlie.advisor.Advisor;
import charlie.card.Card;
import charlie.card.Hand;
import charlie.card.Hid;
import charlie.dealer.Seat;
import charlie.plugin.IAdvisor;
import charlie.util.Play;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author josephpisciotta
 */
public class TestAdvice00_5_7 {
    @Test
    public void test() {
        IAdvisor advisor = new Advisor();
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand total = 10
        hand.hit(new Card(8, Card.Suit.HEARTS));
        hand.hit(new Card(2, Card.Suit.DIAMONDS));
        
        // Up card = A
        Play currentPlay = advisor.advise(hand, new Card(10, Card.Suit.HEARTS));
        Play expectedPlay = Play.HIT;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
