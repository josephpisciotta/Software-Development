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
        
        if(upCard.value() <= 6){
            if(myHand.getValue() >= 13){
                return Play.STAY;
            }
            if(myHand.getValue() <= 12 && myHand.getValue() >= 5){
                if(myHand.getValue() <= 11 && myHand.getValue() >= 9){
                    if(upCard.value() == 2 && myHand.getValue() == 9)
                        return Play.HIT;
                    return Play.DOUBLE_DOWN;
                }
                if((upCard.value() <= 2 && myHand.getValue() == 12) || myHand.getValue() <= 8)
                    return Play.HIT;
            }
            
            return Play.STAY;
        }
        else{
            if(myHand.getValue() >= 17){
                return Play.STAY;
            }
            return Play.HIT;
        }
    }
}
