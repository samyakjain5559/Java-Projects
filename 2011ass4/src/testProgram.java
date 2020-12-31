/***********************************
*
* EECS2011 - Assignment 4
* File name: testProgram.java
*
************************************/


import java.io.*; 	// to read/write files

public class testProgram {

   public static void printOutput(AVLTree t){
        System.out.print("Preorder : ");
        TreePrint.preorderPrint(t, t.root());
        System.out.println();
        System.out.print("Postorder: ");
        TreePrint.postorderPrint(t, t.root());
        System.out.println();
        System.out.println();
   }


   public static void main (String[] args) throws IOException{

  	AVLTree t = new AVLTree();

        System.out.println("Single rotation - Right");
        System.out.println("Test case 1a:");

	t.insert(30, 30);
        t.insert(40, 40);
        t.insert(50, 50);  
	printOutput(t);

        System.out.println("Test case 1b:");
        t.insert(60, 60);
        t.insert(70, 70);
        printOutput(t);

        System.out.println("Test case 1c:");
        t.insert(80, 80);
        printOutput(t);

        System.out.println("Test case 1d:");
        t.insert(90, 90);
        printOutput(t);

	//------------------------------------------
        AVLTree t2 = new AVLTree();
        System.out.println("---------------------------");
        System.out.println("Single rotation - Left");

        System.out.println("Test case 2a:");
        t2.insert(90, 90);
        t2.insert(80, 80);
        t2.insert(70, 70);
        printOutput(t2);

        System.out.println("Test case 2b:");
        t2.insert(60, 60);
        t2.insert(50, 50);
        printOutput(t2);

        System.out.println("Test case 2c:");
        t2.insert(40, 40);
        printOutput(t2);

        System.out.println("Test case 2d:");
        t2.insert(30, 30);
        printOutput(t2);

        //------------------------------------------
        AVLTree t3 = new AVLTree();
        System.out.println("---------------------------");
        System.out.println("Double rotation >");

        System.out.println("Test case 3a:");
        t3.insert(30, 30);
        t3.insert(40, 40);
        t3.insert(35, 35);
        printOutput(t3);

        System.out.println("Test case 3b:");
        t3.insert(50, 50);
        t3.insert(45, 45);
        printOutput(t3);

        System.out.println("Test case 3c:");
        t3.insert(38, 38);
        printOutput(t3);

        System.out.println("Test case 3d:");
        t3.insert(48, 48);
        printOutput(t3);

        //------------------------------------------
        AVLTree t4 = new AVLTree();
        System.out.println("---------------------------");
        System.out.println("Double rotation <");

        System.out.println("Test case 4a:");
        t4.insert(50, 50);
        t4.insert(40, 40);
        t4.insert(45, 45);
        printOutput(t4);

        System.out.println("Test case 4b:");
        t4.insert(30, 30);
        t4.insert(35, 35);
        printOutput(t4);

        System.out.println("Test case 4c:");
        t4.insert(42, 42);
        printOutput(t4);

        System.out.println("Test case 4d:");
        t4.insert(32, 32);
        printOutput(t4);

   } // method main

} // class myProgram
