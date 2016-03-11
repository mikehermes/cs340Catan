package server.commandobjects.moves;

import client.model.bank.ResourceList;
import server.commandobjects.ICommand;

import java.lang.reflect.Type;

/**
 * Created by airho on 3/9/2016.
 */
public class OfferTrade implements ICommand {
    private int playerIndex;
    private int recieverIndex;
    private ResourceList offer;

    public OfferTrade(int playerIndex, int recieverIndex, ResourceList offer) {
        this.playerIndex = playerIndex;
        this.recieverIndex = recieverIndex;
        this.offer = offer;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }
}
