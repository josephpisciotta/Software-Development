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

    /**
     *
     * @param myHand
     * @param upCard
     * @return
     */
    @Override
    public Play advise(Hand myHand, Card upCard){
        // Left side of table
        if(upCard.value() <= 6){
            // Your hand >= 12
            if(myHand.getValue() >= 12){
                if(upCard.value() <= 3 && myHand.getValue() == 12)
                    return Play.HIT;
                return Play.STAY;
            }
            // Between 5 and 12
            if(myHand.getValue() < 12 && myHand.getValue() >= 5){
                // Between 9 and 11 unless that one hit space
                if(myHand.getValue() <= 11 && myHand.getValue() >= 9){
                    if(upCard.value() == 2 && myHand.getValue() == 9)
                        return Play.HIT;
                    return Play.DOUBLE_DOWN;
                }
                return Play.HIT;
            }            
            
            return Play.STAY;
        }
        // Right side of table
        else{
            if(myHand.getValue() >= 17){
                return Play.STAY;
            }
            return Play.HIT;
        }
    }
}
