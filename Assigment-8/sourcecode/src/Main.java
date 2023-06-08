

public class Main {
    public static void main(String args[]){
        //  public TestCases(String FileName)
		//  NOTE: X SIZE AND Y SIZE ARE DYNAMIC IN MY PROGRAM; YOU DON'T NEED TO DEFINE THEM
        new Thread(new TestCases("map01.txt")).start();
        new Thread(new TestCases("map02.txt")).start();
		new Thread(new TestCases("map03.txt")).start();
		new Thread(new TestCases("map04.txt")).start();
		new Thread(new TestCases("map05.txt")).start();
		new Thread(new TestCases("map06.txt")).start();
		new Thread(new TestCases("map07.txt")).start();
		new Thread(new TestCases("map08.txt")).start();
		new Thread(new TestCases("map09.txt")).start();
		new Thread(new TestCases("map10.txt")).start();
		new Thread(new TestCases("pisa.txt")).start();
		new Thread(new TestCases("tokyo.txt")).start();
		new Thread(new TestCases("triumph.txt")).start();
		new Thread(new TestCases("vatican.txt")).start();
    }
}

