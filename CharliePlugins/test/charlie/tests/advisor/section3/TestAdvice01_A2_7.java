package charlie.tests.advisor.section3;
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
public class TestAdvice01_A2_7 {
    @Test
    public void test() {
        IAdvisor advisor = new Advisor();
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand: Ace & 10
        hand.hit(new Card(Card.ACE, Card.Suit.HEARTS));
        hand.hit(new Card(10, Card.Suit.HEARTS));
        
        // Up card = Ace
        Play currentPlay = advisor.advise(hand, new Card(Card.ACE, Card.Suit.HEARTS));
        Play expectedPlay = Play.STAY;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
