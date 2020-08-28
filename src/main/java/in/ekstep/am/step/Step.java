package in.ekstep.am.step;


public interface Step {
  void execute() throws Exception;
  void execute(String key) throws Exception;
}
