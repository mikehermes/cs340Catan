package server.commandobjects.moves;

import server.commandobjects.ICommand;

import java.lang.reflect.Type;

/**
 * Created by airho on 3/9/2016.
 */
public class SendChat implements ICommand {
    private int playerIndex;
    private String content;

    public SendChat(int playerIndex, String content) {
        this.playerIndex = playerIndex;
        this.content = content;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }
}
