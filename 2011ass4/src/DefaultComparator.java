
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class DefaultComparator implements Comparator {

  public int compare(Object fst, Object snd) {

    Object a = fst;
    Object b = snd;
    if (fst instanceof Keyed)  a = ((Keyed)(fst)).key();
    if (snd instanceof Keyed)  b = ((Keyed)(snd)).key();
    if (a == b)
      return 0;
    else if ((a instanceof String) && (b instanceof String)) {
      return ((String)(a)).compareTo((String)(b));
    }
    else if ((a instanceof Number) && (b instanceof Number)) {
      double diff = ((Number)(a)).doubleValue() - 
        ((Number)(b)).doubleValue();
      if (diff < 0.0) return -1; 
      else if (diff > 0.0) return 1; 
      else return 0;
    }
    else if (a.equals(b))
      return 0;
    else 
      return a.hashCode() - b.hashCode();
  }
}
