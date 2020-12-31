
public interface Dictionary {
  // dictionary ADT
  public Entry insert(Object k, Object v) throws InvalidKeyException;
  public Entry remove(Entry ent) throws InvalidEntryException;
} // end of Dictionary class
