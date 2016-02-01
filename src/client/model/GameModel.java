/**
 * Roll = resourceList/player what are we returning and passing around?
 *
 * CanMoveRobber calls canRelocateRobber, move it to a valid hex location (can't be4 where it was and can't be an ocean tile
 *
 * Monopoly - send a player a resource type, return the number they have (delete those resources)
 *              send a player a resource type and an int, increase the resource by that
 * RoadBuilding - canRB - make sure there are 2 roads to be played and the card
 * Soldier - have a knight card?
 */


package client.model;

import client.model.bank.Bank;
import client.model.bank.ResourceList;
import client.model.map.*;
import client.model.misc.*;
import client.model.player.Player;
import org.omg.CORBA.DynAnyPackage.Invalid;
import shared.exceptions.*;
import shared.definitions.*;

public class GameModel {
    private Map map;
    Bank bank;
    Player[] players;
    TurnTracker tt;
    TradeOffer to;
    int version = 0;
    int winner = -1;
    Dice dice;


    /**
     * updates version of the game model
     */
    public void updateVersion() {
        version++;
    }


    /**
     * Checks to see if the player can win the game
     *
     * @return boolean whether or not the player can win (have 10 victory points)
     */
    public boolean canWin()
    {
        //need to check if it is finish turn?
        int cp = tt.getCurrentPlayer();
        if(players[cp].canWin())
            return true;
        return false;
    }

    /**
     * decides game winner and sets the winner to the id of the winning player
     *
     */
    public void decideWinner() throws InvalidWinnerException
    {
        int cp = tt.getCurrentPlayer();
        if(players[cp].canWin())
            winner = cp;
        if(winner != -1)
            players[winner].win();
        else
            throw new InvalidWinnerException("No winner yet!");

    }

    /**
     * This is used to see when the robber moves if the player can discard
     *
     * @return
     */
    public boolean canRobberDiscard()
    {
        return false;
    }

