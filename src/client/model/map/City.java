package client.model.map;

import client.model.map.VertexObject;
import shared.exceptions.IllegalMoveException;

public class City extends VertexObject {


	public boolean canPlaceAtLocation() throws IllegalMoveException
	{
		return false;
	}
	public void placeCity(){}
}
