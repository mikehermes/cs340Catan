package client.MVC.join;

import client.MVC.base.*;
import client.MVC.data.*;
import client.MVC.misc.*;
import client.facade.Facade;
import shared.definitions.CatanColor;

import java.util.Observable;


/**
 * Implementation for the join game controller
 */
public class JoinGameController extends Controller implements IJoinGameController {

    private INewGameView newGameView;
    private ISelectColorView selectColorView;
    private IMessageView messageView;
    private IAction joinAction;

    /**
     * JoinGameController constructor
     *
     * @param view            Join game view
     * @param newGameView     New game view
     * @param selectColorView Select color view
     * @param messageView     Message view (used to display error messages that occur while the user is joining a game)
     */
    public JoinGameController(IJoinGameView view, INewGameView newGameView, ISelectColorView selectColorView, IMessageView messageView) {
        super(view);

        setNewGameView(newGameView);
        setSelectColorView(selectColorView);
        setMessageView(messageView);
    }

    public IJoinGameView getJoinGameView() {

        return (IJoinGameView) super.getView();
    }

    /**
     * Returns the action to be executed when the user joins a game
     *
     * @return The action to be executed when the user joins a game
     */
    public IAction getJoinAction() {

        return joinAction;
    }

    /**
     * Sets the action to be executed when the user joins a game
     *
     * @param value The action to be executed when the user joins a game
     */
    public void setJoinAction(IAction value) {

        joinAction = value;
    }

    public INewGameView getNewGameView() {

        return newGameView;
    }

    public void setNewGameView(INewGameView newGameView) {

        this.newGameView = newGameView;
    }

    public ISelectColorView getSelectColorView() {

        return selectColorView;
    }

    public void setSelectColorView(ISelectColorView selectColorView) {

        this.selectColorView = selectColorView;
    }

    public IMessageView getMessageView() {

        return messageView;
    }

    public void setMessageView(IMessageView messageView) {

        this.messageView = messageView;
    }

    @Override
    public void start() {
//        getJoinGameView()

        getJoinGameView().showModal();
    }

    @Override
    public void startCreateNewGame() {

        getNewGameView().showModal();
    }

    @Override
    public void cancelCreateNewGame() {

        getNewGameView().closeModal();
    }

    @Override
    public void createNewGame() {

        getNewGameView().closeModal();
    }

    @Override
    public void startJoinGame(GameInfo game) {

        getSelectColorView().showModal();
    }

    @Override
    public void cancelJoinGame() {

        getJoinGameView().closeModal();
    }

    @Override
    public void joinGame(CatanColor color) {

        System.out.println("Game Joining");

        // If join succeeded
        getSelectColorView().closeModal();
        getJoinGameView().closeModal();
        Facade.getInstance().gamesJoin(CatanColor.toString(color), 0);

    //to Add 3 extra players so that the game will actually play for testing
        Facade.getInstance().Login("Pete", "pete");
        Facade.getInstance().gamesJoin("red", 1);
        Facade.getInstance().Login("Mark", "mark");
        Facade.getInstance().gamesJoin("brown", 2);
        Facade.getInstance().Login("Brooke", "brooke");
        Facade.getInstance().gamesJoin("purple", 3);



        joinAction.execute();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