    /**
     * Checks to see if building a road is a legal move for the player
     *
     * @return boolean whether or not the player can build a road
     */
    public boolean canBuildRoad()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canBuildRoad();
    }

    /**
     * Checks to see if placing a road is a legal move for the player
     *
     * @return boolean whether or not the player can place a road
     */
    public boolean canPlaceRoad()
    {
        return map.canAddRoad();
    }

    /**
     * Places a Road at a given location on the map
     *
     * @return boolean whether or not the player built the road (perhaps placeholder return values for all of the do methods)
     */
    public void placeRoad(EdgeLocation el) throws InvalidPositionException
    {
        int cp = tt.getCurrentPlayer();
        if(players[cp].canBuildRoad() && map.canAddRoad(el))
            map.addRoad(el, cp);
        else
            throw new InvalidPositionException("Error Building a Road");
    }
    /**
     * Checks to see if building a settlement is a legal move for the player
     *
     * @return boolean whether or not the player can build a settlement
     */
    public boolean canBuildSettlement()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canBuildSettlement();
    }

    /**
     * Checks to see if placing a settlement is a legal move for the player
     *
     * @return boolean whether or not the player can place a settlement
     */
    public boolean canPlaceSettlement(EdgeLocation el)
    {
        return map.canAddSettlement(el, tt.getCurrentPlayer());
    }

    /**
     * Places a Settlement at a given location on the map
     *
     * @return boolean whether or not the player placed a settlement
     */
    public void placeSettlement(EdgeLocation el) throws InvalidPositionException
    {
        int cp = tt.getCurrentPlayer();
        if(players[cp].canBuildSettlement() && map.canAddSettlement(el))
            map.addSettlement(el, cp);
        else
            throw new InvalidPositionException("Error Building a Settlement");
    }

    /**
     * Checks to see if building a city is a legal move for the player
     *
     * @return boolean whether or not the player can build a city
     */
    public boolean canBuildCity()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canBuildCity();
    }

    /**
     * Checks to see if placing a city is a legal move for the player
     *
     * @return boolean whether or not the player can place a city
     */
    public boolean canPlaceCity()
    {
        return map.canAddCity();
    }

    /**
     * Places a City at a given location on the map
     *
     * @return boolean whether or not the player placed the city
     */
    public void placeCity(EdgeLocation el) throws InvalidPositionException
    {
        int cp = tt.getCurrentPlayer();
        if(players[cp].canBuildCity() && map.canAddCity(el))
            map.addCity(el, cp);
        else
            throw new InvalidPositionException("Error building a City");
    }

    /**
     * Checks to see if buying a Developement Card is a legal move for the player
     *
     * @return boolean whether or not the player can buy a Developement card
     */
    public boolean canBuyDevcard()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canBuyDevcard();
    }

    /**
     * Checks to see if playing a Developement Card is a legal move for the player
     *
     * @return boolean whether or not the player can play a Developement card
     */
    public boolean canPlayDevcard()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canPlayDevcard();
    }

    /**
     * Checks to see if Montoply is a legal move for the player
     *
     * @return boolean whether or not the player can monopoly
     */
    public boolean canMonopoly()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canMonopoly();
    }

    /**
     * Checks to see if building a road in a specific place is a legal move for the player
     *
     * @return boolean whether or not the player can road building
     */
    public boolean canRoadBuilding()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canRoadBuilding();
    }

    /**
     * Checks to see if placing a Monument Card(?) is a legal move for the player
     *
     * @return boolean whether or not the player can place a monument
     */
    public boolean canPlaceMonument()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canPlaceMonument();
    }

    /**
     * Checks to see if placing a Year Of Plenty card is a legal move for the player
     *
     * @return boolean whether or not the player can play the Year of Plenty card
     */
    public boolean canYearOfPlenty()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canYearOfPlenty();
    }

    /**
     * Checks to see if placing a Soldier card is a legal move for the player
     *
     * @return boolean whether or not the player can place the Soldier card
     */
    public boolean canPlaceSoldier()
    {
        int cp = tt.getCurrentPlayer();
        return players[cp].canPlaceSoldier();
    }

    public boolean canFinishTurn()
    {
        return (tt.getStatus() == 3);
    }

    public boolean canDiscardCards()
    {

        return false;
    }
    /**
     * Checks to see if robbing another player is a legal move for the player
     * @return boolean whether or not the player can rob another player
     */
    public int[] canRob()
    {
        //find who can be robbed
        int[] ids = new int[3];
        int currId = 0;
        for(int i = 0; i < players.length; i++)
            if(i != tt.getCurrentPlayer() && players[i].canRob())
                ids[currId++] = i;
        if(currId == 3)
            return ids;

        //if not all players are possibilities then make a smaller array with the possibilities
        int[] possibilities = new int[currId+1];
        for(int i = 0; i < possibilities.length; i++)
            possibilities[i] = ids[i];
        return possibilities;
    }

    /**
     * Checks to see if moving the robber is a legal move for the player
     *
     * @return boolean whether or not the player can move the robber
     */
    public boolean canMoveRobber(HexLocation hl)
    {
        return map.canRelocateRobber(hl);
    }

    /**
     *Set up the TradeOffer
     */
    public void TradePlayer() throws IllegalMoveException, InsufficientResourcesException
    {
        if(tt.getStatus() != 1)
            throw new IllegalMoveException("not the trading phase");

        to =  players[tt.getCurrentPlayer()].tradeOffer();

    }

    /**
     * Checks to see if trading resources with the bank is a legal move for the player
     *
     * @return boolean whether or not the player can trade with the bank
     */
    public boolean canTradeBank() {
        return false;
    }

    /**
     * Checks to see accepting a trade request is a legal move for the player
     *
     * @return boolean whether or not the player can accept a trade offer from another player
     */
    public boolean canAcceptTrade() {
        return false;
    }

    /**
     * Checks to see if the player can roll the dice
     *
     * @return boolean whether or not the player can roll the dice
     */
    public boolean canRoll()
    {
        if(tt.getStatus() == 0)
            return true;
        return false;
    }

    //do methods
    /**
     * Buys a developement card and increases the amount for the purchasing player
     *
     * @return boolean whether or not the player bought the dev card
     */
    public void buyDevCard() throws IllegalMoveException
    {
        //be in the purchasing phase
        int cp = tt.getCurrentPlayer();
        if(tt.getStatus() != 2)
            throw new IllegalMoveException("Not a purchasing phase...");
        if(!players[cp].canBuyDevcard())
            throw new IllegalMoveException("Not enough resources");
        DevCardType dct = bank.BuyDevCard();
        players[cp].drawDevCard(dct);
    }

    /**
     * uses Monopoly
     *
     * @return boolean whether or not the player played a monopoly
     */
    public void playMonopoly(ResourceType r)
    {
        //use the ResourceList.merge method
        int cp = tt.getCurrentPlayer();

        int given = 0;
        for(int i = 0; i < players.length; i++)
            if(i != cp)
                given += players[i].Monopolize(r);
        players[cp].addResources(r, given);
    }

    /**
     * plays the road build card
     *
     * @return boolean
     */
    public void playRoadBuilding()
    {
        int cp = tt.getCurrentPlayer();
        players[cp].playRoadBuilding();
    }

    /**
     * plays a monument card
     *
     * @return boolean whether or not the player placed a monument
     */
    public boolean placeMonument() {
        return false;
    }

    /**
     * plays the year of plenty card for a given player
     *
     * @return boolean whether or not the player played the year of plenty card
     */
    public boolean playYearOfPlenty() {
        return false;
    }

    /**
     * Places a Soldier and grants the effects he brings
     *
     * @return boolean whether or not the player played the soldier card
     */
    public boolean placeSoldier() {
        return false;
    }

    /**
     * Robs a player of one resource card
     *
     * @return boolean whether or not the player chose to rob
     */
    public boolean rob() {
        return false;
    }

    /**
     * Places a the robber at a specific location on the map
     *
     * @return boolean whether or not the player moved the robber
     */
    public boolean moveRobber() {
        return false;
    }

    /**
     * enacts the trade offer of the specified player
     *
     * @return boolean whether or not the player traded with another player
     */
    public boolean tradePlayer() {
        return false;
    }

    /**
     * completes a transaction of resources with the bank
     *
     * @return boolean whether or not the player traded with the bank
     */
    public boolean tradeBank() {
        return false;
    }

    /**
     * accepts the trade offer of another player
     *
     * @return boolean whether or not the player accepted a trade offer
     */
    public boolean acceptTrade() {
        return false;
    }

    /**
     * rolls the dice for a number 1-12
     *
     * @return boolean whether or not the player rolled the dice
     */
    public boolean roll()
    {
        if(tt.getStatus() != 0)
            return false;
        int cp = tt.getCurrentPlayer();
        int diceRoll = dice.rollDice();

        ResourceList[] pids = map.rollingDice(diceRoll);
        for(int i = 0; i < pids.length; i++)
            players[i].addResources(pids[i]);

        tt.updateStatus();
        return true;
    }

}
