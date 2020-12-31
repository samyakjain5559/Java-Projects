
public class TreePrint {

public static void preorderPrint(AVLTree T, Position v) {
      if (T.isInternal(v))
         System.out.print(T.key(v).toString() + " ");
      if (T.hasLeft(v)) preorderPrint(T, T.left(v));
      if (T.hasRight(v)) preorderPrint(T, T.right(v));
}

public static void postorderPrint(AVLTree T, Position v) {
      if (T.hasLeft(v)) postorderPrint(T, T.left(v));
      if (T.hasRight(v)) postorderPrint(T, T.right(v));
      if (T.isInternal(v))
         System.out.print(T.key(v).toString() + " ");
}

}
