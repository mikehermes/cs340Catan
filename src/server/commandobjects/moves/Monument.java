package server.commandobjects.moves;

import server.commandobjects.ICommand;

import java.lang.reflect.Type;

/**
 * Created by airho on 3/9/2016.
 */
public class Monument implements ICommand {
    private int playerIndex;

    public Monument(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }
}
