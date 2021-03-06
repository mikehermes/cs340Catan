package server.serverfacade;

import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import client.model.GameModel;
import client.model.bank.ResourceList;
import client.model.player.Player;

/**
 * Created by Josh on 3/10/2016.
 */
public class MockServerFacade implements IServerFacade {

    @Override
    public void userLogin(String username, String password) {

    }

    @Override
    public void userRegister(String username, String password) {

    }

    @Override
    public GameModel getList() {
        return null;
    }

    @Override
    public void createGame(String title, int id, Player[] players) {

    }

    @Override
    public void joinGame(int id, String color) {

    }

    @Override
    public void save(int id, String name) {

    }

    @Override
    public void load(String name) {

    }

    @Override
    public GameModel getModel() {
        return null;
    }

    @Override
    public void addAI(String AIType) {

    }

    @Override
    public void listAI() {

    }

    @Override
    public void sendChat(int playerIndex, String content) {

    }

    @Override
    public void rollNumber(int playerIndex, int number) {

    }

    @Override
    public void robPlayer(int plyerIndex, int victimIndex, HexLocation location) {

    }

    @Override
    public void finishTurn(int playerIndex) {

    }

    @Override
    public void buyDevCard(int playerIndex) {

    }

    @Override
    public void yearOfPlenty(int playerIndex, ResourceList res1, ResourceList res2) {

    }

    @Override
    public void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2) {

    }

    @Override
    public void soldier(int playerIndex, int victimIndex, HexLocation location) {

    }

    @Override
    public void monopoly(int playerIndex, String resource) {

    }

    @Override
    public void monument(int playerIndex) {

    }

    @Override
    public void buildRoad(int playerIndex, EdgeLocation roadLocation, Boolean free) {

    }

    @Override
    public void buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free) {

    }

    @Override
    public void buildCity(int playerIndex, VertexLocation vertexLocation) {

    }

    @Override
    public void offerTrade(int playerIndex, ResourceList offer, int receiver) {

    }

    @Override
    public void acceptTrade(int playerIndex, boolean willAccept) {

    }

    @Override
    public void maritimeTrade(int playerIndex, int ratio, String inputResource, String outputResource) {

    }

    @Override
    public void discardCards(int playerIndex, ResourceList discardedCards) {

    }
}
