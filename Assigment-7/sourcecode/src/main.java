package src;

/**
 * The main class contains code for testing different sorting algorithms on various input strings and
 * measuring their running times.
 */
public class main 
{

	public static void main(String[] args) 
	{ 
		String errorCase   = "*-  *--++ ..,; %+^^ '% :";
		String bestCase    = "aibjcdef bcdjef cdef def ef f";
		String worstCase   = "fedcjbia bcdjef cdef def ef f";
		String avarageCase = "aijcbfde bcdjef cdef def ef f";

		boolean error;
		boolean best;
		boolean worst;
		boolean avarage;

		myMap errorMap = new myMap();
		if(!errorMap.buildMap(errorCase)){
			System.out.println("Failed to create error map..\n");
			error = false;
		}
		else{
			error = true;
			System.out.println("created.Error\n");
		}

		myMap bestMap = new myMap();
		if(!bestMap.buildMap(bestCase)){
			System.out.println("Failed to create best map..\n");
			best = false;
		}
		else
			best = true;

		myMap worstMap = new myMap();
		if(!worstMap.buildMap(worstCase)){
			System.out.println("Failed to create worst map..\n");
			worst = false;
		}
		else
			worst = true;

		myMap avarageMap = new myMap();
		if(!avarageMap.buildMap(avarageCase)){
			System.out.println("Failed to create avarage map..\n");
			avarage = false;
		}
		else
			avarage = true;


		System.out.println("\n\nerror-case Input String:    " + errorCase);
		System.out.println("best-case Input String:     " + bestCase);
		System.out.println("worst-case Input String:    " + worstCase);
		System.out.println("avarage-case Input String:  " + avarageCase);

		long startTimeMergeBest = 0;
		long endTimeMergeBest = 0;
		long totalTimeMergeBest = 0;
		long startTimeSelectionBest = 0;
		long endTimeSelectionBest = 0;
		long totalTimeSelectionBest = 0;
		long startTimeInsertionBest = 0;
		long endTimeInsertionBest = 0;
		long totalTimeInsertionBest = 0;
		long startTimeBubbleBest = 0;
		long endTimeBubbleBest = 0;
		long totalTimeBubbleBest = 0;
		long startTimeQuickBest = 0;
		long endTimeQuickBest = 0;
		long totalTimeQuickBest = 0;
		long startTimeMergeWorst = 0;
		long endTimeMergeWorst = 0;
		long totalTimeMergeWorst = 0;
		long startTimeSelectionWorst= 0;
		long endTimeSelectionWorst= 0;
		long totalTimeSelectionWorst= 0;
		long startTimeInsertionWorst = 0;
		long endTimeInsertionWorst = 0;
		long totalTimeInsertionWorst = 0;
		long startTimeBubbleWorst = 0;
		long endTimeBubbleWorst = 0;
		long totalTimeBubbleWorst = 0;
		long startTimeQuickWorst = 0;
		long endTimeQuickWorst = 0;
		long totalTimeQuickWorst = 0;
		long startTimeMergeAvarage = 0;
		long endTimeMergeAvarage = 0;
		long totalTimeMergeAvarage = 0;
		long startTimeSelectionAvarage = 0;
		long endTimeSelectionAvarage = 0;
		long totalTimeSelectionAvarage = 0;
		long startTimeInsertionAvarage = 0;
		long endTimeInsertionAvarage = 0;
		long totalTimeInsertionAvarage = 0;
		long startTimeBubbleAvarage = 0;
		long endTimeBubbleAvarage = 0;
		long totalTimeBubbleAvarage = 0;
		long startTimeQuickAvarage = 0;
		long endTimeQuickAvarage = 0;
		long totalTimeQuickAvarage = 0;

		if(best)
		{
			MergeSort msBest        = new MergeSort(bestMap);
			SelectionSort ssBest    = new SelectionSort(bestMap);
			InsertionSort isBest    = new InsertionSort(bestMap);
			BubbleSort bsBest       = new BubbleSort(bestMap);
			QuickSort qsBest        = new QuickSort(bestMap);
			//-------------------------------------------------c
			startTimeMergeBest = System.nanoTime();
			msBest.sort();
			endTimeMergeBest   = System.nanoTime();
			totalTimeMergeBest = endTimeMergeBest - startTimeMergeBest;
			startTimeSelectionBest = System.nanoTime();
			ssBest.sort();
			endTimeSelectionBest   = System.nanoTime();
			totalTimeSelectionBest = endTimeSelectionBest - startTimeSelectionBest;
			startTimeInsertionBest = System.nanoTime();
			isBest.sort();
			endTimeInsertionBest   = System.nanoTime();
			totalTimeInsertionBest = endTimeInsertionBest - startTimeInsertionBest;
			startTimeBubbleBest = System.nanoTime();
			bsBest.sort();
			endTimeBubbleBest   = System.nanoTime();
			totalTimeBubbleBest = endTimeBubbleBest - startTimeBubbleBest;
			startTimeQuickBest = System.nanoTime();
			qsBest.sort();
			endTimeQuickBest   = System.nanoTime();
			totalTimeQuickBest = endTimeQuickBest - startTimeQuickBest;
			//-------------------------------------------------c
			System.out.println("\n\nOriginal best-case senario map:\n\n");
			msBest.printOriginalArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nMERGE SORT:");
			System.out.println("best-senario:\n");
			msBest.printSortedArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nSELECTION SORT:");
			System.out.println("best-senario:\n");
			ssBest.printSortedArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nINSERTION SORT:");
			System.out.println("best-senario:\n");
			ssBest.printSortedArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nBUBBLE SORT:");
			System.out.println("best-senario:\n");
			bsBest.printSortedArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nQUICK SORT:");
			System.out.println("best-senario:\n");
			qsBest.printSortedArray();

		}

		if(worst)
		{
			MergeSort msWorst       = new MergeSort(worstMap);
			SelectionSort ssWorst   = new SelectionSort(worstMap);
			InsertionSort isWorst   = new InsertionSort(worstMap);
			BubbleSort bsWorst      = new BubbleSort(worstMap);
			QuickSort qsWorst       = new QuickSort(worstMap);
			//-------------------------------------------------c
			startTimeMergeWorst = System.nanoTime();
			msWorst.sort();
			endTimeMergeWorst   = System.nanoTime();
			totalTimeMergeWorst = endTimeMergeWorst - startTimeMergeWorst;
			startTimeSelectionWorst = System.nanoTime();
			ssWorst.sort();
			endTimeSelectionWorst   = System.nanoTime();
			totalTimeSelectionWorst = endTimeSelectionWorst - startTimeSelectionWorst;
			startTimeInsertionWorst = System.nanoTime();
			isWorst.sort();
			endTimeInsertionWorst   = System.nanoTime();
			totalTimeInsertionWorst = endTimeInsertionWorst - startTimeInsertionWorst;
			startTimeBubbleWorst = System.nanoTime();
			bsWorst.sort();
			endTimeBubbleWorst   = System.nanoTime();
			totalTimeBubbleWorst = endTimeBubbleWorst - startTimeBubbleWorst;
			startTimeQuickWorst = System.nanoTime();
			qsWorst.sort();
			endTimeQuickWorst   = System.nanoTime();
			totalTimeQuickWorst = endTimeQuickWorst - startTimeQuickWorst;
			//-------------------------------------------------c
			System.out.println("\n\nOriginal worst-case senario map:\n\n");
			msWorst.printOriginalArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nMERGE SORT:");
			System.out.println("worst-senario:\n");
			msWorst.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nSELECTION SORT:");
			System.out.println("worst-senario:\n");
			ssWorst.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nINSERTION SORT:");
			System.out.println("worst-senario:\n");
			ssWorst.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nBUBBLE SORT:");
			System.out.println("worst-senario:\n");
			bsWorst.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nQUICK SORT:");
			System.out.println("worst-senario:\n");
			qsWorst.printSortedArray();

		}

		if(avarage)
		{
			MergeSort msAvarage     = new MergeSort(avarageMap);
			SelectionSort ssAvarage = new SelectionSort(avarageMap);
			InsertionSort isAvarage = new InsertionSort(avarageMap);
			BubbleSort bsAvarage    = new BubbleSort(avarageMap);
			QuickSort qsAvarage     = new QuickSort(avarageMap);
			//-------------------------------------------------c
			startTimeMergeAvarage = System.nanoTime();
			msAvarage.sort();
			endTimeMergeAvarage   = System.nanoTime();
			totalTimeMergeAvarage = endTimeMergeAvarage - startTimeMergeAvarage;
			startTimeSelectionAvarage = System.nanoTime();
			ssAvarage.sort();
			endTimeSelectionAvarage   = System.nanoTime();
			totalTimeSelectionAvarage = endTimeSelectionAvarage - startTimeSelectionAvarage;
			startTimeInsertionAvarage = System.nanoTime();
			isAvarage.sort();
			endTimeInsertionAvarage   = System.nanoTime();
			totalTimeInsertionAvarage = endTimeInsertionAvarage - startTimeInsertionAvarage;
			startTimeBubbleAvarage = System.nanoTime();
			bsAvarage.sort();
			endTimeBubbleAvarage   = System.nanoTime();
			totalTimeBubbleAvarage = endTimeBubbleAvarage - startTimeBubbleAvarage;
			startTimeQuickAvarage = System.nanoTime();
			qsAvarage.sort();
			endTimeQuickAvarage   = System.nanoTime();
			totalTimeQuickAvarage = endTimeQuickAvarage - startTimeQuickAvarage;
			//-------------------------------------------------c
			System.out.println("\n\nOriginal avarage-case senario map:\n\n");
			msAvarage.printOriginalArray();

			System.out.println("-------------------------------------------------");
			System.out.println("\nMERGE SORT:");
			System.out.println("avarage-senario:\n");
			msAvarage.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nSELECTION SORT:");
			System.out.println("avarage-senario:\n");
			ssAvarage.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nINSERTION SORT:");
			System.out.println("avarage-senario:\n");
			ssAvarage.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nBUBBLE SORT:");
			System.out.println("avarage-senario:\n");
			bsAvarage.printSortedArray();
			System.out.println("-------------------------------------------------");
			System.out.println("\nQUICK SORT:");
			System.out.println("avarage-senario:\n");
			qsAvarage.printSortedArray();
			System.out.println("-------------------------------------------------");

		}
		

		System.out.println("-------------------------------------------------");
		System.out.println("\nMerge SORT \n");
		System.out.print("best-case running time result:    " + totalTimeMergeBest    + " nanosec. \n");
		System.out.print("worst-case running time result:   " + totalTimeMergeWorst   + " nanosec. \n");
		System.out.print("avarage-case running time result: " + totalTimeMergeAvarage + " nanosec. \n");

		System.out.println("-------------------------------------------------");
		System.out.println("\nSelection SORT");
		System.out.print("best-case running time result:    " + totalTimeSelectionBest    + " nanosec. \n");
		System.out.print("worst-case running time result:   " + totalTimeSelectionWorst   + " nanosec. \n");
		System.out.print("avarage-case running time result: " + totalTimeSelectionAvarage + " nanosec. \n");

		System.out.println("-------------------------------------------------");
		System.out.println("\nInsertion SORT");
		System.out.print("best-case running time result:    " + totalTimeInsertionBest    + " nanosec. \n");
		System.out.print("worst-case running time result:   " + totalTimeInsertionWorst   + " nanosec. \n");
		System.out.print("avarage-case running time result: " + totalTimeInsertionAvarage + " nanosec. \n");
		
		System.out.println("-------------------------------------------------");
		System.out.println("\nBubble SORT");
		System.out.print("best-case running time result:    " + totalTimeBubbleBest    + " nanosec. \n");
		System.out.print("worst-case running time result:   " + totalTimeBubbleWorst   + " nanosec. \n");
		System.out.print("avarage-case running time result: " + totalTimeBubbleAvarage + " nanosec. \n");
		
		System.out.println("-------------------------------------------------");
		System.out.println("\nQuick SORT");
		System.out.print("best-case running time result:    " + totalTimeQuickBest    + " nanosec. \n");
		System.out.print("worst-case running time result:   " + totalTimeQuickWorst   + " nanosec. \n");
		System.out.print("avarage-case running time result: " + totalTimeQuickAvarage + " nanosec. \n");
	}
}