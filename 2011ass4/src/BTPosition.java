
public interface BTPosition extends Position {
  public void setElement(Object o);
  public BTPosition getLeft();
  public void setLeft(BTPosition v);
  public BTPosition getRight();
  public void setRight(BTPosition v);
  public BTPosition getParent();
  public void setParent(BTPosition v);
}
