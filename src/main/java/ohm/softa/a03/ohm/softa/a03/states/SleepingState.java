package ohm.softa.a03.ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class SleepingState extends State {

  SleepingState(int duration) {
    super(duration);
  }

  @Override
  public State successor(Cat cat) {
    logger.info("Good Morning! Need some Coffee");
    return new HungryState(cat.getAwake());
  }
}
