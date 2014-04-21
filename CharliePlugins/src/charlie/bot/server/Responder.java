/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charlie.bot.server;

import charlie.advisor.Advisor;
import charlie.card.Card;
import charlie.card.Hand;
import charlie.dealer.Dealer;
import charlie.plugin.IPlayer;
import charlie.util.Play;

/**
 *
 * @author josephpisciotta
 */
class Responder implements Runnable {
    private final IPlayer b9;
    private final Hand myHand;
    private final Dealer dealer;
    private final Hand dealerHand;
    private final Advisor advisor;
    private final int THINK;
    public Responder(B9 aThis, Hand mH, Dealer d, Hand dH) {
        b9 = aThis;
        myHand = mH;
        dealer = d;
        dealerHand = dH;
        advisor = new Advisor();
        THINK = (int) (Math.random() * (6000 - 2000));
    }
    @Override
    public void run() {

        Card dealerUpCard = dealerHand.getCard(dealerHand.size() - 1);
        Play[] plays = {Play.DOUBLE_DOWN, Play.HIT, Play.NONE, Play.SPLIT, Play.STAY};
        
        // pick a random play number
        int randomPlay = (int) (Math.random() * plays.length);
        // randomly choose if bot will listen to the advisor
        boolean randomChoice = (THINK % (Math.random() * 10) == 0);        

        Play chosenPlay;

        // if bot is listening to advise
        //      perform that play
        // if it is not
        //      perform the randomly selected play 
        if (randomChoice) {
            chosenPlay = plays[randomPlay];
        } else {
            chosenPlay = this.advisor.advise(this.myHand, dealerUpCard);
        }

        // make the bot have a random delay
        // imitation of thinking, used to slow game
        try {
            Thread.sleep(THINK);
        } catch (InterruptedException e) {
            
        }

        // have dealer perform the action that the bot chose, if it is
        // allowed. May need to correct the choice if trandomly selected
        // is not allowed at the time.
        if (myHand.size() == 2 && chosenPlay == Play.DOUBLE_DOWN) {
            dealer.doubleDown(b9, myHand.getHid());
        } 
        
        else if (chosenPlay == Play.SPLIT) {
            if (myHand.size() == 2 && myHand.getValue() == 11) {
                dealer.doubleDown(b9, myHand.getHid());
            } 
            
            else if ((myHand.getValue() <= 16 && dealerUpCard.value() >= 7 && dealerUpCard.value() <= 11) || myHand.getValue() <= 10) {
                dealer.hit(b9, myHand.getHid());
            } 
            
            else if (myHand.getValue() >= 17 || (myHand.getValue() <= 16 && dealerUpCard.value() <= 6)) {
                dealer.stay(b9, myHand.getHid());
            }
        } 
        
        else if (chosenPlay == Play.STAY) {
            dealer.stay(b9, myHand.getHid());
        } 
        
        else {
            dealer.hit(b9, myHand.getHid());
        }
    }
}
