package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
  public Logger logger = LogManager.getLogger();
  protected int t = 0;
  protected final int duration;

  protected State(int Duration) {
    this.duration = Duration;
  }

  final State tick(Cat cat) {
    if (duration < 0) {
      logger.info("currently stuck in {}", getClass().getSimpleName());
      return this;
    }

    t = t+1;

    if (t < duration){
      logger.info("Still in {}", getClass().getSimpleName());
      return this;
    } else {
      return successor(cat);
    }
  }

  public abstract State successor(Cat cat);
}
