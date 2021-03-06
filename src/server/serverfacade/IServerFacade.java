package server.serverfacade;

import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import client.model.GameModel;
import client.model.bank.ResourceList;
import client.model.player.Player;

/**
 * Created by Joshua on 3/9/2016.
 */
public interface IServerFacade 
{
	// user: total 2 methods
	void userLogin(String username, String password);
	void userRegister(String username, String password);
	//games: total 5 methods
	GameModel getList();
	void createGame(String title, int id, Player[] players);
	void joinGame(int id, String color);
	void save(int id, String name);
	void load(String name);
	//game: total 6 methods
	GameModel getModel();
	void addAI(String AIType);
	void listAI();
	//moves: total 17 methods
	void sendChat(int playerIndex, String content);
	void rollNumber(int playerIndex, int number);
	void robPlayer(int plyerIndex, int victimIndex, HexLocation location);
	void finishTurn(int playerIndex);
	void buyDevCard(int playerIndex);
	void yearOfPlenty(int playerIndex, ResourceList res1, ResourceList res2);
	void roadBuilding(int playerIndex, EdgeLocation spot1, EdgeLocation spot2);
	void soldier(int playerIndex, int victimIndex, HexLocation location);
	void monopoly(int playerIndex, String resource);
	void monument(int playerIndex);
	void buildRoad(int playerIndex, EdgeLocation roadLocation, Boolean free);
	void buildSettlement(int playerIndex, VertexLocation vertexLocation, boolean free);
	void buildCity(int playerIndex, VertexLocation vertexLocation);
	void offerTrade(int playerIndex, ResourceList offer, int receiver);
	void acceptTrade(int playerIndex, boolean willAccept);
	void maritimeTrade(int playerIndex, int ratio, String inputResource, String outputResource);
	void discardCards(int playerIndex, ResourceList discardedCards);
}
