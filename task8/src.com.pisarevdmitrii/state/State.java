package state;

/**
 * todo Document type State
 */
interface State {

    String getName();

    void freeze(StateContext context);

    void heat(StateContext context);
}
