/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charlie.advisor;


import charlie.card.*;
import charlie.plugin.IAdvisor;
import charlie.util.Play;

/**
 *
 * @author josephpisciotta
 */
public class Advisor implements IAdvisor{
    
    // To make it easier 
    private final static Play H = Play.HIT;
    private final static Play S = Play.STAY;
    private final static Play D = Play.DOUBLE_DOWN;
    private final static Play P = Play.SPLIT;
    
    /**
     * Advisor - advise
     * @param myHand
     * @param upCard
     * @return Play
     */
    @Override
    public Play advise(Hand myHand, Card upCard){
        if(myHand.isPair())
            return getPlayForBSSection3(myHand,upCard);
        
        else if(myHand.size() == 2 && (myHand.getCard(0).isAce() || myHand.getCard(1).isAce()))
            return getPlayForBSSection2(myHand,upCard);
        
        return getPlayForBSSection1(myHand,upCard);
    }
    
    /**
     * getPlayForBSSection1
     * @param myHand
     * @param upCard
     * @return Play
     */
    private Play getPlayForBSSection1(Hand myHand, Card upCard) {
        //                          UP CARD
        // My Hand            2  3  4  5  6  7  8  9  T  A
        Play[] my17plus =   { S, S, S, S, S, S, S, S, S, S };
        Play[] my16 =       { S, S, S, S, S, H, H, H, H, H };
        Play[] my15 =       { S, S, S, S, S, H, H, H, H, H };
        Play[] my14 =       { S, S, S, S, S, H, H, H, H, H };
        Play[] my13 =       { S, S, S, S, S, H, H, H, H, H };        
        Play[] my12 =       { H, H, S, S, S, H, H, H, H, H }; 
        Play[] my11 =       { D, D, D, D, D, D, D, D, D, H };
        Play[] my10 =       { D, D, D, D, D, D, D, D, H, H };
        Play[] my9 =        { H, D, D, D, D, H, H, H, H, H };        
        Play[] my5t8 =      { H, H, H, H, H, H, H, H, H, H };
        
        Play[][] basicStrategy =
            { 
                my5t8,
                my9,
                my10,
                my11,
                my12,
                my13,
                my14,
                my15,
                my16,
                my17plus
            };
        
        // Dealer hand is the value less duece except if Ace which
        // is at the right side of the chart
        int column = upCard.value() - 2;
        
        if(upCard.isAce())
            column = my17plus.length - 1;
        
        int row;
        int handVal = myHand.getValue();
        if(handVal >= 5 && handVal<= 8)
            row = 0; 
        else if(handVal >= 17)
            row = basicStrategy.length - 1;
        else
            row = handVal - 8; 
        
        return basicStrategy[row][column];
    }

    /**
     * getPlayForBSSection2
     * @param myHand
     * @param upCard
     * @return Play
     */
    private Play getPlayForBSSection2(Hand myHand, Card upCard) {
        //                          UP CARD
        // My Hand            2  3  4  5  6  7  8  9  T  A
        Play[] myA8t10 =    { S, S, S, S, S, S, S, S, S, S };
        Play[] myA7 =       { S, D, D, D, D, S, S, H, H, H };
        Play[] myA6 =       { H, D, D, D, D, H, H, H, H, H };
        Play[] myA5 =       { H, H, D, D, D, H, H, H, H, H };
        Play[] myA4 =       { H, H, D, D, D, H, H, H, H, H };        
        Play[] myA3 =       { H, H, H, D, D, H, H, H, H, H };  
        Play[] myA2 =       { H, H, H, D, D, H, H, H, H, H };   
        
        Play[][] basicStrategy =
            {   
                myA2,
                myA3,
                myA4,
                myA5,
                myA6,
                myA7,
                myA8t10             
            };
        
        int column = upCard.value() - 2;
        
        if(upCard.isAce())
            column = myA2.length - 1;
        
        Card secondCard = myHand.getCard(1);
        int cardVal = secondCard.value();

        int row;
        if(cardVal >= 8)
            row = 6; 
        else
            row = cardVal - 2; 
        
        return basicStrategy[row][column];
    }
    
    /**
     * getPlayForBSSection3
     * @param myHand
     * @param upCard
     * @return Play
     */
    private Play getPlayForBSSection3(Hand myHand, Card upCard) {
        //                          UP CARD
        // My Hand            2  3  4  5  6  7  8  9  T  A
        Play[] myAA88 =     { P, P, P, P, P, P, P, P, P, P };
        Play[] my1010 =     { S, S, S, S, S, S, S, S, S, S };
        Play[] my99 =       { P, P, P, P, P, S, P, P, S, S };
        Play[] my77 =       { P, P, P, P, P, P, H, H, H, H };
        Play[] my66 =       { P, P, P, P, P, H, H, H, H, H };        
        Play[] my55 =       { D, D, D, D, D, D, D, D, H, H };  
        Play[] my44 =       { H, H, H, P, P, H, H, H, H, H };  
        Play[] my33 =       { P, P, P, P, P, P, H, H, H, H };  
        Play[] my22 =       { P, P, P, P, P, P, H, H, H, H };  
        
        Play[][] basicStrategy =
            {   my22,
                my33,
                my44,
                my55,
                my66,
                my77,
                myAA88,
                my99,
                my1010              
            };
        
        int column = upCard.value() - 2;
        
        if(upCard.isAce())
            column = myAA88.length - 1;
        
        Card pairCard = myHand.getCard(0);
        int cardVal = pairCard.value();

        int row = cardVal - 2;
        // Ace is same as 8 so 8 - 2 = 6
        if(pairCard.isAce())
            row = 6; 
                
        return basicStrategy[row][column];
    }
}
