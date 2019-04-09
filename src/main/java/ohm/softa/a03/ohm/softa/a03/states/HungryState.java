package ohm.softa.a03.ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {

  HungryState(int duration) {
    super(duration);
  }

  @Override
  public State successor(Cat cat) {
    logger.info("Need ... some ... foooood ..... ");
    return new DeathState();
  }

  public State feed(Cat cat) {
    logger.info("nom nom nom...");
    return new DigestingState(cat.getDigest(), duration - t);
  }
}
