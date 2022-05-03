import java.util.*;

public class Level1
{
	public static int PrintingCosts(String Line) {
		Map<Integer, Integer> tonerConsumptionTable = new HashMap<Integer, Integer>(); 
		tonerConsumptionTable.put(32, 0);
		tonerConsumptionTable.put(38, 24);
		tonerConsumptionTable.put(44, 7);
		tonerConsumptionTable.put(50, 22);
		tonerConsumptionTable.put(56, 23);
		tonerConsumptionTable.put(62, 10);
		tonerConsumptionTable.put(68, 26);
		tonerConsumptionTable.put(74, 18);
		tonerConsumptionTable.put(80, 23);
		tonerConsumptionTable.put(86, 19);
		tonerConsumptionTable.put(92, 10);
		tonerConsumptionTable.put(98, 25);
		tonerConsumptionTable.put(104, 21);
		tonerConsumptionTable.put(110, 18);
		tonerConsumptionTable.put(116, 17);
		tonerConsumptionTable.put(122, 19);
		tonerConsumptionTable.put(33, 9);
		tonerConsumptionTable.put(39, 3);
		tonerConsumptionTable.put(45, 7);
		tonerConsumptionTable.put(51, 23);
		tonerConsumptionTable.put(57, 26);
		tonerConsumptionTable.put(63, 15);
		tonerConsumptionTable.put(69, 26);
		tonerConsumptionTable.put(75, 21);
		tonerConsumptionTable.put(81, 31);
		tonerConsumptionTable.put(87, 26);
		tonerConsumptionTable.put(93, 18);
		tonerConsumptionTable.put(99, 17);
		tonerConsumptionTable.put(105, 15);		
		tonerConsumptionTable.put(111, 20);
		tonerConsumptionTable.put(117, 17);
		tonerConsumptionTable.put(123, 18);
		tonerConsumptionTable.put(34, 6);
		tonerConsumptionTable.put(40, 12);
		tonerConsumptionTable.put(46, 4);
		tonerConsumptionTable.put(52, 21);
		tonerConsumptionTable.put(58, 8);
		tonerConsumptionTable.put(64, 32);
		tonerConsumptionTable.put(70, 20);
		tonerConsumptionTable.put(76, 16);
		tonerConsumptionTable.put(82, 28);
		tonerConsumptionTable.put(88, 18);
		tonerConsumptionTable.put(94, 7);
		tonerConsumptionTable.put(100, 25);
		tonerConsumptionTable.put(106, 20);
		tonerConsumptionTable.put(112, 25);
		tonerConsumptionTable.put(118, 13);
		tonerConsumptionTable.put(124, 12);
		tonerConsumptionTable.put(35, 24);
		tonerConsumptionTable.put(41, 12);
		tonerConsumptionTable.put(47, 10);
		tonerConsumptionTable.put(53, 27);
		tonerConsumptionTable.put(59, 11);
		tonerConsumptionTable.put(65, 24);
		tonerConsumptionTable.put(71, 25);
		tonerConsumptionTable.put(77, 28);
		tonerConsumptionTable.put(83, 25);
		tonerConsumptionTable.put(89, 14);
		tonerConsumptionTable.put(95, 8);
		tonerConsumptionTable.put(101, 23);
		tonerConsumptionTable.put(107, 21);
		tonerConsumptionTable.put(113, 25);
		tonerConsumptionTable.put(119, 19);
		tonerConsumptionTable.put(125, 18);
		tonerConsumptionTable.put(36, 29);
		tonerConsumptionTable.put(42, 17);
		tonerConsumptionTable.put(48, 22);
		tonerConsumptionTable.put(54, 26);
		tonerConsumptionTable.put(60, 10);
		tonerConsumptionTable.put(66, 29);
		tonerConsumptionTable.put(72, 25);
		tonerConsumptionTable.put(78, 25);
		tonerConsumptionTable.put(84, 16);
		tonerConsumptionTable.put(90, 22);
		tonerConsumptionTable.put(96, 3);
		tonerConsumptionTable.put(102, 18);
		tonerConsumptionTable.put(108, 16);
		tonerConsumptionTable.put(114, 13);
		tonerConsumptionTable.put(120, 13);
		tonerConsumptionTable.put(126, 9);
		tonerConsumptionTable.put(37, 22);
		tonerConsumptionTable.put(43, 13);
		tonerConsumptionTable.put(49, 19);
		tonerConsumptionTable.put(55, 16);
		tonerConsumptionTable.put(61, 14);
		tonerConsumptionTable.put(67, 20);
		tonerConsumptionTable.put(73, 18);
		tonerConsumptionTable.put(79, 26);
		tonerConsumptionTable.put(85, 23);
		tonerConsumptionTable.put(91, 18);
		tonerConsumptionTable.put(97, 23);
		tonerConsumptionTable.put(103, 30);
		tonerConsumptionTable.put(109, 22);
		tonerConsumptionTable.put(115, 21);
		tonerConsumptionTable.put(121, 24);
		
		int sumToner = 0;
		
		for (int i = 0; i < Line.length(); ++i) {
			int asciiCode = Line.charAt(i);
			sumToner += tonerConsumptionTable.get(asciiCode);
		}
		
		return sumToner;
	}
}